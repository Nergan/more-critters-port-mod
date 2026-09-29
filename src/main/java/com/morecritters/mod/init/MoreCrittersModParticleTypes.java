package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

public class MoreCrittersModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, "more_critters");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOSSOM_PARTICLE = REGISTRY.register("blossom_particle", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOSSOM_EXPLOSION = REGISTRY.register("blossom_explosion", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RECRUITED_LEAF = REGISTRY.register("recruited_leaf", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ZZZ = REGISTRY.register("zzz", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BOOST = REGISTRY.register("boost", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ZAP = REGISTRY.register("zap", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BRITTLE_HEART = REGISTRY.register("brittle_heart", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LOCKED_HEART = REGISTRY.register("locked_heart", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DROWN_BUBBLE = REGISTRY.register("drown_bubble", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BONE_DEBRIS = REGISTRY.register("bone_debris", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_EYE = REGISTRY.register("pink_eye", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_SPIRAL = REGISTRY.register("pink_spiral", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BITE = REGISTRY.register("bite", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STURDY_DEBRIS = REGISTRY.register("sturdy_debris", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHIMMER = REGISTRY.register("shimmer", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> REAPER = REGISTRY.register("reaper", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MAD_REAPER = REGISTRY.register("mad_reaper", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ANGEL = REGISTRY.register("angel", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> HEAL_SHIMMER = REGISTRY.register("heal_shimmer", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STUN_STAR = REGISTRY.register("stun_star", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> YELLOW_STRIPE = REGISTRY.register("yellow_stripe", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLACK_STRIPE = REGISTRY.register("black_stripe", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MIGHTSHROOM_FEATHER = REGISTRY.register("mightshroom_feather", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ROT = REGISTRY.register("rot", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ZAP_SPARK = REGISTRY.register("zap_spark", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> XP = REGISTRY.register("xp", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DASH = REGISTRY.register("dash", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD_BUBBLE_PARTICLE = REGISTRY.register(
        "blood_bubble_particle", () -> new SimpleParticleType(true)
    );
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD_BUBBLE_POP = REGISTRY.register("blood_bubble_pop", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MEDIC_STRIPE = REGISTRY.register("medic_stripe", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SOLDIER_STRIPE = REGISTRY.register("soldier_stripe", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RESIN = REGISTRY.register("resin", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> END_EXPLOSION = REGISTRY.register("end_explosion", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPINAL_FLUID = REGISTRY.register("spinal_fluid", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STINK = REGISTRY.register("stink", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ICE_ON = REGISTRY.register("ice_on", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ICE_OFF = REGISTRY.register("ice_off", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> HEAL_PLUS = REGISTRY.register("heal_plus", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPRINKLE = REGISTRY.register("sprinkle", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WHITE_SPRINKLE = REGISTRY.register("white_sprinkle", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> REMAINS = REGISTRY.register("remains", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CUSTODIAN_LAZER = REGISTRY.register("custodian_lazer", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WARDEN_EXPLOSION = REGISTRY.register("warden_explosion", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHRIEKBAT_SHRIEK = REGISTRY.register("shriekbat_shriek", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ALERT = REGISTRY.register("alert", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ALERTED = REGISTRY.register("alerted", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> XPRARE = REGISTRY.register("xprare", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> XPEPIC = REGISTRY.register("xpepic", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EPIC_PARTICLE = REGISTRY.register("epic_particle", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EVOLIGHTENED_PARTICLE = REGISTRY.register(
        "evolightened_particle", () -> new SimpleParticleType(false)
    );
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLARG_FLAME = REGISTRY.register("flarg_flame", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CONFETTI = REGISTRY.register("confetti", () -> new SimpleParticleType(false));
}
