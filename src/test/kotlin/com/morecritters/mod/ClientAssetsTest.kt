package com.morecritters.mod

import com.morecritters.mod.ModFiles.assertNoProblems
import com.morecritters.mod.ModFiles.assets
import com.morecritters.mod.ModFiles.files
import com.morecritters.mod.ModFiles.findInSources
import com.morecritters.mod.ModFiles.json
import com.morecritters.mod.ModFiles.jsonObject
import com.morecritters.mod.ModFiles.modAsset
import com.morecritters.mod.ModFiles.relative
import kotlin.io.path.exists
import org.junit.jupiter.api.Test

class ClientAssetsTest {
    @Test
    fun `every block has a blockstate`() {
        assertNoProblems(ModFiles.blocks.filterNot { assets.resolve("blockstates/$it.json").exists() }.map { "no blockstate for $it" })
    }

    @Test
    fun `every item has a model`() {
        assertNoProblems(ModFiles.items.filterNot { assets.resolve("models/item/$it.json").exists() }.map { "no item model for $it" })
    }

    @Test
    fun `blockstates and models point to existing models and textures`() {
        val problems = sortedSetOf<String>()
        for (file in files(assets.resolve("blockstates"), ".json") + files(assets.resolve("models"), ".json")) {
            for (node in json(file).nodes()) {
                val model = node.string?.takeIf { node.key == "parent" || node.key == "model" }
                if (model != null) {
                    val target = modAsset(model, "models", ".json")
                    if (target != null && !target.exists()) problems += "${relative(file)}: model $model"
                }
                if (node.key == "textures" && node.element.isJsonObject) {
                    for ((_, value) in node.element.asJsonObject.entrySet()) {
                        val texture = value.asString
                        if (texture.startsWith("#")) continue
                        val target = modAsset(texture, "textures", ".png")
                        if (target != null && !target.exists()) problems += "${relative(file)}: texture $texture"
                    }
                }
            }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `sprite particles have existing textures`() {
        val problems = mutableListOf<String>()
        for (id in ModFiles.spriteParticles) {
            val file = assets.resolve("particles/$id.json")
            val textures = if (file.exists()) jsonObject(file).getAsJsonArray("textures") else null
            if (textures == null || textures.isEmpty) problems += "no textures for sprite particle $id"
        }
        for (file in files(assets.resolve("particles"), ".json")) {
            for (texture in jsonObject(file).getAsJsonArray("textures") ?: continue) {
                val target = modAsset(texture.asString, "textures/particle", ".png") ?: continue
                if (!target.exists()) problems += "${relative(file)}: ${texture.asString}"
            }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `mob effects have icons`() {
        assertNoProblems(ModFiles.effects.filterNot { assets.resolve("textures/mob_effect/$it.png").exists() }.map { "no icon for $it" })
    }

    @Test
    fun `sound events are defined and their files exist`() {
        val definitions = jsonObject(assets.resolve("sounds.json"))
        val problems = ModFiles.sounds.filterNot { definitions.has(it) }.map { "no sounds.json entry for $it" }.toMutableList()
        for ((event, definition) in definitions.entrySet()) {
            for (sound in definition.asJsonObject.getAsJsonArray("sounds")) {
                val entry = sound.takeIf { it.isJsonObject }?.asJsonObject
                if (entry?.get("type")?.asString == "event") continue
                val file = modAsset(entry?.get("name")?.asString ?: sound.asString, "sounds", ".ogg") ?: continue
                if (!file.exists()) problems += "$event: ${relative(file)}"
            }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `asset paths in code exist`() {
        val paths = findInSources(
            Regex("""ResourceLocation\.parse\(\s*"more_critters:([^"]+\.(?:png|json))"\s*\)|fromNamespaceAndPath\(\s*(?:"more_critters"|MoreCritters\.MODID)\s*,\s*"([^"]+\.(?:png|json))"\s*\)""")
        )
        assertNoProblems(paths.filterKeys { !assets.resolve(it).exists() }.map { (path, files) -> "$path (${files.joinToString()})" })
    }

    @Test
    fun `entity textures chosen in code exist`() {
        val names = findInSources(Regex("""setTexture\(\s*"([a-z0-9_./]+)"\s*\)|define\(\s*TEXTURE\s*,\s*"([a-z0-9_./]+)"\s*\)"""))
        val missing = names.filterKeys { !assets.resolve("textures/entities/$it.png").exists() }
        assertNoProblems(missing.map { (name, files) -> "textures/entities/$name.png (${files.joinToString()})" })
    }
}
