package com.morecritters.mod

import com.google.gson.JsonElement
import com.morecritters.mod.ModFiles.MOD_ID
import com.morecritters.mod.ModFiles.assertNoProblems
import com.morecritters.mod.ModFiles.assets
import com.morecritters.mod.ModFiles.data
import com.morecritters.mod.ModFiles.dataIds
import com.morecritters.mod.ModFiles.files
import com.morecritters.mod.ModFiles.findInSources
import com.morecritters.mod.ModFiles.json
import com.morecritters.mod.ModFiles.jsonObject
import com.morecritters.mod.ModFiles.modAsset
import com.morecritters.mod.ModFiles.modData
import com.morecritters.mod.ModFiles.pngSize
import com.morecritters.mod.ModFiles.relative
import com.morecritters.mod.ModFiles.sources
import com.morecritters.mod.ModFiles.splitId
import com.morecritters.mod.ModFiles.tagFile
import kotlin.io.path.exists
import kotlin.io.path.invariantSeparatorsPathString
import kotlin.io.path.name
import org.junit.jupiter.api.Test

class DataReferencesTest {
    /** Id всех файлов данных мода: путь после папки типа (`loot_table/entities/x.json` → `entities/x` и `x`). */
    private val dataFileIds: Set<String> by lazy {
        files(modData, "").flatMap { file ->
            val parts = modData.relativize(file).invariantSeparatorsPathString.substringBeforeLast('.').split('/')
            listOf(parts.drop(1), parts.drop(2)).filter { it.isNotEmpty() }.map { it.joinToString("/") }
        }.toSet()
    }

