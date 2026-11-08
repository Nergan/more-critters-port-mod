# Agent notes

Bugfix style for this port: [ponytail](https://github.com/DietrichGebert/ponytail/blob/main/skills/ponytail/SKILL.md).
Smallest complete change, one root cause, existing patterns, no new dependencies.

Do not lower `org.gradle.jvmargs` in `gradle.properties`. It stays `-Xmx3G`.

GitHub issues: decide which reports are real defects. Fix only those. Reply on every issue and close it, including the ones that do not need a code change.

## Experience

If the task turns up a fact that would prevent a wrong turn next time, add it to this `AGENTS.md`. Do not record the play-by-play or a one-off build error. If an old line is wrong, replace it instead of leaving a second one beside it.


## Skills

Before changing the loader, read `neoforge-modding` from https://github.com/SirEdvin/minecraft-modding-skills and check versions against `gradle.properties`. Do not add a Fabric build. This port stays NeoForge 1.21.1.

Before a CDN upload, read https://cdn.mikchan.net/ai/SKILL.md and call `GET https://cdn.mikchan.net/version`. Do not print or invent the token. A published version number is not reused.

## Port traps

MCreator left three traps. Bone-meal particles are `levelEvent(1505, pos, 15)`: event `2005` no longer draws on the client, so crops grow without green particles. `Block.tick` runs only after `scheduleTick`; `randomTicks()` in the properties is not enough when `randomTick` is not overridden. GeckoLib 4 `thenPlay` plays a clip once and ignores `"loop": "hold_on_last_frame"`; a pose that must stay uses `thenPlayAndHold`.

The `mod_id` is already `more_critters`. Do not rename it. Generated Java becomes Kotlin only when you touch it, and the port's behavior stays the same.

Before writing your own, porting, or decompiling, find an existing mod, port, or fork. Web search (Google, Perplexity) misses little-known GitHub repositories: a repo with no stars and no link from an already indexed page stays out of that index. Search the GitHub catalog. Before searching, read https://github.com/aaddrick/gh-cli-search/blob/main/skills/gh-search-repos/SKILL.md and, for source, https://github.com/aaddrick/gh-cli-search/blob/main/skills/gh-search-code/SKILL.md. Set no star floor: apply the skill's `stars:>N` examples only when the owner asked for well-known projects. Leave https://github.com/py-sit/github-search-skill closed for a port or an obscure mod: it drops repos with no license, no recent commits, and tutorial repos. Run several queries: `gh search repos` by name, `--match readme`, and `gh search code` by mod id; for a port also pass `--include-forks true` and read the upstream fork list. A hyphen in a name matches the separate words. A leading minus on a qualifier is an exclusion: put that query after `--`, and on PowerShell also use `gh --%`. An empty description, zero stars, and empty topics still count. Also search Modrinth for published mods: a port's source is often only on GitHub. Do not start your own implementation until this search is done. Commit and push only when the owner asks. The player downloads the GitHub Release, not a jar copied into Prism.

Before calling the mod done, from this directory: build, run the client until the main menu, run the local server until it is ready. A jar that only compiled is not done.

## Local tools

Kidou and Mikchan CDN are local tools of this workshop. Searching the internet for them is pointless: there is no public documentation. Kidou's source is the spec inside `D:\DATA\soft\code\projects\minecraft\modpacks\Kidou-1.1.4-release.jar` and `D:\DATA\soft\code\projects\minecraft\modpacks\AGENTS.md`. Mikchan CDN's source is https://cdn.mikchan.net/ai/SKILL.md and `GET https://cdn.mikchan.net/version`.

## Testing a mod or pack

Work on a mod or a pack is done only after tests, a local server run, and a local client run. A jar that only compiled is not done.


## Modrinth

На Modrinth у каждой пары версии Minecraft и загрузчика одна версия: самая новая. Релиз снимает прежние версии этого слота и ставит на их место текущий jar.
