"""Free Modrinth version numbers so the next publish replaces files.

Modrinth answers HTTP 400 if a DELETE would remove the project's last
version. This script never does that. When every listed version is one we
are about to publish again, it renames one version to
``<number>-replaced-<id>`` (32 character limit), deletes the others, and
writes that id to ``release-assets/modrinth-delete-after-publish.txt``.
After mc-publish creates the new versions, run:

    replace-modrinth-versions.py --finish release-assets/modrinth-delete-after-publish.txt

A missing version is not an error. The response body of any other HTTP
error is printed. MODRINTH_TOKEN must be set.

    replace-modrinth-versions.py <project-id> <version-number> [...]
    replace-modrinth-versions.py --self-test
"""

import json
import os
import sys
import urllib.error
import urllib.request

CLEANUP_NAME = "release-assets/modrinth-delete-after-publish.txt"
API = "https://api.modrinth.com/v2"
TOKEN = os.environ.get("MODRINTH_TOKEN", "")
HEADERS = {
    "Authorization": TOKEN,
    "User-Agent": "Nergan/minecraft-mods",
}


def spare_number(version_number, version_id):
    candidate = f"{version_number}-replaced-{version_id}"
    if len(candidate) <= 32:
        return candidate
    short = f"replaced-{version_id}"
    if len(short) > 32:
        raise SystemExit(f"version id is too long to rename: {version_id}")
    return short


def call(url, method="GET", payload=None):
    headers = dict(HEADERS)
    data = None
    if payload is not None:
        data = json.dumps(payload).encode("utf-8")
        headers["Content-Type"] = "application/json"
    request = urllib.request.Request(url, data=data, headers=headers, method=method)
    try:
        with urllib.request.urlopen(request) as response:
            return response.status, response.read()
    except urllib.error.HTTPError as error:
        return error.code, error.read()


def show(code, body, method, url):
    text = body.decode("utf-8", "replace")
    print(f"HTTP {code} {method} {url}")
    print(text[:2000])


def must(code, body, method, url, ok=(200, 204)):
    if code not in ok:
        show(code, body, method, url)
        raise SystemExit(1)


def list_versions(project):
    code, body = call(f"{API}/project/{project}/version?limit=100")
    must(code, body, "GET", f"{API}/project/{project}/version")
    return json.loads(body.decode("utf-8"))


def delete_version(version_id):
    url = f"{API}/version/{version_id}"
    code, body = call(url, method="DELETE")
    if code in (200, 204, 404):
        print("deleted", version_id, code)
        return
    show(code, body, "DELETE", url)
    raise SystemExit(1)


def is_target(version, wanted):
    number = version.get("version_number") or ""
    if number in wanted:
        return True
    return any(number.startswith(f"{item}-replaced-") or number == f"replaced-{version.get('id')}" for item in wanted)


def prepare(project, wanted):
    versions = list_versions(project)
    targets = [item for item in versions if is_target(item, wanted)]
    keepers = [item for item in versions if item not in targets]
    print("versions", [(item.get("version_number"), item.get("id")) for item in versions])
    cleanup = []
    if keepers:
        for item in targets:
            print("delete", item.get("version_number"), item["id"])
            delete_version(item["id"])
    elif targets:
        renamed = [item for item in targets if "-replaced-" in (item.get("version_number") or "") or (item.get("version_number") or "").startswith("replaced-")]
        fresh = [item for item in targets if item not in renamed]
        survivor = (renamed or fresh)[0]
        number = survivor.get("version_number") or ""
        if number in wanted:
            new_number = spare_number(number, survivor["id"])
            print("rename", number, survivor["id"], "->", new_number)
            url = f"{API}/version/{survivor['id']}"
            code, body = call(url, method="PATCH", payload={"version_number": new_number})
            must(code, body, "PATCH", url)
        for item in targets:
            if item["id"] == survivor["id"]:
                continue
            print("delete", item.get("version_number"), item["id"])
            delete_version(item["id"])
        cleanup.append(survivor["id"])
        print("delete after publish", survivor["id"])
    else:
        print("no matching versions")
    os.makedirs(os.path.dirname(CLEANUP_NAME), exist_ok=True)
    with open(CLEANUP_NAME, "w", encoding="utf-8", newline="\n") as handle:
        handle.write("".join(f"{item}\n" for item in cleanup))


def finish(path):
    if not os.path.isfile(path):
        print("no cleanup file")
        return
    with open(path, encoding="utf-8") as handle:
        ids = [line.strip() for line in handle if line.strip()]
    if not ids:
        print("nothing to delete")
        return
    code, body = call(f"{API}/version/{ids[0]}")
    if code == 404:
        print("renamed version already gone", ids[0])
        return
    must(code, body, "GET", f"{API}/version/{ids[0]}")
    project_id = json.loads(body.decode("utf-8"))["project_id"]
    versions = list_versions(project_id)
    survivors = [item for item in versions if item.get("id") not in set(ids)]
    if not survivors:
        print("Refusing to delete the only remaining Modrinth version.")
        raise SystemExit(1)
    for version_id in ids:
        delete_version(version_id)


def self_test():
    assert spare_number("1.0.0", "BMELvObk") == "1.0.0-replaced-BMELvObk"
    assert len(spare_number("1.0.0-fabric", "BMELvObk")) <= 32
    assert spare_number("x" * 20, "BMELvObk") == "replaced-BMELvObk"
    sample = {"version_number": "1.0.0-replaced-BMELvObk", "id": "BMELvObk"}
    assert is_target(sample, {"1.0.0", "1.0.0-fabric"})
    assert not is_target({"version_number": "0.9.0", "id": "AAAAAAAA"}, {"1.0.0"})
    print("ok")


def main():
    if len(sys.argv) == 2 and sys.argv[1] == "--self-test":
        self_test()
        return
    if not TOKEN:
        raise SystemExit("MODRINTH_TOKEN is empty")
    if len(sys.argv) >= 3 and sys.argv[1] == "--finish":
        finish(sys.argv[2])
        return
    if len(sys.argv) < 3:
        raise SystemExit("usage: replace-modrinth-versions.py <project-id> <version-number> [...]")
    prepare(sys.argv[1], set(sys.argv[2:]))


if __name__ == "__main__":
    main()
