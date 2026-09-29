package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class BunbugBurgerPlayerFinishesUsingItemProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:eat_bunbug_burger"));
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
