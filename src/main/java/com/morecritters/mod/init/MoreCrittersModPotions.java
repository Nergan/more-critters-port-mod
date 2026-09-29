package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

public class MoreCrittersModPotions {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, "more_critters");
    public static final DeferredHolder<Potion, Potion> FROSTBITE_POTION = REGISTRY.register(
        "frostbite_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.FROSTBITE, 500, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> SHRIEK_RESISTANCE_POTION = REGISTRY.register(
        "shriek_resistance_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.SHRIEK_RESISTANCE, 3600, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> STAGNATION_POTION = REGISTRY.register(
        "stagnation_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.STAGNATION, 1800, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> MUSCLE_ACHE_POTION = REGISTRY.register(
        "muscle_ache_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.MUSCLE_ACHE, 1200, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> BRITTLENESS_POTION = REGISTRY.register(
        "brittleness_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.BRITTLENESS, 2400, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> HALLUCINAZIUM_POTION = REGISTRY.register(
        "hallucinazium_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.HALLUCINAZIUM, 600, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> ASPHYXIATION_POTION = REGISTRY.register(
        "asphyxiation_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.ASPHYXIATION, 400, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> ENDS_BLESSING_POTION = REGISTRY.register(
        "ends_blessing_potion", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.ENDS_BLESSING, 2400, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> BRAIN_SCENT = REGISTRY.register(
        "brain_scent", () -> new Potion(new MobEffectInstance(MoreCrittersModMobEffects.BRAIN_SCENTED, 3600, 0, false, true))
    );
    public static final DeferredHolder<Potion, Potion> HASTE_POTION = REGISTRY.register(
        "haste_potion", () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0, false, true))
    );
}
