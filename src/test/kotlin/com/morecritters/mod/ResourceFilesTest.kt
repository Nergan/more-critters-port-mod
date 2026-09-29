package com.morecritters.mod

import com.morecritters.mod.ModFiles.assertNoProblems
import com.morecritters.mod.ModFiles.files
import com.morecritters.mod.ModFiles.json
import com.morecritters.mod.ModFiles.jsonObject
import com.morecritters.mod.ModFiles.relative
import com.morecritters.mod.ModFiles.resources
import kotlin.io.path.name
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResourceFilesTest {
    private val jsonFiles = files(resources, ".json") + files(resources, ".mcmeta")

    @Test
    fun `every json file parses strictly`() {
        val problems = jsonFiles.mapNotNull { file ->
            runCatching { json(file) }.exceptionOrNull()?.let { "${relative(file)}: ${it.message}" }
        }
        assertNoProblems(problems)
    }

    /** В jar поиск ресурсов чувствителен к регистру, а `exists()` на Windows — нет, поэтому имена проверяются по правилу `ResourceLocation`. */
    @Test
    fun `resource paths are valid resource locations`() {
        val segment = Regex("[a-z0-9_.-]+")
        val problems = (files(resources.resolve("assets"), "") + files(resources.resolve("data"), ""))
            .filterNot { file -> resources.relativize(file).all { segment.matches(it.name) } }
            .map(::relative)
        assertNoProblems(problems)
    }

    @Test
    fun `pack mcmeta uses the 1_21_1 resource pack format`() {
        val pack = jsonObject(resources.resolve("pack.mcmeta")).getAsJsonObject("pack")
        assertEquals(34, pack["pack_format"].asInt)
    }

    @Test
    fun `no forge namespace is left over from 1_20_1`() {
        val problems = sortedSetOf<String>()
        for (file in jsonFiles) {
            for (node in json(file).nodes()) {
                val suspicious = listOfNotNull(node.key, node.string).filter { it.startsWith("forge:") || it.startsWith("#forge:") }
                suspicious.mapTo(problems) { "${relative(file)}: $it" }
            }
        }
        assertNoProblems(problems)
    }

    @Test
    fun `registrations are found in the init classes`() {
        val registries = mapOf(
            "blocks" to ModFiles.blocks,
            "items" to ModFiles.items,
            "entities" to ModFiles.entities,
            "effects" to ModFiles.effects,
            "potions" to ModFiles.potions,
            "sounds" to ModFiles.sounds,
            "particles" to ModFiles.particles,
            "sprite particles" to ModFiles.spriteParticles,
        )
        assertNoProblems(registries.filterValues { it.isEmpty() }.keys.map { "no $it found" })
    }
}
