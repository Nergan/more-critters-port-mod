package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class BrittlenessOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _livEnt0
                && _livEnt0.hasEffect(MoreCrittersModMobEffects.ASPHYXIATION)
                && entity instanceof LivingEntity _livEnt1
                && _livEnt1.hasEffect(MoreCrittersModMobEffects.HALLUCINAZIUM)
                && entity instanceof LivingEntity _livEnt2
                && _livEnt2.hasEffect(MoreCrittersModMobEffects.MUSCLE_ACHE)
                && entity instanceof LivingEntity _livEnt3
                && _livEnt3.hasEffect(MoreCrittersModMobEffects.STAGNATION)
                && entity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:get_all_poisons"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
        }
    }
}
