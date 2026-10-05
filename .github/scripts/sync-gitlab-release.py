"""Put the current GitHub Release jars on GitLab, replacing that tag's files.

The push mirror only copies commits and tags. This script runs after the
GitHub Release exists. It deletes the GitLab release links and the generic
package for the same tag, then uploads the given files and links only those.

  sync-gitlab-release.py --self-test
  sync-gitlab-release.py --project-path
  sync-gitlab-release.py --clear
  sync-gitlab-release.py <assets-directory>

Environment: GITLAB_TOKEN, REPO_NAME, and for --clear / publish also TAG.
Publish also reads RELEASE_META, a JSON file from `gh release view --json name,body`.
"""

import json
import os
import sys
import urllib.error
import urllib.parse
import urllib.request
from pathlib import Path

API = "https://gitlab.com/api/v4"
PACKAGE_NAME = "release"
USER_AGENT = "Nergan/minecraft-mods"


def encode_segment(value):
    return urllib.parse.quote(str(value), safe="")


def package_file_url(project_id, tag, filename):
    return (
        f"{API}/projects/{project_id}/packages/generic/{PACKAGE_NAME}/"
        f"{encode_segment(tag)}/{encode_segment(filename)}"
    )


def pick_project(repo_name, rows):
    matches = [
        project
        for project in rows
        if str(project.get("path_with_namespace", "")).startswith("naragan/")
        and (project.get("name") == repo_name or project.get("path") == repo_name)
    ]
    if len(matches) > 1:
        raise SystemExit("several GitLab projects match this repository name")
    if len(matches) == 1:
        return matches[0]
    return None


def package_ids_for_tag(packages, tag):
    return [
        package["id"]
        for package in packages
        if package.get("package_type") == "generic"
        and package.get("name") == PACKAGE_NAME
        and package.get("version") == tag
    ]


def link_ids(release):
    links = (release.get("assets") or {}).get("links") or []
    return [link["id"] for link in links if "id" in link]


def asset_files(directory):
    files = [path for path in Path(directory).iterdir() if path.is_file()]
    if not files:
        raise SystemExit(f"no release files in {directory}")
    return sorted(files, key=lambda path: path.name)


def release_links(project_id, tag, filenames):
    return [
        {
            "name": name,
            "url": package_file_url(project_id, tag, name),
            "filepath": f"/{name}",
            "link_type": "package",
        }
        for name in filenames
    ]


def call(token, url, method="GET", payload=None, data=None, content_type=None):
    headers = {"PRIVATE-TOKEN": token, "User-Agent": USER_AGENT}
    body = data
    if payload is not None:
        body = json.dumps(payload).encode("utf-8")
        headers["Content-Type"] = "application/json"
    elif content_type:
        headers["Content-Type"] = content_type
    request = urllib.request.Request(url, data=body, headers=headers, method=method)
    try:
        with urllib.request.urlopen(request) as response:
            return response.status, response.read()
    except urllib.error.HTTPError as error:
        return error.code, error.read()


def show(code, body, method, url):
    text = body.decode("utf-8", "replace")
    print(f"HTTP {code} {method} {url}", file=sys.stderr)
    print(text[:2000], file=sys.stderr)


def must(code, body, method, url, ok=(200, 201, 202, 204)):
    if code not in ok:
        show(code, body, method, url)
        raise SystemExit(1)


def parse(body, code, method, url):
    if not body:
        return None
    try:
        return json.loads(body.decode("utf-8"))
    except json.JSONDecodeError:
        show(code, body, method, url)
        raise SystemExit(1)


def require_env(name):
    value = os.environ.get(name, "")
    if not value:
        raise SystemExit(f"{name} is empty")
    return value


def resolve_project(token, repo_name):
    direct_url = f"{API}/projects/{encode_segment('naragan/' + repo_name)}"
    code, body = call(token, direct_url)
    if code == 200:
        return parse(body, code, "GET", direct_url)
    if code != 404:
        show(code, body, "GET", direct_url)
        raise SystemExit(1)
    search = urllib.parse.urlencode(
        {"search": repo_name, "owned": "true", "simple": "true", "per_page": "100"}
    )
    search_url = f"{API}/projects?{search}"
    code, body = call(token, search_url)
    must(code, body, "GET", search_url)
    found = pick_project(repo_name, parse(body, code, "GET", search_url) or [])
    if found is None:
        raise SystemExit(
            f"GitLab project naragan/{repo_name} was not found. The mirror step creates it."
        )
    print(f"GitLab project {repo_name} is at naragan/{found['path']}.", file=sys.stderr)
    return found


def tag_exists(token, project_id, tag):
    url = f"{API}/projects/{project_id}/repository/tags/{encode_segment(tag)}"
    code, body = call(token, url)
    if code == 200:
        return True
    if code == 404:
        return False
    show(code, body, "GET", url)
    raise SystemExit(1)


def get_release(token, project_id, tag):
    url = f"{API}/projects/{project_id}/releases/{encode_segment(tag)}"
    code, body = call(token, url)
    if code == 200:
        return parse(body, code, "GET", url)
    if code == 404:
        return None
    show(code, body, "GET", url)
    raise SystemExit(1)


def delete_links(token, project_id, tag, release):
    for link_id in link_ids(release or {}):
        url = (
            f"{API}/projects/{project_id}/releases/{encode_segment(tag)}"
            f"/assets/links/{link_id}"
        )
        code, body = call(token, url, method="DELETE")
        if code in (200, 204, 404):
            print("deleted link", link_id)
            continue
        show(code, body, "DELETE", url)
        raise SystemExit(1)


