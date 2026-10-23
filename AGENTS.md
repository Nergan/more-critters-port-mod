# Agent notes

Bugfix style for this port: [ponytail](https://github.com/DietrichGebert/ponytail/blob/main/skills/ponytail/SKILL.md).
Smallest complete change, one root cause, existing patterns, no new dependencies.

Do not lower `org.gradle.jvmargs` in `gradle.properties`. It stays `-Xmx3G`.
