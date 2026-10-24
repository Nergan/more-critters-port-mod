# Agent notes

Bugfix style for this port: [ponytail](https://github.com/DietrichGebert/ponytail/blob/main/skills/ponytail/SKILL.md).
Smallest complete change, one root cause, existing patterns, no new dependencies.

Do not lower `org.gradle.jvmargs` in `gradle.properties`. It stays `-Xmx3G`.

GitHub issues: decide which reports are real defects. Fix only those. Reply on every issue and close it, including the ones that do not need a code change.
