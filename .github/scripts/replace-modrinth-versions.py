"""Keep one Modrinth file for each Minecraft version and loader.

Modrinth answers HTTP 400 if a DELETE would remove the project's last
version. This script never does that. When every listed version is one we
are about to publish again, it renames one version to
``<number>-replaced-<id>`` (32 character limit), deletes the others, and
writes that id to ``release-assets/modrinth-delete-after-publish.txt``.
After mc-publish creates the new versions, run:

    replace-modrinth-versions.py --finish release-assets/modrinth-delete-after-publish.txt

Before publishing, name every slot the new files will occupy:

    replace-modrinth-versions.py <project-id> --slot <version> <loader> <game> [...]

Any version that already uses that loader and game is removed, including an
older version number. A version that also covers some other slot keeps that
other slot. ``--collapse`` does the same to a project that already has
several files in one slot, without publishing:

    replace-modrinth-versions.py --collapse <project-id> [...]

A missing project is not an error. The response body of any other HTTP
error is printed. MODRINTH_TOKEN must be set. ``--self-test`` does not
call the API.
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
    found = []
    offset = 0
    while True:
        url = f"{API}/project/{project}/version?limit=100&offset={offset}"
        code, body = call(url)
        if code == 404 and offset == 0:
            print("project not found, nothing to replace")
            return []
        must(code, body, "GET", url)
        page = json.loads(body.decode("utf-8"))
        if not page:
            break
        found.extend(page)
        if len(page) < 100:
            break
        offset += 100
    return found


def delete_version(version_id):
    url = f"{API}/version/{version_id}"
    code, body = call(url, method="DELETE")
    if code in (200, 204, 404):
        print("deleted", version_id, code)
        return
    show(code, body, "DELETE", url)
    raise SystemExit(1)


def patch_version(version_id, payload):
    url = f"{API}/version/{version_id}"
    code, body = call(url, method="PATCH", payload=payload)
    must(code, body, "PATCH", url)
    print("patched", version_id, payload)


def is_replaced(version):
    number = version.get("version_number") or ""
    return "-replaced-" in number or number.startswith("replaced-")


def replaced_of(version, wanted):
    number = version.get("version_number") or ""
    version_id = version.get("id") or ""
    return any(
        number.startswith(f"{item}-replaced-") or number == f"replaced-{version_id}"
        for item in wanted
    )


def slot_list(version):
    found = []
    for loader in version.get("loaders") or []:
        for game in version.get("game_versions") or []:
            pair = (loader, game)
            if pair not in found:
                found.append(pair)
    return found


def axes(slots):
    loaders = []
    games = []
    for loader, game in slots:
        if loader not in loaders:
            loaders.append(loader)
        if game not in games:
            games.append(game)
    return loaders, games


def prefer(candidate, current):
    candidate_real = not is_replaced(candidate)
    current_real = not is_replaced(current)
    if candidate_real != current_real:
        return candidate_real
    return (candidate.get("date_published") or "") > (current.get("date_published") or "")


def collapse_plan(versions):
    grouped = {}
    for version in versions:
        for slot in slot_list(version):
            grouped.setdefault(slot, []).append(version)
    keeper = {}
    for slot, group in grouped.items():
        best = group[0]
        for item in group[1:]:
            if prefer(item, best):
                best = item
        keeper[slot] = best["id"]
    delete = []
    narrow = []
    for version in versions:
        owned = [slot for slot in slot_list(version) if keeper.get(slot) == version["id"]]
        if not owned:
            delete.append(version)
            continue
        loaders, games = axes(owned)
        if set(loaders) != set(version.get("loaders") or []) or set(games) != set(version.get("game_versions") or []):
            narrow.append((version, loaders, games, None))
    if versions and len(delete) == len(versions):
        survivor = versions[0]
        for item in versions[1:]:
            if prefer(item, survivor):
                survivor = item
        delete = [item for item in delete if item["id"] != survivor["id"]]
    return delete, narrow


def release_plan(versions, slots):
    published = {(loader, game) for _, loader, game in slots}
    wanted = {number for number, _, _ in slots}
    delete = []
    narrow = []
    for version in versions:
        number = version.get("version_number") or ""
        occupied = slot_list(version)
        number_hit = number in wanted or replaced_of(version, wanted)
        slot_hit = any(slot in published for slot in occupied)
        if not number_hit and not slot_hit:
            continue
        remain = [slot for slot in occupied if slot not in published]
        if remain and not number_hit:
            loaders, games = axes(remain)
            narrow.append((version, loaders, games, None))
        elif remain and number_hit:
            loaders, games = axes(remain)
            narrow.append((version, loaders, games, spare_number(number, version["id"])))
        else:
            delete.append(version)
    return delete, narrow


def write_cleanup(ids):
    os.makedirs(os.path.dirname(CLEANUP_NAME), exist_ok=True)
    with open(CLEANUP_NAME, "w", encoding="utf-8", newline="\n") as handle:
        handle.write("".join(f"{item}\n" for item in ids))


def apply_narrow(narrow):
    for version, loaders, games, new_number in narrow:
        payload = {"loaders": loaders, "game_versions": games}
        if new_number:
            payload["version_number"] = new_number
        print("narrow", version.get("version_number"), version["id"], payload)
        patch_version(version["id"], payload)


def prepare(project, slots):
    versions = list_versions(project)
    delete, narrow = release_plan(versions, slots)
    print("versions", [(item.get("version_number"), item.get("loaders"), item.get("game_versions")) for item in versions])
    apply_narrow(narrow)
    delete_ids = {item["id"] for item in delete}
    remaining = [item for item in versions if item["id"] not in delete_ids]
    cleanup = []
    if remaining or not delete:
        for item in delete:
            print("delete", item.get("version_number"), item["id"])
            delete_version(item["id"])
    else:
        wanted = {number for number, _, _ in slots}
        renamed = [item for item in delete if is_replaced(item)]
        fresh = [item for item in delete if item not in renamed]
        survivor = (renamed or fresh)[0]
        number = survivor.get("version_number") or ""
        if number in wanted:
            new_number = spare_number(number, survivor["id"])
            print("rename", number, survivor["id"], "->", new_number)
            patch_version(survivor["id"], {"version_number": new_number})
        for item in delete:
            if item["id"] == survivor["id"]:
                continue
            print("delete", item.get("version_number"), item["id"])
            delete_version(item["id"])
        cleanup.append(survivor["id"])
        print("delete after publish", survivor["id"])
    write_cleanup(cleanup)


def collapse(project):
    versions = list_versions(project)
    if not versions:
        print("no versions", project)
        return
    delete, narrow = collapse_plan(versions)
    print(project, "versions", [(item.get("version_number"), item.get("loaders"), item.get("game_versions"), item.get("date_published")) for item in versions])
    apply_narrow(narrow)
    delete_ids = {item["id"] for item in delete}
    for item in delete:
        print("delete", item.get("version_number"), item["id"])
        delete_version(item["id"])
    kept = [item for item in versions if item["id"] not in delete_ids]
    for item in kept:
        for loader, game in slot_list(item):
            print("keep", project, loader, game, item.get("version_number"), item["id"])
    if kept and not any(item.get("featured") for item in kept):
        best = kept[0]
        for item in kept[1:]:
            if prefer(item, best):
                best = item
        patch_version(best["id"], {"featured": True})


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
    old = {
        "id": "old",
        "version_number": "1.0.0",
        "loaders": ["neoforge"],
        "game_versions": ["1.21.1"],
        "date_published": "2026-01-01T00:00:00Z",
    }
    new = {
        "id": "new",
        "version_number": "1.0.1",
        "loaders": ["neoforge"],
        "game_versions": ["1.21.1"],
        "date_published": "2026-02-01T00:00:00Z",
    }
    fabric = {
        "id": "fab",
        "version_number": "1.0.1-fabric",
        "loaders": ["fabric"],
        "game_versions": ["1.21.1"],
        "date_published": "2026-02-01T00:00:00Z",
    }
    delete, narrow = collapse_plan([old, new, fabric])
    assert [item["id"] for item in delete] == ["old"]
    assert narrow == []
    wide = {
        "id": "wide",
        "version_number": "1.0.0",
        "loaders": ["neoforge"],
        "game_versions": ["1.20.1", "1.21.1"],
        "date_published": "2026-01-01T00:00:00Z",
    }
    delete, narrow = collapse_plan([wide, new])
    assert delete == []
    assert narrow[0][0]["id"] == "wide"
    assert narrow[0][1:] == (["neoforge"], ["1.20.1"], None)
    replaced = {
        "id": "BMELvObk",
        "version_number": "1.0.1-replaced-BMELvObk",
        "loaders": ["neoforge"],
        "game_versions": ["1.21.1"],
        "date_published": "2026-03-01T00:00:00Z",
    }
    delete, narrow = collapse_plan([replaced, new])
    assert [item["id"] for item in delete] == ["BMELvObk"]
    slots = [("1.0.2", "neoforge", "1.21.1"), ("1.0.2-fabric", "fabric", "1.21.1")]
    delete, narrow = release_plan([old, new, fabric], slots)
    assert {item["id"] for item in delete} == {"old", "new", "fab"}
    assert narrow == []
    delete, narrow = release_plan([wide], [("1.0.2", "neoforge", "1.21.1")])
    assert delete == []
    assert narrow[0][1:] == (["neoforge"], ["1.20.1"], None)
    print("ok")


def parse_slots(argv):
    slots = []
    index = 0
    while index < len(argv):
        if argv[index] != "--slot" or index + 3 >= len(argv):
            raise SystemExit(
                "usage: replace-modrinth-versions.py <project-id> "
                "--slot <version> <loader> <game> [...]"
            )
        slots.append((argv[index + 1], argv[index + 2], argv[index + 3]))
        index += 4
    if not slots:
        raise SystemExit("at least one --slot is required")
    return slots


def main():
    if len(sys.argv) == 2 and sys.argv[1] == "--self-test":
        self_test()
        return
    if not TOKEN:
        raise SystemExit("MODRINTH_TOKEN is empty")
    if len(sys.argv) >= 3 and sys.argv[1] == "--finish":
        finish(sys.argv[2])
        return
    if len(sys.argv) >= 3 and sys.argv[1] == "--collapse":
        for project in sys.argv[2:]:
            collapse(project)
        return
    if len(sys.argv) < 6:
        raise SystemExit(
            "usage: replace-modrinth-versions.py <project-id> "
            "--slot <version> <loader> <game> [...]"
        )
    prepare(sys.argv[1], parse_slots(sys.argv[2:]))


if __name__ == "__main__":
    main()
