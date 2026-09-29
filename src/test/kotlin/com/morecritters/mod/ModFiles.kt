package com.morecritters.mod

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import java.io.DataInputStream
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.bufferedReader
import kotlin.io.path.inputStream
import kotlin.io.path.invariantSeparatorsPathString
import kotlin.io.path.isDirectory
import kotlin.io.path.isRegularFile
import kotlin.io.path.name
import kotlin.io.path.readText
import org.junit.jupiter.api.Assertions.assertTrue

/**
 * Ресурсы и исходники мода для тестов, которые не поднимают игру.
 * Зарегистрированные id берутся регулярками из классов `init/`, поэтому Minecraft на classpath тестов не нужен.
 */
object ModFiles {
    const val MOD_ID = "more_critters"

    val root: Path = Path.of("").toAbsolutePath()
    val resources: Path = root.resolve("src/main/resources")
    val assets: Path = resources.resolve("assets/$MOD_ID")
    val data: Path = resources.resolve("data")
    val modData: Path = data.resolve(MOD_ID)
    private val javaRoot = root.resolve("src/main/java/com/morecritters/mod")
    private val kotlinRoot = root.resolve("src/main/kotlin/com/morecritters/mod")

    private val jsonAdapter = Gson().getAdapter(JsonElement::class.java)

    /** Строгий разбор, как у загрузчиков данных Minecraft: без комментариев, висячих запятых и хвостов. */
    fun json(file: Path): JsonElement = file.bufferedReader().use { reader ->
        val input = JsonReader(reader)
        val element = jsonAdapter.read(input)
        check(input.peek() == JsonToken.END_DOCUMENT) { "unexpected data after the JSON value" }
        element
    }

    fun jsonObject(file: Path): JsonObject = json(file).asJsonObject

    fun files(dir: Path, suffix: String): List<Path> =
        if (!dir.isDirectory()) emptyList()
        else Files.walk(dir).use { paths -> paths.filter { it.isRegularFile() && it.name.endsWith(suffix) }.sorted().toList() }

    fun relative(file: Path): String = root.relativize(file).invariantSeparatorsPathString

    /** Id файлов данных мода одного типа: `data/more_critters/<type>/<id><suffix>`. */
    fun dataIds(type: String, suffix: String = ".json"): Set<String> {
        val dir = modData.resolve(type)
        return files(dir, suffix).map { dir.relativize(it).invariantSeparatorsPathString.removeSuffix(suffix) }.toSortedSet()
    }

    fun lang(name: String): Map<String, String> =
        jsonObject(assets.resolve("lang/$name.json")).entrySet().associate { (key, value) -> key to value.asString }

    val enUs: Map<String, String> by lazy { lang("en_us") }

    /** Файлы тегов из всех пространств имён: папка реестра (`item`, `worldgen/biome`) → id тегов. */
    val tags: Map<String, Set<String>> by lazy {
        val result = sortedMapOf<String, MutableSet<String>>()
        for (namespace in Files.list(data).use { it.toList() }) {
            val dir = namespace.resolve("tags")
            for (file in files(dir, ".json")) {
                val parts = dir.relativize(file).invariantSeparatorsPathString.removeSuffix(".json").split('/')
                val registryDepth = if (parts[0] == "worldgen") 2 else 1
                result.getOrPut(parts.take(registryDepth).joinToString("/")) { sortedSetOf() } +=
                    "${namespace.name}:${parts.drop(registryDepth).joinToString("/")}"
            }
        }
        result
    }

    fun tagFile(registry: String, id: String): Path {
        val (namespace, path) = splitId(id)
        return data.resolve("$namespace/tags/$registry/$path.json")
    }

    /** `namespace:path`; без пространства имён — `minecraft`, как у `ResourceLocation`. */
    fun splitId(id: String): Pair<String, String> {
        val colon = id.indexOf(':')
        return if (colon < 0) "minecraft" to id else id.substring(0, colon) to id.substring(colon + 1)
    }

    /** Файл в ассетах мода или null, если ссылка ведёт в чужое пространство имён. */
    fun modAsset(id: String, folder: String, suffix: String): Path? {
        val (namespace, path) = splitId(id)
        return if (namespace == MOD_ID) assets.resolve("$folder/$path$suffix") else null
    }

    fun pngSize(file: Path): Pair<Int, Int> = DataInputStream(file.inputStream().buffered()).use { input ->
        val signature = ByteArray(PNG_SIGNATURE.size).also(input::readFully)
        require(signature.contentEquals(PNG_SIGNATURE)) { "${relative(file)} is not a PNG file" }
        input.readInt()
        require(input.readInt() == IHDR) { "${relative(file)} does not start with IHDR" }
        input.readInt() to input.readInt()
    }

