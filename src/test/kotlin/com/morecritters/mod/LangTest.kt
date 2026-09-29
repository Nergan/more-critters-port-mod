package com.morecritters.mod

import com.morecritters.mod.ModFiles.MOD_ID
import com.morecritters.mod.ModFiles.assertNoProblems
import com.morecritters.mod.ModFiles.assets
import com.morecritters.mod.ModFiles.data
import com.morecritters.mod.ModFiles.dataIds
import com.morecritters.mod.ModFiles.files
import com.morecritters.mod.ModFiles.findInSources
import com.morecritters.mod.ModFiles.json
import com.morecritters.mod.ModFiles.jsonObject
import com.morecritters.mod.ModFiles.lang
import com.morecritters.mod.ModFiles.relative
import com.morecritters.mod.ModFiles.source
import org.junit.jupiter.api.Test

class LangTest {
    private val en = ModFiles.enUs
    private val ru = lang("ru_ru")

    @Test
    fun `ru_ru has the same keys as en_us`() {
        val missing = (en.keys - ru.keys).map { "missing in ru_ru: $it" }
        val unknown = (ru.keys - en.keys).map { "unknown in ru_ru: $it" }
        assertNoProblems(missing + unknown)
    }

    @Test
    fun `tr_tr has no keys unknown to en_us`() {
        assertNoProblems((lang("tr_tr").keys - en.keys).map { "unknown in tr_tr: $it" })
    }

    @Test
    fun `ru_ru keeps placeholders and formatting codes`() {
        val problems = mutableListOf<String>()
        for ((key, english) in en) {
            val russian = ru[key] ?: continue
            if (count(PLACEHOLDER, english) != count(PLACEHOLDER, russian)) problems += "placeholders differ: $key"
            if (count(FORMATTING, english) != count(FORMATTING, russian)) problems += "formatting codes differ: $key"
            if (russian != russian.trim() && english == english.trim()) problems += "extra whitespace: $key"
        }
        assertNoProblems(problems)
    }

    @Test
    fun `registered objects have names`() {
        val problems = mutableListOf<String>()
        ModFiles.items.filterNot { "item.$MOD_ID.$it" in en || "block.$MOD_ID.$it" in en }.mapTo(problems) { "item $it" }
        ModFiles.entities.filterNot { "entity.$MOD_ID.$it" in en }.mapTo(problems) { "entity $it" }
        ModFiles.effects.filterNot { "effect.$MOD_ID.$it" in en }.mapTo(problems) { "effect $it" }
        for (potion in ModFiles.potions) {
            POTION_ITEMS.filterNot { "item.minecraft.$it.effect.$potion" in en }.mapTo(problems) { "$it of $potion" }
        }
        for (painting in dataIds("painting_variant")) {
            listOf("title", "author").filterNot { "painting.$MOD_ID.$painting.$it" in en }.mapTo(problems) { "painting $painting $it" }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `keys used by data files and sounds exist`() {
        val problems = sortedSetOf<String>()
        for (file in files(data, ".json")) {
            json(file).nodes().filter { it.key == "translate" }.mapNotNull { it.string }.filterNot { it in en }
                .mapTo(problems) { "${relative(file)}: $it" }
        }
        for ((event, definition) in jsonObject(assets.resolve("sounds.json")).entrySet()) {
            val subtitle = definition.asJsonObject["subtitle"]?.asString ?: continue
            if (subtitle !in en) problems += "sounds.json $event: $subtitle"
        }
        assertNoProblems(problems)
    }

    @Test
    fun `keys used by code exist`() {
        val keys = findInSources(Regex("""translatable\(\s*"([^"]+)""""))
        assertNoProblems(keys.filterKeys { it !in en }.map { (key, files) -> "$key (${files.joinToString()})" })
    }

    @Test
    fun `config options have names and tooltips`() {
        val config = source("ServerConfig.kt")
        val prefix = "$MOD_ID.configuration"
        val sections = Regex("""push\("(\w+)"\)""").findAll(config).map { "$prefix.${it.groupValues[1]}" }.toList()
        val options = Regex("""translation\("[^"]*KEY_PREFIX\.([\w.]+)"\)""").findAll(config).map { "$prefix.${it.groupValues[1]}" }.toList()
        val problems = (sections + options + options.map { "$it.tooltip" }).filterNot { it in en }.toMutableList()
        if (sections.isEmpty() || options.isEmpty()) problems += "no config sections or options found in ServerConfig.kt"
        assertNoProblems(problems)
    }

    private fun count(regex: Regex, text: String) = regex.findAll(text).groupingBy { it.value }.eachCount()

    private companion object {
        val PLACEHOLDER = Regex("""%(?:\d+\$)?[sd]""")
        val FORMATTING = Regex("§[0-9a-fk-or]")
        val POTION_ITEMS = listOf("potion", "splash_potion", "lingering_potion", "tipped_arrow")
    }
}