    @Test
    fun `mod ids in data files are known`() {
        val modId = Regex("""#?more_critters:[a-z0-9_./-]+""")
        val known = ModFiles.allRegistered + dataFileIds
        val allTags = ModFiles.tags.values.flatten().toSet()
        val problems = sortedSetOf<String>()
        for (file in files(data, ".json")) {
            for (node in json(file).nodes()) {
                for (value in listOfNotNull(node.key, node.string).filter(modId::matches)) {
                    val exists = when {
                        value.startsWith("#") -> value.drop(1) in allTags
                        value.endsWith(".png") -> assets.resolve(splitId(value).second).exists()
                        else -> splitId(value).second in known
                    }
                    if (!exists) problems += "${relative(file)}: $value"
                }
            }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `tag entries point to existing objects`() {
        val registries = mapOf(
            "item" to ModFiles.items,
            "block" to ModFiles.blocks,
            "entity_type" to ModFiles.entities,
            "enchantment" to dataIds("enchantment"),
            "painting_variant" to dataIds("painting_variant"),
            "worldgen/biome" to dataIds("worldgen/biome"),
        )
        val problems = sortedSetOf<String>()
        for ((registry, tags) in ModFiles.tags) {
            for (tag in tags) {
                for (entry in jsonObject(tagFile(registry, tag)).getAsJsonArray("values")) {
                    val entryObject = entry.takeIf { it.isJsonObject }?.asJsonObject
                    if (entryObject?.get("required")?.asBoolean == false) continue
                    val value = entryObject?.get("id")?.asString ?: entry.asString
                    val (namespace, path) = splitId(value.removePrefix("#"))
                    if (namespace != MOD_ID) continue
                    val known = registries[registry]
                    val exists = when {
                        value.startsWith("#") -> tagFile(registry, value.drop(1)).exists()
                        known == null -> {
                            problems += "$registry $tag: unsupported registry"
                            continue
                        }
                        else -> path in known
                    }
                    if (!exists) problems += "$registry $tag: $value"
                }
            }
        }
        assertNoProblems(problems)
    }

    /** Теги `minecraft:` в коде — собственные теги мода (так их называл MCreator), поэтому их файлы обязаны лежать в ресурсах. */
    @Test
    fun `tags used in code have files`() {
        val folders = mapOf(
            "ItemTags" to "item", "BlockTags" to "block",
            "ITEM" to "item", "BLOCK" to "block", "ENTITY_TYPE" to "entity_type", "BIOME" to "worldgen/biome",
        )
        val usage = Regex("""(ItemTags|BlockTags)\.create\(\s*ResourceLocation\.parse\(\s*"([^"]+)"|TagKey\.create\(\s*Registries\.(\w+)\s*,\s*ResourceLocation\.parse\(\s*"([^"]+)"""")
        val problems = sortedSetOf<String>()
        for ((file, text) in sources) {
            for (match in usage.findAll(text)) {
                val (helper, helperId, registry, registryId) = match.destructured
                val id = helperId.ifEmpty { registryId }
                if (splitId(id).first !in setOf("minecraft", MOD_ID)) continue
                val folder = folders[helper.ifEmpty { registry }]
                when {
                    folder == null -> problems += "${file.name}: unsupported tag registry in ${match.value}"
                    !tagFile(folder, id).exists() -> problems += "${file.name}: $folder tag $id"
                }
            }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `registry lookups in code find mod objects`() {
        val builtIn = mapOf(
            "ITEM" to ModFiles.items,
            "BLOCK" to ModFiles.blocks,
            "ENTITY_TYPE" to ModFiles.entities,
            "MOB_EFFECT" to ModFiles.effects,
            "POTION" to ModFiles.potions,
            "SOUND_EVENT" to ModFiles.sounds,
            "PARTICLE_TYPE" to ModFiles.particles,
        )
        val dataFolders = mapOf(
            "LOOT_TABLE" to "loot_table",
            "JUKEBOX_SONG" to "jukebox_song",
            "DAMAGE_TYPE" to "damage_type",
            "ENCHANTMENT" to "enchantment",
            "PAINTING_VARIANT" to "painting_variant",
            "STRUCTURE" to "worldgen/structure",
            "CONFIGURED_FEATURE" to "worldgen/configured_feature",
            "PLACED_FEATURE" to "worldgen/placed_feature",
        )
        val lookup = Regex("""BuiltInRegistries\.(\w+)\.\w+\(\s*ResourceLocation\.parse\(\s*"more_critters:([^"]+)"""")
        val key = Regex("""ResourceKey\.create\(\s*Registries\.(\w+)\s*,\s*ResourceLocation\.(?:parse\(\s*"more_critters:|fromNamespaceAndPath\(\s*"more_critters"\s*,\s*")([^"]+)"""")
        val advancement = Regex("""getAdvancements\(\)\.get\(\s*ResourceLocation\.parse\(\s*"more_critters:([^"]+)"""")
        val problems = sortedSetOf<String>()
        for ((file, text) in sources) {
            for (match in lookup.findAll(text)) {
                val (registry, id) = match.destructured
                val known = builtIn[registry]
                if (known == null) problems += "${file.name}: unsupported registry $registry" else if (id !in known) problems += "${file.name}: $registry $id"
            }
            for (match in key.findAll(text)) {
                val (registry, id) = match.destructured
                val folder = dataFolders[registry]
                if (folder == null) problems += "${file.name}: unsupported registry key $registry" else if (id !in dataIds(folder)) problems += "${file.name}: $registry $id"
            }
            for (match in advancement.findAll(text)) {
                val id = match.groupValues[1]
                if (id !in dataIds("advancement")) problems += "${file.name}: advancement $id"
            }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `commands in code point to existing content`() {
        val commands = mapOf(
            Regex("""summon more_critters:([a-z0-9_]+)""") to ModFiles.entities,
            Regex("""place template more_critters:([a-z0-9_/]+)""") to dataIds("structure", ".nbt"),
            Regex("""function more_critters:([a-z0-9_/]+)""") to dataIds("function", ".mcfunction"),
            Regex("""loot more_critters:([a-z0-9_/]+)""") to dataIds("loot_table"),
            Regex("""playsound more_critters:([a-z0-9_./]+)""") to jsonObject(assets.resolve("sounds.json")).keySet(),
            Regex("""particle more_critters:([a-z0-9_]+)""") to ModFiles.particles,
            Regex("""effect give \S+ more_critters:([a-z0-9_]+)""") to ModFiles.effects,
            Regex("""(?<!effect )(?:give|clear) \S+ more_critters:([a-z0-9_]+)""") to ModFiles.items,
            Regex("""(?:setblock|fill) [^"]*? more_critters:([a-z0-9_]+)""") to ModFiles.blocks,
        )
        val problems = sortedSetOf<String>()
        for ((command, existing) in commands) {
            findInSources(command).filterKeys { it !in existing }
                .mapTo(problems) { (id, files) -> "${command.pattern}: $id (${files.joinToString()})" }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `painting variants are valid and placeable`() {
        val placeable = jsonObject(tagFile("painting_variant", "minecraft:placeable")).getAsJsonArray("values").map { it.asString }.toSet()
        val problems = mutableListOf<String>()
        for (id in dataIds("painting_variant")) {
            val variant = jsonObject(modData.resolve("painting_variant/$id.json"))
            val width = variant["width"].asInt
            val height = variant["height"].asInt
            if (width !in 1..16 || height !in 1..16) problems += "$id: size ${width}x$height is outside 1..16"
            val texture = modAsset(variant["asset_id"].asString, "textures/painting", ".png")
            if (texture != null && !texture.exists()) {
                problems += "$id: no ${relative(texture)}"
            } else if (texture != null) {
                val (pixelsWide, pixelsHigh) = pngSize(texture)
                if (pixelsWide * height != pixelsHigh * width) problems += "$id: ${pixelsWide}x$pixelsHigh texture for a ${width}x$height painting"
            }
            if ("$MOD_ID:$id" !in placeable) problems += "$id is not in #minecraft:placeable"
        }
        assertNoProblems(problems)
    }

    @Test
    fun `jukebox songs play defined sounds`() {
        val definitions = jsonObject(assets.resolve("sounds.json"))
        val problems = mutableListOf<String>()
        for (id in dataIds("jukebox_song")) {
            val song = jsonObject(modData.resolve("jukebox_song/$id.json"))
            val event = song["sound_event"].let { if (it.isJsonObject) it.asJsonObject["sound_id"].asString else it.asString }
            val (namespace, path) = splitId(event)
            if (namespace == MOD_ID && path !in ModFiles.sounds) problems += "$id: sound event $event is not registered"
            if (namespace == MOD_ID && !definitions.has(path)) problems += "$id: sound event $event is not in sounds.json"
            if (song["length_in_seconds"].asFloat <= 0f) problems += "$id: length must be positive"
            if (song["comparator_output"].asInt !in 0..15) problems += "$id: comparator output must be 0..15"
        }
        assertNoProblems(problems)
    }

    @Test
    fun `enchantments exclude each other symmetrically and apply to mod items`() {
        val enchantments = dataIds("enchantment").associateWith { jsonObject(modData.resolve("enchantment/$it.json")) }
        val problems = mutableListOf<String>()
        for ((id, enchantment) in enchantments) {
            for (other in holders(enchantment["exclusive_set"])) {
                val (namespace, path) = splitId(other.removePrefix("#"))
                if (namespace != MOD_ID) continue
                if (other.startsWith("#")) {
                    if (!tagFile("enchantment", other.drop(1)).exists()) problems += "$id: no enchantment tag $other"
                    continue
                }
                val excluded = enchantments[path]
                if (excluded == null) problems += "$id excludes unknown enchantment $other"
                else if ("$MOD_ID:$id" !in holders(excluded["exclusive_set"])) problems += "$id excludes $other, but not the other way round"
            }
            for (key in listOf("supported_items", "primary_items")) {
                for (item in holders(enchantment[key])) {
                    val (namespace, path) = splitId(item.removePrefix("#"))
                    if (namespace != MOD_ID) continue
                    val exists = if (item.startsWith("#")) tagFile("item", item.drop(1)).exists() else path in ModFiles.items
                    if (!exists) problems += "$id: $key refers to unknown $item"
                }
            }
        }
        assertNoProblems(problems)
    }

    /** HolderSet в JSON: один id, `#тег` или список. */
    private fun holders(element: JsonElement?): List<String> = when {
        element == null -> emptyList()
        element.isJsonArray -> element.asJsonArray.map { it.asString }
        else -> listOf(element.asString)
    }
}