def delete_release(token, project_id, tag):
    url = f"{API}/projects/{project_id}/releases/{encode_segment(tag)}"
    code, body = call(token, url, method="DELETE")
    if code in (200, 204, 404):
        print("deleted release", tag, code)
        return
    show(code, body, "DELETE", url)
    raise SystemExit(1)


def list_packages(token, project_id):
    found = []
    page = 1
    while True:
        query = urllib.parse.urlencode(
            {
                "package_type": "generic",
                "package_name": PACKAGE_NAME,
                "per_page": "100",
                "page": str(page),
            }
        )
        url = f"{API}/projects/{project_id}/packages?{query}"
        code, body = call(token, url)
        must(code, body, "GET", url)
        rows = parse(body, code, "GET", url) or []
        if not rows:
            return found
        found.extend(rows)
        if len(rows) < 100:
            return found
        page += 1


def delete_packages(token, project_id, tag):
    for package_id in package_ids_for_tag(list_packages(token, project_id), tag):
        url = f"{API}/projects/{project_id}/packages/{package_id}"
        code, body = call(token, url, method="DELETE")
        if code in (200, 204, 404):
            print("deleted package", package_id)
            continue
        show(code, body, "DELETE", url)
        raise SystemExit(1)


def upload_file(token, project_id, tag, path):
    url = package_file_url(project_id, tag, path.name)
    code, body = call(
        token,
        url,
        method="PUT",
        data=path.read_bytes(),
        content_type="application/octet-stream",
    )
    if code == 400 and any(word in body.lower() for word in (b"already", b"duplicate")):
        delete_packages(token, project_id, tag)
        code, body = call(
            token,
            url,
            method="PUT",
            data=path.read_bytes(),
            content_type="application/octet-stream",
        )
    must(code, body, "PUT", url)
    print("uploaded", path.name)


def create_release(token, project_id, tag, name, description, links):
    url = f"{API}/projects/{project_id}/releases"
    payload = {
        "name": name,
        "tag_name": tag,
        "description": description,
        "assets": {"links": links},
    }
    code, body = call(token, url, method="POST", payload=payload)
    must(code, body, "POST", url, ok=(200, 201))
    print("created release", tag)


def clear_release(token, repo_name, tag):
    project = resolve_project(token, repo_name)
    project_id = project["id"]
    release = get_release(token, project_id, tag)
    delete_links(token, project_id, tag, release)
    if release is not None:
        delete_release(token, project_id, tag)
    delete_packages(token, project_id, tag)


def publish_release(token, repo_name, tag, assets_dir, meta_path):
    project = resolve_project(token, repo_name)
    project_id = project["id"]
    if not tag_exists(token, project_id, tag):
        raise SystemExit(f"Tag {tag} is not on GitLab yet, so a release cannot be attached.")
    meta = json.loads(Path(meta_path).read_text(encoding="utf-8"))
    name = meta.get("name") or tag
    description = meta.get("body") or ""
    files = asset_files(assets_dir)
    release = get_release(token, project_id, tag)
    delete_links(token, project_id, tag, release)
    if release is not None:
        delete_release(token, project_id, tag)
    delete_packages(token, project_id, tag)
    for path in files:
        upload_file(token, project_id, tag, path)
    create_release(
        token,
        project_id,
        tag,
        name,
        description,
        release_links(project_id, tag, [path.name for path in files]),
    )


def self_test():
    assert encode_segment("a+b.jar") == "a%2Bb.jar"
    url = package_file_url(15, "v1.0.0", "fabric-api-0.116.17+1.21.1.jar")
    assert "/packages/generic/release/v1.0.0/" in url
    assert "fabric-api-0.116.17%2B1.21.1.jar" in url
    assert pick_project("new-name", [{"path_with_namespace": "naragan/old", "name": "new-name", "path": "old", "id": 3}])["path"] == "old"
    assert pick_project("missing", []) is None
    try:
        pick_project("same", [
            {"path_with_namespace": "naragan/a", "name": "same", "path": "a"},
            {"path_with_namespace": "naragan/b", "name": "same", "path": "b"},
        ])
    except SystemExit as error:
        assert "several" in str(error)
    else:
        raise SystemExit("expected several matches to fail")
    packages = [
        {"id": 1, "package_type": "generic", "name": "release", "version": "v1.0.0"},
        {"id": 2, "package_type": "generic", "name": "release", "version": "v0.9.0"},
        {"id": 3, "package_type": "maven", "name": "release", "version": "v1.0.0"},
    ]
    assert package_ids_for_tag(packages, "v1.0.0") == [1]
    release = {"assets": {"links": [{"id": 8, "name": "old.jar"}, {"id": 9, "name": "keep.jar"}]}}
    assert link_ids(release) == [8, 9]
    links = release_links(15, "v1.0.0", ["old.jar", "new.jar"])
    assert [link["name"] for link in links] == ["old.jar", "new.jar"]
    assert links[0]["filepath"] == "/old.jar"
    print("self-test ok")


def main(argv):
    if "--self-test" in argv:
        self_test()
        return 0
    token = require_env("GITLAB_TOKEN")
    repo_name = require_env("REPO_NAME")
    if "--project-path" in argv:
        print(resolve_project(token, repo_name)["path"])
        return 0
    tag = require_env("TAG")
    if "--clear" in argv:
        clear_release(token, repo_name, tag)
        return 0
    if len(argv) != 2:
        raise SystemExit("usage: sync-gitlab-release.py <assets-directory>")
    publish_release(token, repo_name, tag, argv[1], require_env("RELEASE_META"))
    return 0


if __name__ == "__main__":
    sys.exit(main(sys.argv[1:]))
