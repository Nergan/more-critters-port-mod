# More Critters was published under the MIT License

This port is built from the decompiled code and the assets of **More Critters 1.4.5** by Portakal Cevheri ([Modrinth](https://modrinth.com/mod/more-critters), project id `iRZ6t3qQ`). The original has no public source repository. This folder records that the mod was distributed under the MIT License when the port was made. A license applies to the copies already distributed under it, so a later license change on Modrinth does not affect this port.

## Summary

- **Modrinth API.** Fetched on 2026-09-29 at 17:01 UTC, the project reports `"license": {"id": "MIT", "name": "MIT License"}`. The mod was first published on 2025-08-14. See `modrinth-project.json`.
- **The ported file.** Version 1.4.5 (version id `XVv1elXV`, published 2026-08-08 07:32 UTC) has one file, `More Critters 1.4.5.jar`. See `modrinth-version-1.4.5.json`. The copy used for the port has the same size and hashes:
  - size: 32 037 496 bytes
  - sha1: `dec60b76d2cfb70402048e87274699c724eea602`
  - sha512: `b0281469d4f43d3b8080152a3046ac6e6a31e4b709d8b00f80e901afb3b7da7bf1f9ea1e6e37e370b785f6982dec2a825ce12cc52df3fcdd017b06ee5f50ab72`
  - sha256 (not published by Modrinth): `72916ef9b0b0d2574aa64bbe08b3663496f5a79179583892b4eca6821ed343a8`
- **Inside the jar.** `META-INF/mods.toml` declares `license="MIT License"`. `original-mods.toml` is that file, extracted byte for byte.
- **Internet Archive.** The Wayback Machine has 21 captures of https://modrinth.com/mod/more-critters with HTTP status 200, from 2025-08-26 to 2026-09-15. On every one of them the page sidebar reads "Licensed MIT", and the project data in the page has the same license. `wayback-snapshots.json` lists each capture with its link.

## Files

| File | What it is |
| --- | --- |
| `modrinth-project.json` | Response of `GET https://api.modrinth.com/v2/project/more-critters`, saved as received on 2026-09-29 |
| `modrinth-version-1.4.5.json` | Response of `GET https://api.modrinth.com/v2/version/XVv1elXV`, saved as received on 2026-09-29 |
| `original-mods.toml` | `META-INF/mods.toml` from `More Critters 1.4.5.jar` (917 bytes, sha256 `91b48da743316942afa7ce73412fcebc156a5b7e37822204a3008fb29b297430`) |
| `wayback-snapshots.json` | The 21 Wayback captures: timestamp, link, HTTP status, sha256 of the archived response, page title, license text from the sidebar, license from the page data |

## How to check it yourself

1. Run `curl https://api.modrinth.com/v2/project/more-critters` and look at `license`.
2. Download the jar from https://cdn.modrinth.com/data/iRZ6t3qQ/versions/XVv1elXV/More%20Critters%201.4.5.jar, compare its sha512 with the value above, and open `META-INF/mods.toml` inside it.
3. Open any link from `wayback-snapshots.json` and find "Licensed" in the page sidebar.

The license in the page data was read from the project object in `__NUXT_DATA__`, not by searching the page for "MIT". That page data also contains the list of all licenses Modrinth offers, so a plain text search would match on any capture.

## Notes

- The jar contains no LICENSE file. The `license` field of `mods.toml` is the only license statement inside it. `LICENSE-MORE-CRITTERS` in the repository root is the standard MIT License text with the author's name and the years the mod was published (2025–2026).
- The original `mods.toml` credits "Portakal Cevheri, Natsirt, OrangeeApple, MistyJam, MSF and Skipster112".
