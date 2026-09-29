package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

public class MoreCrittersModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, "more_critters");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_HURT = REGISTRY.register(
        "entity.bunbug.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_DEATH = REGISTRY.register(
        "entity.bunbug.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_DIG = REGISTRY.register(
        "entity.bunbug.dig", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.dig"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SNOWFLAKE_SPIDER_IDLE = REGISTRY.register(
        "entity.snowflake_spider.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.snowflake_spider.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SNOWFLAKE_SPIDER_HURT = REGISTRY.register(
        "entity.snowflake_spider.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.snowflake_spider.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SNOWFLAKE_SPIDER_DEATH = REGISTRY.register(
        "entity.snowflake_spider.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.snowflake_spider.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SNOWFLAKE_SPIDER_STEP = REGISTRY.register(
        "entity.snowflake_spider.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.snowflake_spider.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WEB_SACK_HIT = REGISTRY.register(
        "entity.web_sack.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.web_sack.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHRIEKBAT_IDLE = REGISTRY.register(
        "entity.shriekbat.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shriekbat.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHRIEKBAT_HURT = REGISTRY.register(
        "entity.shriekbat.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shriekbat.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHRIEKBAT_DEATH = REGISTRY.register(
        "entity.shriekbat.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shriekbat.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHRIEKBAT_FLAP = REGISTRY.register(
        "entity.shriekbat.flap", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shriekbat.flap"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHRIEKBAT_SHRIEK = REGISTRY.register(
        "entity.shriekbat.shriek", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shriekbat.shriek"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHRIEK_BOMB_SHRIEK = REGISTRY.register(
        "entity.shriek_bomb.shriek", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shriek_bomb.shriek"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CREEBLOSSOM_HURT = REGISTRY.register(
        "entity.creeblossom.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.creeblossom.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CREEBLOSSOM_DEATH = REGISTRY.register(
        "entity.creeblossom.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.creeblossom.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CREEBLOSSOM_ATTACK = REGISTRY.register(
        "entity.creeblossom.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.creeblossom.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CREEBLOSSOM_PRIMED = REGISTRY.register(
        "entity.creeblossom.primed", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.creeblossom.primed"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CREEBLOSSOM_SPAWN = REGISTRY.register(
        "entity.creeblossom.spawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.creeblossom.spawn"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLOSSOMBUSH_OPENCLOSE = REGISTRY.register(
        "block.blossombush.openclose", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.blossombush.openclose"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BLOSSOMING_EXPLOSION = REGISTRY.register(
        "entity.blossoming_explosion", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.blossoming_explosion"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_CREEBLOSSOM_HURT = REGISTRY.register(
        "entity.electric_creeblossom.hurt",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_creeblossom.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_CREEBLOSSOM_DEATH = REGISTRY.register(
        "entity.electric_creeblossom.death",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_creeblossom.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_CREEBLOSSOM_SPAWN = REGISTRY.register(
        "entity.electric_creeblossom.spawn",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_creeblossom.spawn"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_CREEBLOSSOM_PRIMED = REGISTRY.register(
        "entity.electric_creeblossom.primed",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_creeblossom.primed"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_CREEBLOSSOM_ATTACK = REGISTRY.register(
        "entity.electric_creeblossom.attack",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_creeblossom.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_CREEBLOSSOM_EXPLODE = REGISTRY.register(
        "entity.electric_creeblossom.explode",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_creeblossom.explode"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOUNCELIZARD_IDLE = REGISTRY.register(
        "entity.bouncelizard.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bouncelizard.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOUNCELIZARD_HURT = REGISTRY.register(
        "entity.bouncelizard.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bouncelizard.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOUNCELIZARD_DEATH = REGISTRY.register(
        "entity.bouncelizard.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bouncelizard.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOUNCELIZARD_SNORE = REGISTRY.register(
        "entity.bouncelizard.snore", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bouncelizard.snore"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOUNCELIZARD_SNORE_MIMIMI = REGISTRY.register(
        "entity.bouncelizard.snore_mimimi",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bouncelizard.snore_mimimi"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOUNCELIZARD_BOUNCE = REGISTRY.register(
        "entity.bouncelizard.bounce", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bouncelizard.bounce"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOUNCELIZARD_BIG_BOUNCE = REGISTRY.register(
        "entity.bouncelizard.big_bounce", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bouncelizard.big_bounce"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_STINCARP_HURT = REGISTRY.register(
        "entity.stincarp.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.stincarp.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_STINCARP_DEATH = REGISTRY.register(
        "entity.stincarp.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.stincarp.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_BLAST = REGISTRY.register(
        "entity.electric_blast", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_blast"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ELECTRIC_BOTTLE_DRINK = REGISTRY.register(
        "item.electric_bottle.drink", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.electric_bottle.drink"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_TASER_TASE = REGISTRY.register(
        "item.taser.tase", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.taser.tase"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_ELECTRIC_HUM = REGISTRY.register(
        "ambient.electric_hum", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "ambient.electric_hum"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ELECTRIC_TRANSFER = REGISTRY.register(
        "entity.electric_transfer", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.electric_transfer"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BALLOON_RAT_IDLE = REGISTRY.register(
        "entity.balloon_rat.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.balloon_rat.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BALLOON_RAT_HURT = REGISTRY.register(
        "entity.balloon_rat.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.balloon_rat.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BALLOON_RAT_DEATH = REGISTRY.register(
        "entity.balloon_rat.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.balloon_rat.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BALLOON_RAT_INFLATE = REGISTRY.register(
        "entity.balloon_rat.inflate", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.balloon_rat.inflate"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BALLOON_RAT_DEFLATE = REGISTRY.register(
        "entity.balloon_rat.deflate", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.balloon_rat.deflate"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EXTENSIVE_HURT = REGISTRY.register(
        "entity.extensive_hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.extensive_hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_HALLUCINAZIUM_IDLE = REGISTRY.register(
        "ambient.hallucinazium.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "ambient.hallucinazium.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_HALLUCINAZIUM_MONSTER_LAUGH = REGISTRY.register(
        "entity.hallucinazium_monster.laugh",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.hallucinazium_monster.laugh"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WARPTRAP_IDLE = REGISTRY.register(
        "entity.warptrap.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.warptrap.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WARPTRAP_HURT = REGISTRY.register(
        "entity.warptrap.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.warptrap.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WARPTRAP_DEATH = REGISTRY.register(
        "entity.warptrap.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.warptrap.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WARPTRAP_BITE = REGISTRY.register(
        "entity.warptrap.bite", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.warptrap.bite"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WARPTRAP_DIG = REGISTRY.register(
        "entity.warptrap.dig", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.warptrap.dig"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_ARMOR_STURDY_CHESTPLATE_NULLIFY = REGISTRY.register(
        "item.armor.sturdy_chestplate.nullify",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.armor.sturdy_chestplate.nullify"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_BITING_SHIELD_BITE = REGISTRY.register(
        "item.biting_shield.bite", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.biting_shield.bite"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHIMMERWORM_HURT = REGISTRY.register(
        "entity.shimmerworm.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shimmerworm.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHIMMERWING_IDLE = REGISTRY.register(
        "entity.shimmerwing.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shimmerwing.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHIMMERWING_HURT = REGISTRY.register(
        "entity.shimmerwing.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shimmerwing.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHIMMERWING_DEATH = REGISTRY.register(
        "entity.shimmerwing.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shimmerwing.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHIMMERWING_GIFT = REGISTRY.register(
        "entity.shimmerwing.gift", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shimmerwing.gift"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_REAPER = REGISTRY.register(
        "music_disc.reaper", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "music_disc.reaper"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_IDLE = REGISTRY.register(
        "entity.mightshroom.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_HURT = REGISTRY.register(
        "entity.mightshroom.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_DEATH = REGISTRY.register(
        "entity.mightshroom.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_ATTACK = REGISTRY.register(
        "entity.mightshroom.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_LEAP_READY = REGISTRY.register(
        "entity.mightshroom.leap_ready", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.leap_ready"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_LEAP = REGISTRY.register(
        "entity.mightshroom.leap", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.leap"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_CRASH = REGISTRY.register(
        "entity.mightshroom.crash", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.crash"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_PECK_READY = REGISTRY.register(
        "entity.mightshroom.peck_ready", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.peck_ready"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_PECK_HIT = REGISTRY.register(
        "entity.mightshroom.peck_hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.peck_hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_PECK_MISS = REGISTRY.register(
        "entity.mightshroom.peck_miss", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.peck_miss"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_SCREAM = REGISTRY.register(
        "entity.mightshroom.scream", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.scream"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_STOMP = REGISTRY.register(
        "entity.mightshroom.stomp", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.stomp"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_TRANSFORM = REGISTRY.register(
        "entity.mightshroom.transform", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.transform"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FUNGAL_ZOMBIE_IDLE = REGISTRY.register(
        "entity.fungal_zombie.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fungal_zombie.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FUNGAL_ZOMBIE_HURT = REGISTRY.register(
        "entity.fungal_zombie.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fungal_zombie.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FUNGAL_ZOMBIE_DEATH = REGISTRY.register(
        "entity.fungal_zombie.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fungal_zombie.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FUNGAL_ZOMBIE_TRANSFORM = REGISTRY.register(
        "entity.fungal_zombie.transform", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fungal_zombie.transform"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MIGHTSHROOM_STEP = REGISTRY.register(
        "entity.mightshroom.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mightshroom.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRIGHTSHROOM_IDLE = REGISTRY.register(
        "entity.frightshroom.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.frightshroom.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRIGHTSHROOM_HURT = REGISTRY.register(
        "entity.frightshroom.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.frightshroom.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRIGHTSHROOM_DEATH = REGISTRY.register(
        "entity.frightshroom.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.frightshroom.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRIGHTSHROOM_ATTACK = REGISTRY.register(
        "entity.frightshroom.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.frightshroom.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRIGHTSHROOM_SPIT = REGISTRY.register(
        "entity.frightshroom.spit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.frightshroom.spit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRIGHTSHROOM_BURST = REGISTRY.register(
        "entity.frightshroom.burst", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.frightshroom.burst"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NIGHTSHROOM_IDLE = REGISTRY.register(
        "entity.nightshroom.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nightshroom.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NIGHTSHROOM_HURT = REGISTRY.register(
        "entity.nightshroom.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nightshroom.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NIGHTSHROOM_DEATH = REGISTRY.register(
        "entity.nightshroom.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nightshroom.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NIGHTSHROOM_ATTACK = REGISTRY.register(
        "entity.nightshroom.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nightshroom.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ANCIENT_SKELETON_PLACE = REGISTRY.register(
        "entity.ancient_skeleton.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ancient_skeleton.place"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ANCIENT_SKELETON_HURT = REGISTRY.register(
        "entity.ancient_skeleton.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ancient_skeleton.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ANCIENT_SKELETON_RISE = REGISTRY.register(
        "entity.ancient_skeleton.rise", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ancient_skeleton.rise"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_CRITTERLING_SACK_PICK_UP = REGISTRY.register(
        "item.critterling_sack.pick_up", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.critterling_sack.pick_up"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_CRITTERLING_SACK_PUT_DOWN = REGISTRY.register(
        "item.critterling_sack.put_down", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.critterling_sack.put_down"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CARRYBUG_IDLE = REGISTRY.register(
        "entity.carrybug.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.carrybug.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CARRYBUG_HURT = REGISTRY.register(
        "entity.carrybug.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.carrybug.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CARRYBUG_DEATH = REGISTRY.register(
        "entity.carrybug.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.carrybug.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CARRYBUG_STEP = REGISTRY.register(
        "entity.carrybug.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.carrybug.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_ANGEL_HEAL = REGISTRY.register(
        "ambient.angel.heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "ambient.angel.heal"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_REAPER_READY = REGISTRY.register(
        "ambient.reaper.ready", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "ambient.reaper.ready"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_REAPER_HIT = REGISTRY.register(
        "ambient.reaper.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "ambient.reaper.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_REAPER_RAGE = REGISTRY.register(
        "ambient.reaper.rage", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "ambient.reaper.rage"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MORI_ROOTS_BITE = REGISTRY.register(
        "entity.mori_roots.bite", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mori_roots.bite"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MORI_ROOTS_RELEASE = REGISTRY.register(
        "entity.mori_roots.release", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mori_roots.release"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_REAPER_GRUMBLE = REGISTRY.register(
        "ambient.reaper.grumble", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "ambient.reaper.grumble"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_FUNGAL_STAFF_HEAL = REGISTRY.register(
        "item.fungal_staff.heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.fungal_staff.heal"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_FUNGAL_STAFF_BIG_HEAL = REGISTRY.register(
        "item.fungal_staff.big_heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.fungal_staff.big_heal"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WANDERING_COLLECTOR_IDLE = REGISTRY.register(
        "entity.wandering_collector.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.wandering_collector.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WANDERING_COLLECTOR_HURT = REGISTRY.register(
        "entity.wandering_collector.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.wandering_collector.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WANDERING_COLLECTOR_DEATH = REGISTRY.register(
        "entity.wandering_collector.death",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.wandering_collector.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_WANDERING_COLLECTOR_TRADE = REGISTRY.register(
        "entity.wandering_collector.trade",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.wandering_collector.trade"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CRITTER_EATER_IDLE = REGISTRY.register(
        "entity.critter_eater.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.critter_eater.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CRITTER_EATER_HURT = REGISTRY.register(
        "entity.critter_eater.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.critter_eater.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CRITTER_EATER_DEATH = REGISTRY.register(
        "entity.critter_eater.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.critter_eater.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CRITTER_EATER_MOVE = REGISTRY.register(
        "entity.critter_eater.move", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.critter_eater.move"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CRITTER_EATER_ATTACK = REGISTRY.register(
        "entity.critter_eater.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.critter_eater.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUBEFROG_IDLE = REGISTRY.register(
        "entity.cubefrog.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.cubefrog.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUBEFROG_HURT = REGISTRY.register(
        "entity.cubefrog.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.cubefrog.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUBEFROG_JUMP = REGISTRY.register(
        "entity.cubefrog.jump", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.cubefrog.jump"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SCOWL_IDLE = REGISTRY.register(
        "entity.scowl.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.scowl.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SCOWL_HURT = REGISTRY.register(
        "entity.scowl.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.scowl.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SCOWL_FLY = REGISTRY.register(
        "entity.scowl.fly", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.scowl.fly"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DUNGER_HURT = REGISTRY.register(
        "entity.dunger.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dunger.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EXPY_HURT = REGISTRY.register(
        "entity.expy.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.expy.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EXPY_DEATH = REGISTRY.register(
        "entity.expy.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.expy.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROLLBALL_HURT = REGISTRY.register(
        "entity.rollball.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rollball.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROLLBALL_ROLL = REGISTRY.register(
        "entity.rollball.roll", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rollball.roll"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROLLBALL_UNROLL = REGISTRY.register(
        "entity.rollball.unroll", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rollball.unroll"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SNEK_IDLE = REGISTRY.register(
        "entity.snek.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.snek.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SNEK_HURT = REGISTRY.register(
        "entity.snek.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.snek.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_PLAINSWYRM_HURT = REGISTRY.register(
        "entity.plainswyrm.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.plainswyrm.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_COMBUSTION_BEEP = REGISTRY.register(
        "entity.combustion_beep", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.combustion_beep"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_COMBUSTION_WARNING = REGISTRY.register(
        "entity.combustion_warning", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.combustion_warning"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOMB_JELLY_HURT = REGISTRY.register(
        "entity.bomb_jelly.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bomb_jelly.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BOMB_JELLY_EXPLODE = REGISTRY.register(
        "entity.bomb_jelly.explode", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bomb_jelly.explode"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_EXPLOSIVE_JELLY_RUB = REGISTRY.register(
        "item.explosive_jelly.rub", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.explosive_jelly.rub"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_JELLY_TORPEDO_SPAWN = REGISTRY.register(
        "entity.jelly_torpedo.spawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.jelly_torpedo.spawn"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_JELLY_TORPEDO_EXPLODE = REGISTRY.register(
        "entity.jelly_torpedo.explode", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.jelly_torpedo.explode"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AVOIDER_HURT = REGISTRY.register(
        "entity.avoider.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.avoider.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AVOIDER_STUN = REGISTRY.register(
        "entity.avoider.stun", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.avoider.stun"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_BOOSTER_PUMP_UNDERWATER = REGISTRY.register(
        "item.booster_pump.underwater", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.booster_pump.underwater"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_BOOSTER_PUMP_LAND = REGISTRY.register(
        "item.booster_pump.land", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.booster_pump.land"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROPOD_IDLE = REGISTRY.register(
        "entity.iropod.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iropod.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROPOD_HURT = REGISTRY.register(
        "entity.iropod.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iropod.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROPOD_DEATH = REGISTRY.register(
        "entity.iropod.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iropod.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROPOD_LOCK = REGISTRY.register(
        "entity.iropod.lock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iropod.lock"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROPOD_UNLOCK = REGISTRY.register(
        "entity.iropod.unlock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iropod.unlock"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROPOD_SHED = REGISTRY.register(
        "entity.iropod.shed", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iropod.shed"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BLUBBERFISH_HURT = REGISTRY.register(
        "entity.blubberfish.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.blubberfish.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_KELPIRE_IDLE = REGISTRY.register(
        "entity.kelpire.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.kelpire.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_KELPIRE_HURT = REGISTRY.register(
        "entity.kelpire.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.kelpire.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_KELPIRE_DEATH = REGISTRY.register(
        "entity.kelpire.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.kelpire.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_KELPIRE_BITE = REGISTRY.register(
        "entity.kelpire.bite", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.kelpire.bite"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_KELPIRE_BURP = REGISTRY.register(
        "entity.kelpire.burp", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.kelpire.burp"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BLOOD_BUBBLE_POP = REGISTRY.register(
        "entity.blood_bubble.pop", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.blood_bubble.pop"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NAUTICRAWL_IDLE = REGISTRY.register(
        "entity.nauticrawl.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nauticrawl.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NAUTICRAWL_HURT = REGISTRY.register(
        "entity.nauticrawl.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nauticrawl.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NAUTICRAWL_DEATH = REGISTRY.register(
        "entity.nauticrawl.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nauticrawl.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NAUTICRAWL_ATTACK = REGISTRY.register(
        "entity.nauticrawl.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nauticrawl.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NAUTICRAWL_ROLL = REGISTRY.register(
        "entity.nauticrawl.roll", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nauticrawl.roll"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NAUTICRAWL_UNROLL = REGISTRY.register(
        "entity.nauticrawl.unroll", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nauticrawl.unroll"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> OPALCRAB_HURT = REGISTRY.register(
        "opalcrab_hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "opalcrab_hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_SAILS = REGISTRY.register(
        "music_disc.sails", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "music_disc.sails"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BALLOON_RAT_TRANSFORM = REGISTRY.register(
        "entity.balloon_rat.transform", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.balloon_rat.transform"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIMMERWING_SHED = REGISTRY.register(
        "shimmerwing_shed", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "shimmerwing_shed"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHADELET_IDLE = REGISTRY.register(
        "entity.shadelet.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shadelet.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHADELET_HURT = REGISTRY.register(
        "entity.shadelet.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shadelet.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHADELET_DEATH = REGISTRY.register(
        "entity.shadelet.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shadelet.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHADELET_SCREAM = REGISTRY.register(
        "entity.shadelet.scream", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shadelet.scream"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_BREAK = REGISTRY.register(
        "block.black_resin.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin.break"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_PLACE = REGISTRY.register(
        "block.black_resin.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin.place"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_FALL = REGISTRY.register(
        "block.black_resin.fall", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin.fall"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_FOOTSTEPS = REGISTRY.register(
        "block.black_resin.footsteps", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin.footsteps"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_BRICKS_BREAK = REGISTRY.register(
        "block.black_resin_bricks.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin_bricks.break"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_BRICKS_PLACE = REGISTRY.register(
        "block.black_resin_bricks.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin_bricks.place"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_BRICKS_BREAKING = REGISTRY.register(
        "block.black_resin_bricks.breaking",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin_bricks.breaking"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_BRICKS_FALL = REGISTRY.register(
        "block.black_resin_bricks.fall", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin_bricks.fall"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BLACK_RESIN_BRICKS_FOOTSTEPS = REGISTRY.register(
        "block.black_resin_bricks.footsteps",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.black_resin_bricks.footsteps"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLET_IDLE = REGISTRY.register(
        "entity.treeplet.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treeplet.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLET_HURT = REGISTRY.register(
        "entity.treeplet.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treeplet.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLET_DEATH = REGISTRY.register(
        "entity.treeplet.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treeplet.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLET_SPIN = REGISTRY.register(
        "entity.treeplet.spin", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treeplet.spin"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLET_SPIT = REGISTRY.register(
        "entity.treeplet.spit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treeplet.spit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLET_STEP = REGISTRY.register(
        "entity.treeplet.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treeplet.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLING_IDLE = REGISTRY.register(
        "entity.treepling.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treepling.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLING_HURT = REGISTRY.register(
        "entity.treepling.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treepling.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLING_DEATH = REGISTRY.register(
        "entity.treepling.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treepling.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TREEPLING_STEP = REGISTRY.register(
        "entity.treepling.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.treepling.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_EERIE_DART_SHOOT = REGISTRY.register(
        "item.eerie_dart.shoot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.eerie_dart.shoot"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_EERIE_DART_HIT = REGISTRY.register(
        "item.eerie_dart.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.eerie_dart.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BRAIN_PLACE = REGISTRY.register(
        "block.brain.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.brain.place"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BRAIN_BREAK = REGISTRY.register(
        "block.brain.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.brain.break"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BRAIN_BREAKING = REGISTRY.register(
        "block.brain.breaking", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.brain.breaking"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BRAIN_FALL = REGISTRY.register(
        "block.brain.fall", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.brain.fall"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_BRAIN_FOOTSTEPS = REGISTRY.register(
        "block.brain.footsteps", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.brain.footsteps"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_IDLE = REGISTRY.register(
        "entity.nervoid.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_HURT = REGISTRY.register(
        "entity.nervoid.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_DEATH = REGISTRY.register(
        "entity.nervoid.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_ATTACK = REGISTRY.register(
        "entity.nervoid.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_RUSH_READY = REGISTRY.register(
        "entity.nervoid.rush_ready", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.rush_ready"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_RUSH_START = REGISTRY.register(
        "entity.nervoid.rush_start", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.rush_start"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_POSSESS = REGISTRY.register(
        "entity.nervoid.possess", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.possess"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NERVOID_UNPOSSESS = REGISTRY.register(
        "entity.nervoid.unpossess", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nervoid.unpossess"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_SHIP_WHEEL_SPIN = REGISTRY.register(
        "block.ship_wheel.spin", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.ship_wheel.spin"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CANNON_PLACE = REGISTRY.register(
        "block.cannon.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.cannon.place"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CANNON_BREAKING = REGISTRY.register(
        "block.cannon.breaking", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.cannon.breaking"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CANNON_BREAK = REGISTRY.register(
        "block.cannon.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.cannon.break"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CANNON_FIRE = REGISTRY.register(
        "block.cannon.fire", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.cannon.fire"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CANNON_BALL_COLD_HIT = REGISTRY.register(
        "entity.cannon_ball_cold.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.cannon_ball_cold.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CANNON_BALL_FIRE_HIT = REGISTRY.register(
        "entity.cannon_ball_fire.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.cannon_ball_fire.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CANNON_BALL_SLIME_HIT = REGISTRY.register(
        "entity.cannon_ball_slime.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.cannon_ball_slime.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_PLACE = REGISTRY.register(
        "block.treasure_chest.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.place"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_BREAK = REGISTRY.register(
        "block.treasure_chest.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.break"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_BREAKING = REGISTRY.register(
        "block.treasure_chest.breaking", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.breaking"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_OPEN = REGISTRY.register(
        "block.treasure_chest.open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.open"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_REFUSE = REGISTRY.register(
        "block.treasure_chest.refuse", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.refuse"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_UNLOCK = REGISTRY.register(
        "block.treasure_chest.unlock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.unlock"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_UNLID = REGISTRY.register(
        "block.treasure_chest.unlid", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.unlid"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_TREASURE_CHEST_DESTROY = REGISTRY.register(
        "block.treasure_chest.destroy", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.treasure_chest.destroy"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_IDLE = REGISTRY.register(
        "entity.corpse_mate.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_SPEECH = REGISTRY.register(
        "entity.corpse_mate.speech", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.speech"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_SING = REGISTRY.register(
        "entity.corpse_mate.sing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.sing"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_HURT = REGISTRY.register(
        "entity.corpse_mate.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_DEATH = REGISTRY.register(
        "entity.corpse_mate.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_READY = REGISTRY.register(
        "entity.corpse_mate.ready", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.ready"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_ATTACK = REGISTRY.register(
        "entity.corpse_mate.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_MATE_MISS = REGISTRY.register(
        "entity.corpse_mate.miss", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_mate.miss"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_QUARTERMASTER_IDLE = REGISTRY.register(
        "entity.corpse_quartermaster.idle",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_quartermaster.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_QUARTERMASTER_HURT = REGISTRY.register(
        "entity.corpse_quartermaster.hurt",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_quartermaster.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_QUARTERMASTER_DEATH = REGISTRY.register(
        "entity.corpse_quartermaster.death",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_quartermaster.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_QUARTERMASTER_BITE = REGISTRY.register(
        "entity.corpse_quartermaster.bite",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_quartermaster.bite"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_QUARTERMASTER_SPEECH = REGISTRY.register(
        "entity.corpse_quartermaster.speech",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_quartermaster.speech"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_QUARTERMASTER_SING = REGISTRY.register(
        "entity.corpse_quartermaster.sing",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_quartermaster.sing"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_QUARTERMASTER_THROW = REGISTRY.register(
        "entity.corpse_quartermaster.throw",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_quartermaster.throw"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_HEALING_RUM_BREAK = REGISTRY.register(
        "entity.healing_rum.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.healing_rum.break"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_TOOTH_SYRINGE_USE = REGISTRY.register(
        "item.tooth_syringe.use", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.tooth_syringe.use"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_IDLE = REGISTRY.register(
        "entity.corpse_tank.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_HURT = REGISTRY.register(
        "entity.corpse_tank.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_DEATH = REGISTRY.register(
        "entity.corpse_tank.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_ATTACK = REGISTRY.register(
        "entity.corpse_tank.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_SPEECH = REGISTRY.register(
        "entity.corpse_tank.speech", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.speech"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_SING = REGISTRY.register(
        "entity.corpse_tank.sing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.sing"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_READY = REGISTRY.register(
        "entity.corpse_tank.ready", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.ready"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_TANK_SHOOT = REGISTRY.register(
        "entity.corpse_tank.shoot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_tank.shoot"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_IDLE = REGISTRY.register(
        "entity.corpse_captain.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_HURT = REGISTRY.register(
        "entity.corpse_captain.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_DEATH = REGISTRY.register(
        "entity.corpse_captain.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_ATTACK = REGISTRY.register(
        "entity.corpse_captain.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_SPEECH = REGISTRY.register(
        "entity.corpse_captain.speech", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.speech"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_SING = REGISTRY.register(
        "entity.corpse_captain.sing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.sing"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_SOUL_RUM_BREAK = REGISTRY.register(
        "item.soul_rum.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.soul_rum.break"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_PARROT_IDLE = REGISTRY.register(
        "entity.corpse_parrot.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_parrot.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_PARROT_HURT = REGISTRY.register(
        "entity.corpse_parrot.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_parrot.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_PARROT_DEATH = REGISTRY.register(
        "entity.corpse_parrot.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_parrot.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_PARROT_ATTACK = REGISTRY.register(
        "entity.corpse_parrot.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_parrot.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_PARROT_SPEECH = REGISTRY.register(
        "entity.corpse_parrot.speech", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_parrot.speech"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_PARROT_SING = REGISTRY.register(
        "entity.corpse_parrot.sing", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_parrot.sing"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TAMED_CORPSE_PARROT_IDLE = REGISTRY.register(
        "entity.tamed_corpse_parrot.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.tamed_corpse_parrot.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TAMED_CORPSE_PARROT_HURT = REGISTRY.register(
        "entity.tamed_corpse_parrot.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.tamed_corpse_parrot.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_TAMED_CORPSE_PARROT_DEATH = REGISTRY.register(
        "entity.tamed_corpse_parrot.death",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.tamed_corpse_parrot.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MOTHKID_IDLE = REGISTRY.register(
        "entity.mothkid.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mothkid.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MOTHKID_HURT = REGISTRY.register(
        "entity.mothkid.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mothkid.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MOTHKID_DEATH = REGISTRY.register(
        "entity.mothkid.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mothkid.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MOTHKID_FLY = REGISTRY.register(
        "entity.mothkid.fly", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mothkid.fly"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GILLMUNCH_IDLE = REGISTRY.register(
        "entity.gillmunch.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gillmunch.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GILLMUNCH_HURT = REGISTRY.register(
        "entity.gillmunch.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gillmunch.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GILLMUNCH_DEATH = REGISTRY.register(
        "entity.gillmunch.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gillmunch.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_GROOVEYARD = REGISTRY.register(
        "music_disc.grooveyard", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "music_disc.grooveyard"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_7 = REGISTRY.register(
        "music_disc.7", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "music_disc.7"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_STEP = REGISTRY.register(
        "entity.bunbug.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_SHED = REGISTRY.register(
        "entity.bunbug.shed", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.shed"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_CREAM = REGISTRY.register(
        "entity.bunbug.cream", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.cream"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_BERRY = REGISTRY.register(
        "entity.bunbug.berry", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.berry"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BUNBUG_SPRINKLE = REGISTRY.register(
        "entity.bunbug.sprinkle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.bunbug.sprinkle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROT_ZOMBIE_IDLE = REGISTRY.register(
        "entity.rot_zombie.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rot_zombie.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROT_ZOMBIE_HURT = REGISTRY.register(
        "entity.rot_zombie.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rot_zombie.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROT_ZOMBIE_DEATH = REGISTRY.register(
        "entity.rot_zombie.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rot_zombie.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROT_ZOMBIE_SPAWN = REGISTRY.register(
        "entity.rot_zombie.spawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rot_zombie.spawn"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BLUBBERFISH_EXPLODE = REGISTRY.register(
        "entity.blubberfish.explode", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.blubberfish.explode"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_TAZEGUN_SHOOT = REGISTRY.register(
        "item.tazegun.shoot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.tazegun.shoot"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_TAZEGUN_EXPLODE = REGISTRY.register(
        "item.tazegun.explode", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.tazegun.explode"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_TAZEGUN_REFUSE = REGISTRY.register(
        "item.tazegun.refuse", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.tazegun.refuse"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_TAZEGUN_RELOAD = REGISTRY.register(
        "item.tazegun.reload", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.tazegun.reload"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_WADDLE = REGISTRY.register(
        "music_disc.waddle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "music_disc.waddle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_NAUTICRAWL_RAMEN_EAT = REGISTRY.register(
        "block.nauticrawl_ramen.eat", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.nauticrawl_ramen.eat"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_NAUTICRAWL_RAMEN_DRINK = REGISTRY.register(
        "block.nauticrawl_ramen.drink", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.nauticrawl_ramen.drink"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_NAUTICRAWL_RAMEN_CRUNCH = REGISTRY.register(
        "block.nauticrawl_ramen.crunch", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.nauticrawl_ramen.crunch"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GRAVEDIGGER_SNIFF = REGISTRY.register(
        "entity.gravedigger.sniff", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gravedigger.sniff"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GRAVEDIGGER_GROWL = REGISTRY.register(
        "entity.gravedigger.growl", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gravedigger.growl"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GRAVEDIGGER_HURT = REGISTRY.register(
        "entity.gravedigger.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gravedigger.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GRAVEDIGGER_DEATH = REGISTRY.register(
        "entity.gravedigger.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gravedigger.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GRAVEDIGGER_DIG_DOWN = REGISTRY.register(
        "entity.gravedigger.dig_down", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gravedigger.dig_down"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_GRAVEDIGGER_DIG_UP = REGISTRY.register(
        "entity.gravedigger.dig_up", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.gravedigger.dig_up"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> GRAVE_BRUSH_USE = REGISTRY.register(
        "grave_brush_use", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "grave_brush_use"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AMALGAM_IDLE = REGISTRY.register(
        "entity.amalgam.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.amalgam.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AMALGAM_HURT = REGISTRY.register(
        "entity.amalgam.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.amalgam.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AMALGAM_DEATH = REGISTRY.register(
        "entity.amalgam.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.amalgam.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_AMALGAM_ATTACK = REGISTRY.register(
        "entity.amalgam.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.amalgam.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SHRIEKBAT_TEST_SHRIEK = REGISTRY.register(
        "entity.shriekbat.test_shriek", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.shriekbat.test_shriek"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_RAMCHU_IDLE = REGISTRY.register(
        "entity.ramchu.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ramchu.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_RAMCHU_HURT = REGISTRY.register(
        "entity.ramchu.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ramchu.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_RAMCHU_ATTACK = REGISTRY.register(
        "entity.ramchu.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ramchu.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_RAMCHU_BUST = REGISTRY.register(
        "entity.ramchu.bust", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ramchu.bust"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_RAMCHU_OIL = REGISTRY.register(
        "entity.ramchu.oil", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ramchu.oil"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> EFFECT_OILED_UP_OIL_SLIP = REGISTRY.register(
        "effect.oiled_up.oil_slip", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "effect.oiled_up.oil_slip"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_HURT = REGISTRY.register(
        "entity.custodian.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_DEATH = REGISTRY.register(
        "entity.custodian.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_LASER_START = REGISTRY.register(
        "entity.custodian.laser_start", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.laser_start"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_LASER_SHOOT_WARDEN = REGISTRY.register(
        "entity.custodian.laser_shoot_warden",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.laser_shoot_warden"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_SHOOT = REGISTRY.register(
        "entity.custodian.shoot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.shoot"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_CLOSE = REGISTRY.register(
        "entity.custodian.close", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.close"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_OPEN = REGISTRY.register(
        "entity.custodian.open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.open"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_STEP = REGISTRY.register(
        "entity.custodian.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CUSTODIAN_SPIN = REGISTRY.register(
        "entity.custodian.spin", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.custodian.spin"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_STALK_IDLE = REGISTRY.register(
        "entity.stalk.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.stalk.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_STALK_HURT = REGISTRY.register(
        "entity.stalk.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.stalk.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ARMOSSILLO_IDLE = REGISTRY.register(
        "entity.armossillo.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.armossillo.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ARMOSSILLO_HURT = REGISTRY.register(
        "entity.armossillo.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.armossillo.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ARMOSSILLO_DEATH = REGISTRY.register(
        "entity.armossillo.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.armossillo.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ARMOSSILLO_SIT = REGISTRY.register(
        "entity.armossillo.sit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.armossillo.sit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ARMOSSILLO_RISE = REGISTRY.register(
        "entity.armossillo.rise", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.armossillo.rise"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ARMOSSILLO_SNEEZE_READY = REGISTRY.register(
        "entity.armossillo.sneeze_ready", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.armossillo.sneeze_ready"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ARMOSSILLO_SNEEZE = REGISTRY.register(
        "entity.armossillo.sneeze", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.armossillo.sneeze"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BABY_ARMOSSILLO_IDLE = REGISTRY.register(
        "entity.baby_armossillo.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.baby_armossillo.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BABY_ARMOSSILLO_HURT = REGISTRY.register(
        "entity.baby_armossillo.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.baby_armossillo.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_BABY_ARMOSSILLO_DEATH = REGISTRY.register(
        "entity.baby_armossillo.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.baby_armossillo.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DRIPPER_HURT = REGISTRY.register(
        "entity.dripper.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dripper.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DRIPPER_DEATH = REGISTRY.register(
        "entity.dripper.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dripper.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DRIPPER_ATTACK = REGISTRY.register(
        "entity.dripper.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dripper.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DRIPPER_STEP = REGISTRY.register(
        "entity.dripper.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dripper.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DRIPPER_JUMP = REGISTRY.register(
        "entity.dripper.jump", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dripper.jump"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DRIPPER_LAND = REGISTRY.register(
        "entity.dripper.land", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dripper.land"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_SLASHKLUB_ATTACK = REGISTRY.register(
        "item.slashklub.attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.slashklub.attack"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_ALERT = REGISTRY.register(
        "entity.corpse_captain.alert", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.alert"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_CAPTAIN_HEAL = REGISTRY.register(
        "entity.corpse_captain.heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_captain.heal"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_PARROT_THROW = REGISTRY.register(
        "entity.corpse_parrot.throw", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_parrot.throw"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CHATTERING_TEETH_START = REGISTRY.register(
        "entity.chattering_teeth.start", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.chattering_teeth.start"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CHATTERING_TEETH_END = REGISTRY.register(
        "entity.chattering_teeth.end", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.chattering_teeth.end"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CHATTERING_TEETH_STEP = REGISTRY.register(
        "entity.chattering_teeth.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.chattering_teeth.step"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_LOOKOUT_IDLE = REGISTRY.register(
        "entity.corpse_lookout.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_lookout.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_LOOKOUT_HURT = REGISTRY.register(
        "entity.corpse_lookout.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_lookout.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_LOOKOUT_DEATH = REGISTRY.register(
        "entity.corpse_lookout.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_lookout.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_LOOKOUT_SPIT = REGISTRY.register(
        "entity.corpse_lookout.spit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_lookout.spit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CORPSE_LOOKOUT_SPIT_HITS = REGISTRY.register(
        "entity.corpse_lookout.spit_hits", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.corpse_lookout.spit_hits"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_EVOLUTION_TABLE_EVOLVE_RARE = REGISTRY.register(
        "block.evolution_table.evolve_rare",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.evolution_table.evolve_rare"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_EVOLUTION_TABLE_EVOLVE_EPIC = REGISTRY.register(
        "block.evolution_table.evolve_epic",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.evolution_table.evolve_epic"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ITEM_CLOSED_CRITTERLING_SACK_JACKPOT = REGISTRY.register(
        "item.closed_critterling_sack.jackpot",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "item.closed_critterling_sack.jackpot"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DOMINIC_IDLE = REGISTRY.register(
        "entity.dominic.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dominic.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_DOMINIC_HURT = REGISTRY.register(
        "entity.dominic.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.dominic.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_OLMER_HURT = REGISTRY.register(
        "entity.olmer.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.olmer.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FLARG_IDLE = REGISTRY.register(
        "entity.flarg.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.flarg.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FLARG_HURT = REGISTRY.register(
        "entity.flarg.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.flarg.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_PIRANHEED_IDLE = REGISTRY.register(
        "entity.piranheed.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.piranheed.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_PIRANHEED_HURT = REGISTRY.register(
        "entity.piranheed.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.piranheed.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MANGOTRICE_IDLE = REGISTRY.register(
        "entity.mangotrice.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mangotrice.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_MANGOTRICE_HURT = REGISTRY.register(
        "entity.mangotrice.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.mangotrice.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRESNOID_IDLE = REGISTRY.register(
        "entity.fresnoid.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fresnoid.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRESNOID_HURT = REGISTRY.register(
        "entity.fresnoid.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fresnoid.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRESNOID_YAWN = REGISTRY.register(
        "entity.fresnoid.yawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fresnoid.yawn"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FRESNOID_YAWN_GOOFY = REGISTRY.register(
        "entity.fresnoid.yawn_goofy", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.fresnoid.yawn_goofy"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_CARRYBUG_KICK = REGISTRY.register(
        "entity.carrybug.kick", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.carrybug.kick"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EVOLUTIONER_IDLE = REGISTRY.register(
        "entity.evolutioner.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.evolutioner.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EVOLUTIONER_HURT = REGISTRY.register(
        "entity.evolutioner.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.evolutioner.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EVOLUTIONER_DEATH = REGISTRY.register(
        "entity.evolutioner.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.evolutioner.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EVOLUTIONER_CHANT = REGISTRY.register(
        "entity.evolutioner.chant", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.evolutioner.chant"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_EVOLUTIONER_TRANSFORM = REGISTRY.register(
        "entity.evolutioner.transform", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.evolutioner.transform"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ANCIENT_SKELETON_POUR_SOUP = REGISTRY.register(
        "entity.ancient_skeleton.pour_soup",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.ancient_skeleton.pour_soup"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROT_SPLASH_START = REGISTRY.register(
        "entity.rot_splash.start", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rot_splash.start"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROT_SPLASH_END = REGISTRY.register(
        "entity.rot_splash.end", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rot_splash.end"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ROT_SPLASH_IDLE = REGISTRY.register(
        "entity.rot_splash.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.rot_splash.idle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_NIGHTSHROOM_RUFFLE = REGISTRY.register(
        "entity.nightshroom.ruffle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.nightshroom.ruffle"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_LIGHTFLY_TARGET = REGISTRY.register(
        "entity.lightfly.target", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.lightfly.target"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_LIGHTFLY_HIT = REGISTRY.register(
        "entity.lightfly.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.lightfly.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_PARTY = REGISTRY.register(
        "music_disc.party", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "music_disc.party"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_COBBLE_HURT = REGISTRY.register(
        "entity.cobble.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.cobble.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_SNEEZE = REGISTRY.register(
        "entity.sneeze", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.sneeze"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CONFETTI_POPPER_POP = REGISTRY.register(
        "block.confetti_popper.pop", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.confetti_popper.pop"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROBALL_HURT = REGISTRY.register(
        "entity.iroball.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iroball.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_IROBALL_HIT = REGISTRY.register(
        "entity.iroball.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.iroball.hit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_RUM_SLIP = REGISTRY.register(
        "block.rum.slip", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.rum.slip"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_RUM_BIG_SLIP = REGISTRY.register(
        "block.rum.big_slip", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "block.rum.big_slip"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ANNIVETERAN_HURT = REGISTRY.register(
        "entity.anniveteran.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.anniveteran.hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ANNIVETERAN_DEATH = REGISTRY.register(
        "entity.anniveteran.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.anniveteran.death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_ANNIVETERAN_STEP = REGISTRY.register(
        "entity.anniveteran.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("more_critters", "entity.anniveteran.step"))
    );
}
