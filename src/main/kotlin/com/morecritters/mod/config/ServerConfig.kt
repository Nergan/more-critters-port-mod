package com.morecritters.mod.config

import net.neoforged.neoforge.common.ModConfigSpec

/**
 * Конфиг типа SERVER: в мультиплеере значения задаёт сервер и рассылает клиентам.
 * Экран: Mods → More Critters → Config.
 * Ключи локализации: `more_critters.configuration.<секция>.<ключ>`.
 *
 * Опции и умолчания повторяют `morecritters-general.toml` оригинала (там он был COMMON).
 * Поля помечены `@JvmField`: их читает Java-код процедур.
 */
class ServerConfig(builder: ModConfigSpec.Builder) {

    companion object {
        private const val KEY_PREFIX = "more_critters.configuration"

        @JvmField
        val SPEC: ModConfigSpec

        @JvmField
        val CONFIG: ServerConfig

        init {
            val pair = ModConfigSpec.Builder().configure(::ServerConfig)
            CONFIG = pair.getLeft()
            SPEC = pair.getRight()
        }
    }

    @JvmField val carrybugSaddle: ModConfigSpec.BooleanValue
    @JvmField val bunbugBirth: ModConfigSpec.DoubleValue
    @JvmField val frostbite: ModConfigSpec.BooleanValue
    @JvmField val bouncelizardJump: ModConfigSpec.DoubleValue
    @JvmField val bouncelizardSuperJump: ModConfigSpec.DoubleValue
    @JvmField val creeblossomInfection: ModConfigSpec.DoubleValue
    @JvmField val warptrapAttack: ModConfigSpec.BooleanValue
    @JvmField val shimmerwingFollow: ModConfigSpec.BooleanValue
    @JvmField val balloonRatPoison: ModConfigSpec.BooleanValue
    @JvmField val animateBombJelly: ModConfigSpec.BooleanValue
    @JvmField val smallBombJellyPower: ModConfigSpec.DoubleValue
    @JvmField val mediumBombJellyPower: ModConfigSpec.DoubleValue
    @JvmField val largeBombJellyPower: ModConfigSpec.DoubleValue
    @JvmField val blackIropod: ModConfigSpec.DoubleValue
    @JvmField val shadeletJumpscare: ModConfigSpec.BooleanValue
    @JvmField val nervoidInfection: ModConfigSpec.DoubleValue
    @JvmField val quartermasterCooldown: ModConfigSpec.DoubleValue
    @JvmField val captainCooldown: ModConfigSpec.DoubleValue
    @JvmField val tankCooldown: ModConfigSpec.DoubleValue
    @JvmField val webbedHealth: ModConfigSpec.DoubleValue
    @JvmField val cobwebFreeze: ModConfigSpec.BooleanValue