    private val PNG_SIGNATURE = byteArrayOf(0x89.toByte(), 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A)
    private const val IHDR = 0x49484452

    val sources: Map<Path, String> by lazy {
        (files(javaRoot, ".java") + files(kotlinRoot, ".kt")).associateWith { it.readText() }
    }

    fun source(name: String): String = sources.entries.single { it.key.name == name }.value

    /** Первая непустая группа каждого совпадения во всех исходниках → имена файлов, где оно встретилось. */
    fun findInSources(regex: Regex): Map<String, Set<String>> {
        val found = sortedMapOf<String, MutableSet<String>>()
        for ((file, text) in sources) {
            for (match in regex.findAll(text)) {
                val value = match.groupValues.drop(1).first { it.isNotEmpty() }
                found.getOrPut(value) { sortedSetOf() } += file.name
            }
        }
        return found
    }

    private val registerCall = Regex("""register\(\s*"([a-z0-9_./]+)"""")
    private val namedRegisterCall = Regex("""(\w+)\s*=\s*(?:REGISTRY\.)?register\(\s*"([a-z0-9_./]+)"""")

    private fun init(name: String) = source("$name.java")

    private fun registered(init: String): Set<String> =
        registerCall.findAll(init(init)).map { it.groupValues[1] }.toSortedSet()

    private fun constants(init: String): Map<String, String> =
        namedRegisterCall.findAll(init(init)).associate { it.groupValues[1] to it.groupValues[2] }

    val blocks: Set<String> by lazy { registered("MoreCrittersModBlocks") }

    /** Предметы из `register("id")` и блочные предметы, которые берут id своего блока. */
    val items: Set<String> by lazy {
        val blockConstants = constants("MoreCrittersModBlocks")
        val blockItem = Regex("""(?:block|doubleBlock)\(\s*MoreCrittersModBlocks\.(\w+)\s*\)|MoreCrittersModBlocks\.(\w+)\.getId\(\)\.getPath\(\)""")
        val blockItems = blockItem.findAll(init("MoreCrittersModItems")).map { match ->
            val constant = match.groupValues[1].ifEmpty { match.groupValues[2] }
            blockConstants[constant] ?: error("MoreCrittersModItems refers to an unknown block $constant")
        }
        (registered("MoreCrittersModItems") + blockItems).toSortedSet()
    }

    val entities: Set<String> by lazy { registered("MoreCrittersModEntities") }
    val effects: Set<String> by lazy { registered("MoreCrittersModMobEffects") }
    val potions: Set<String> by lazy { registered("MoreCrittersModPotions") }
    val sounds: Set<String> by lazy { registered("MoreCrittersModSounds") }
    val particles: Set<String> by lazy { registered("MoreCrittersModParticleTypes") }

    /** Частицы со спрайтами: без `particles/<id>.json` у них пустой набор текстур. */
    val spriteParticles: Set<String> by lazy {
        val constants = constants("MoreCrittersModParticleTypes")
        Regex("""registerSpriteSet\(\s*MoreCrittersModParticleTypes\.(\w+)\.get\(\)""")
            .findAll(init("MoreCrittersModParticles"))
            .map { constants[it.groupValues[1]] ?: error("unknown particle type ${it.groupValues[1]}") }
            .toSortedSet()
    }

    /** Всё, что регистрируется через `register("id")`, включая реестры вне `init/` (например, `StructureFeature`). */
    val allRegistered: Set<String> by lazy {
        sources.values.flatMap { text -> registerCall.findAll(text).map { it.groupValues[1] } }.toSortedSet() + items
    }

    fun assertNoProblems(problems: Collection<String>) {
        assertTrue(problems.isEmpty()) { "${problems.size} problem(s):\n" + problems.joinToString("\n") }
    }
}

class JsonNode(val key: String?, val element: JsonElement) {
    val string: String? get() = element.takeIf { it.isJsonPrimitive && it.asJsonPrimitive.isString }?.asString
}

/** Все узлы дерева; элементы массива получают ключ самого массива. */
fun JsonElement.nodes(): Sequence<JsonNode> = sequence { visit(null, this@nodes) }

private suspend fun SequenceScope<JsonNode>.visit(key: String?, element: JsonElement) {
    yield(JsonNode(key, element))
    when {
        element.isJsonObject -> for ((childKey, child) in element.asJsonObject.entrySet()) visit(childKey, child)
        element.isJsonArray -> for (child in element.asJsonArray) visit(key, child)
    }
}
