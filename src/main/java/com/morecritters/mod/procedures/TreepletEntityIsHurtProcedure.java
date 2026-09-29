package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class TreepletEntityIsHurtProcedure {
    public static void execute(Entity sourceentity) {
        if (sourceentity != null) {
            if (sourceentity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:encounter_treeplet"));
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