    init {
        builder.push("mobs")
        carrybugSaddle = builder
            .comment("Whether players can remove the saddle and chests of a Carrybug with shears")
            .translation("$KEY_PREFIX.mobs.can_remove_carrybug_saddle")
            .define("can_remove_carrybug_saddle", true)
        bunbugBirth = builder
            .comment("Determines how many babies a Bunbug will give birth to")
            .translation("$KEY_PREFIX.mobs.bunbug_birth_number")
            .defineInRange("bunbug_birth_number", 4.0, 0.0, 64.0)
        frostbite = builder
            .comment("Whether Snowflake Spiders inflict Frostbite when attacking")
            .translation("$KEY_PREFIX.mobs.snowflake_spider_inflict_frostbite")
            .define("snowflake_spider_inflict_frostbite", true)
        bouncelizardJump = builder
            .comment("How much does Bouncelizard bounce")
            .translation("$KEY_PREFIX.mobs.bouncelizard_regular_jump_height")
            .defineInRange("bouncelizard_regular_jump_height", 0.6, 0.0, 10.0)
        bouncelizardSuperJump = builder
            .comment("How much does a sleeping Bouncelizard bounce")
            .translation("$KEY_PREFIX.mobs.bouncelizard_sleeping_jump_height")
            .defineInRange("bouncelizard_sleeping_jump_height", 1.2, 0.0, 10.0)
        creeblossomInfection = builder
            .comment("1 out of this number chance for a warm biome monster to spawn with Blossoming effect")
            .translation("$KEY_PREFIX.mobs.creeblossom_infection_rate")
            .defineInRange("creeblossom_infection_rate", 30.0, 1.0, 1000000.0)
        warptrapAttack = builder
            .comment("Whether Warptraps attack Endermen")
            .translation("$KEY_PREFIX.mobs.warptrap_attack_endermen")
            .define("warptrap_attack_endermen", true)
        shimmerwingFollow = builder
            .comment("Whether Shimmerwings follow players with End's Blessing effect")
            .translation("$KEY_PREFIX.mobs.shimmerwing_follow_blessed_player")
            .define("shimmerwing_follow_blessed_player", true)
        balloonRatPoison = builder
            .comment("Whether Balloon Rat poisons attackers")
            .translation("$KEY_PREFIX.mobs.balloon_rat_poisons_target")
            .define("balloon_rat_poisons_target", true)
        animateBombJelly = builder
            .comment("Whether Bomb Jellies should have animated textures")
            .translation("$KEY_PREFIX.mobs.animate_bomb_jelly")
            .define("animate_bomb_jelly", true)
        smallBombJellyPower = builder
            .comment("How big is the explosion of a Small Bomb Jelly")
            .translation("$KEY_PREFIX.mobs.small_bomb_jelly_explosion_power")
            .defineInRange("small_bomb_jelly_explosion_power", 2.0, 0.0, 100.0)
        mediumBombJellyPower = builder
            .comment("How big is the explosion of a Medium Bomb Jelly")
            .translation("$KEY_PREFIX.mobs.medium_bomb_jelly_explosion_power")
            .defineInRange("medium_bomb_jelly_explosion_power", 3.0, 0.0, 100.0)
        largeBombJellyPower = builder
            .comment("How big is the explosion of a Large Bomb Jelly")
            .translation("$KEY_PREFIX.mobs.large_bomb_jelly_explosion_power")
            .defineInRange("large_bomb_jelly_explosion_power", 4.0, 0.0, 100.0)
        blackIropod = builder
            .comment("1 out of this number chance for an iropod to be black")
            .translation("$KEY_PREFIX.mobs.black_iropod_chance")
            .defineInRange("black_iropod_chance", 100.0, 1.0, 1000000.0)
        shadeletJumpscare = builder
            .comment("Whether Shadelet can jumpscare players")
            .translation("$KEY_PREFIX.mobs.can_shadelet_jumpscare_player")
            .define("can_shadelet_jumpscare_player", true)
        nervoidInfection = builder
            .comment("1 out of this number chance for an enderman in the end to spawn with Endfected effect")
            .translation("$KEY_PREFIX.mobs.nervoid_infection_rate")
            .defineInRange("nervoid_infection_rate", 50.0, 1.0, 1000000.0)
        quartermasterCooldown = builder
            .comment("How long will Corpse Quartermaster wait before healing")
            .translation("$KEY_PREFIX.mobs.quartermaster_heal_cooldown")
            .defineInRange("quartermaster_heal_cooldown", 150.0, 0.0, 1000000.0)
        captainCooldown = builder
            .comment("How long will Corpse Captain wait before summoning backup")
            .translation("$KEY_PREFIX.mobs.captain_summon_cooldown")
            .defineInRange("captain_summon_cooldown", 600.0, 0.0, 1000000.0)
        tankCooldown = builder
            .comment("How long will Corpse Tank wait before shooting")
            .translation("$KEY_PREFIX.mobs.tank_shoot_cooldown")
            .defineInRange("tank_shoot_cooldown", 200.0, 0.0, 1000000.0)
        builder.pop()

        builder.push("items")
        webbedHealth = builder
            .comment("Mobs with this number or lower max health will be webbed when hit by a Web Sack")
            .translation("$KEY_PREFIX.items.webbed_requirement")
            .defineInRange("webbed_requirement", 50.0, 0.0, 1000000.0)
        builder.pop()

        builder.push("blocks")
        cobwebFreeze = builder
            .comment("Whether Freezing Cobwebs Freeze mobs in it")
            .translation("$KEY_PREFIX.blocks.freezing_cobweb_freeze")
            .define("freezing_cobweb_freeze", true)
        builder.pop()
    }
}
