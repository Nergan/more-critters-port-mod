#!/usr/bin/env python3
"""Replace GitHub Releases, one page per Minecraft version and loader.

Each subdirectory of the given root is one release. The directory name is
the git tag, for example minecraft-1.21.1-neoforge. title.txt is one line,
the release name. body.md is the description. Every *.jar in the directory
is uploaded. all-jars.zip is rebuilt from those jars so the whole set can
be downloaded as one file.

A push updates these same tags. It does not create another release for the
same version and loader. Assets that are not in the directory are removed.

LEGACY_TAG, when set, is deleted after the new pages exist. That removes
the old single release such as v1.0.0.

GITHUB_SHA is the commit the tags point at. gh must already be authenticated.
"""

import json
import os
import pathlib
import subprocess
import sys
import urllib.error
import urllib.parse
import urllib.request
import zipfile


def run(args, check=True):
    print("+", " ".join(args))
    return subprocess.run(args, check=check)


def release_exists(tag):
    result = subprocess.run(
        ["gh", "release", "view", tag],
        stdout=subprocess.DEVNULL,
        stderr=subprocess.DEVNULL,
    )
    return result.returncode == 0


def has_glob_meta(name):
    return any(char in name for char in "*?[]")


def github_token():
    token = (os.environ.get("GH_TOKEN") or os.environ.get("GITHUB_TOKEN") or "").strip()
    if token:
        return token
    result = subprocess.run(["gh", "auth", "token"], check=True, capture_output=True, text=True)
    token = result.stdout.strip()
    if not token:
        raise SystemExit("GH_TOKEN is empty")
    return token


def upload_literal_name(tag, path):
    # gh release upload treats []*? as a glob, so a literal name like
    # born_in_chaos_[Neoforge]_1.21.1_1.7.6.jar never matches the file.
    listed = subprocess.run(
        ["gh", "api", f"repos/{{owner}}/{{repo}}/releases/tags/{tag}"],
        check=True,
        capture_output=True,
        text=True,
    )
    release = json.loads(listed.stdout)
    for asset in release.get("assets", []):
        if asset.get("name") == path.name:
            run([
                "gh", "api", "--method", "DELETE",
                f"repos/{{owner}}/{{repo}}/releases/assets/{asset['id']}",
            ])
    upload_url = release["upload_url"].split("{", 1)[0]
    url = upload_url + "?" + urllib.parse.urlencode({"name": path.name})
    request = urllib.request.Request(
        url,
        data=path.read_bytes(),
        method="POST",
        headers={
            "Authorization": f"Bearer {github_token()}",
            "Accept": "application/vnd.github+json",
            "Content-Type": "application/octet-stream",
        },
    )
    try:
        with urllib.request.urlopen(request) as response:
            response.read()
    except urllib.error.HTTPError as error:
        detail = error.read().decode("utf-8", "replace")[:500]
        raise SystemExit(f"upload {path.name}: HTTP {error.code} {detail}") from error


def upload_assets(tag, paths):
    plain = [path for path in paths if not has_glob_meta(path.name)]
    special = [path for path in paths if has_glob_meta(path.name)]
    if plain:
        run(["gh", "release", "upload", tag, *[str(path) for path in plain], "--clobber"])
    for path in special:
        print("upload", path.name)
        upload_literal_name(tag, path)


def version_key(tag):
    # minecraft-1.21.1-neoforge -> (1, 21, 1)
    name = tag.removeprefix("minecraft-")
    version = name.rsplit("-", 1)[0]
    parts = []
    for piece in version.split("."):
        digits = ""
        for char in piece:
            if char.isdigit():
                digits += char
            else:
                break
        parts.append(int(digits) if digits else 0)
    return parts


def loader_rank(tag):
    loader = tag.rsplit("-", 1)[-1]
    return {"neoforge": 0, "forge": 1, "fabric": 2}.get(loader, 9)


def zip_jars(directory, jars):
    destination = directory / "all-jars.zip"
    if destination.exists():
        destination.unlink()
    with zipfile.ZipFile(destination, "w", compression=zipfile.ZIP_DEFLATED) as archive:
        for jar in jars:
            archive.write(jar, jar.name)
    return destination


def publish(directory, sha, latest):
    tag = directory.name
    title = (directory / "title.txt").read_text(encoding="utf-8").strip()
    body = directory / "body.md"
    if not title:
        raise SystemExit(f"{tag}: title.txt is empty")
    if not body.is_file():
        raise SystemExit(f"{tag}: body.md is missing")
    jars = sorted(path for path in directory.glob("*.jar") if path.is_file())
    if not jars:
        raise SystemExit(f"{tag}: no jars")
    bundle = zip_jars(directory, jars)
    keep = [path.name for path in jars] + [bundle.name]

    run(["git", "tag", "-f", tag, sha])
    run(["git", "push", "-f", "origin", f"refs/tags/{tag}"])

    latest_flag = "--latest" if latest else "--latest=false"
    if release_exists(tag):
        run([
            "gh", "release", "edit", tag,
            "--title", title,
            "--notes-file", str(body),
            "--target", sha,
            latest_flag,
        ])
    else:
        run([
            "gh", "release", "create", tag,
            "--title", title,
            "--notes-file", str(body),
            "--target", sha,
            latest_flag,
        ])

    listed = subprocess.run(
        [
            "gh", "release", "view", tag, "--json", "assets",
            "--jq", '.assets[] | [.name, (.id | tostring)] | @tsv',
        ],
        check=True,
        capture_output=True,
        text=True,
    )
    for line in listed.stdout.splitlines():
        if not line.strip():
            continue
        name, asset_id = line.split("\t", 1)
        if name in keep:
            continue
        print("delete", tag, name)
        if has_glob_meta(name):
            run([
                "gh", "api", "--method", "DELETE",
                f"repos/{{owner}}/{{repo}}/releases/assets/{asset_id}",
            ])
        else:
            run(["gh", "release", "delete-asset", tag, name, "--yes"])

    upload_assets(tag, [*jars, bundle])


def main():
    if len(sys.argv) != 2:
        raise SystemExit("usage: publish-split-releases.py <directory>")
    root = pathlib.Path(sys.argv[1])
    sha = os.environ.get("GITHUB_SHA", "").strip()
    if not sha:
        raise SystemExit("GITHUB_SHA is empty")
    pages = sorted(path for path in root.iterdir() if path.is_dir())
    if not pages:
        raise SystemExit(f"no release directories in {root}")
    newest = max(pages, key=lambda path: (version_key(path.name), -loader_rank(path.name)))
    for page in pages:
        publish(page, sha, latest=page == newest)

    legacy = os.environ.get("LEGACY_TAG", "").strip()
    if legacy:
        print("delete legacy", legacy)
        run(["gh", "release", "delete", legacy, "--yes", "--cleanup-tag"], check=False)


if __name__ == "__main__":
    main()
