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

Search GitHub before writing a replacement or decompiling. Commit and push only when the owner asks. The player downloads the GitHub Release, not a jar copied into Prism.

Before calling the mod done, from this directory: build, run the client until the main menu, run the local server until it is ready. A jar that only compiled is not done.
