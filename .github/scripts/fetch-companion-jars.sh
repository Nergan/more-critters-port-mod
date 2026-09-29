#!/usr/bin/env bash
# Скачивает с Modrinth игровые jar Kotlin for Forge и GeckoLib.
# Аргументы: <каталог> <версия Minecraft> <версия KFF> <версия GeckoLib>
set -euo pipefail

OUT_DIR="${1:?destination directory}"
MINECRAFT_VERSION="${2:?minecraft version}"
KFF_VERSION="${3:?kotlin-for-forge version_number}"
GECKOLIB_VERSION="${4:?geckolib version_number}"
USER_AGENT="${MODRINTH_USER_AGENT:-Nergan/more-critters-port (https://github.com/Nergan/more-critters-port)}"

mkdir -p "${OUT_DIR}"

fetch_modrinth() {
  local slug="$1"
  local version="$2"
  local json url filename sha512

  # У GeckoLib один version_number на NeoForge, Forge и Fabric,
  # поэтому список версий сужается до загрузчика и версии игры.
  json="$(curl -fsSL -G -A "${USER_AGENT}" \
    --data-urlencode 'loaders=["neoforge"]' \
    --data-urlencode "game_versions=[\"${MINECRAFT_VERSION}\"]" \
    "https://api.modrinth.com/v2/project/${slug}/version")"
  url="$(echo "${json}" | jq -r --arg v "${version}" '
    first(.[] | select(.version_number == $v) | .files[] | select(.primary) | .url) // empty
  ')"
  filename="$(echo "${json}" | jq -r --arg v "${version}" '
    first(.[] | select(.version_number == $v) | .files[] | select(.primary) | .filename) // empty
  ')"
  sha512="$(echo "${json}" | jq -r --arg v "${version}" '
    first(.[] | select(.version_number == $v) | .files[] | select(.primary) | .hashes.sha512) // empty
  ')"

  if [[ -z "${url}" || -z "${filename}" || -z "${sha512}" ]]; then
    echo "No primary Modrinth file for ${slug} version ${version} (neoforge, ${MINECRAFT_VERSION})" >&2
    exit 1
  fi

  curl -fsSL -A "${USER_AGENT}" -o "${OUT_DIR}/${filename}" "${url}"
  echo "${sha512}  ${OUT_DIR}/${filename}" | sha512sum -c -
}

fetch_modrinth "kotlin-for-forge" "${KFF_VERSION}"
fetch_modrinth "geckolib" "${GECKOLIB_VERSION}"
