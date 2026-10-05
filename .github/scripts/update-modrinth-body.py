"""Replace the Modrinth project page text from a markdown file.

Usage: update-modrinth-body.py <project-id> <markdown-file>
MODRINTH_TOKEN must be set. The token is not printed.
"""

import json
import os
import sys
import urllib.error
import urllib.request

project = sys.argv[1]
path = sys.argv[2]
token = os.environ["MODRINTH_TOKEN"]
with open(path, encoding="utf-8") as handle:
    body = handle.read()
payload = json.dumps({"body": body}).encode("utf-8")
request = urllib.request.Request(
    f"https://api.modrinth.com/v2/project/{project}",
    data=payload,
    headers={
        "Authorization": token,
        "User-Agent": "Nergan/minecraft-mods",
        "Content-Type": "application/json",
    },
    method="PATCH",
)
try:
    with urllib.request.urlopen(request) as response:
        print("updated", project, response.status)
except urllib.error.HTTPError as error:
    print(f"HTTP {error.code} PATCH https://api.modrinth.com/v2/project/{project}")
    print(error.read().decode("utf-8", "replace")[:2000])
    raise SystemExit(1)
