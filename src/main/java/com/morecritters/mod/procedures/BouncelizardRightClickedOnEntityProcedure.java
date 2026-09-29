package com.morecritters.mod.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;

public class BouncelizardRightClickedOnEntityProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (entity instanceof TamableAnimal _tamEnt
                && _tamEnt.isTame()
                && entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)) {
                if (entity.isShiftKeyDown()) {
                    entity.setShiftKeyDown(false);
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Bouncelizard is following"), true);
                    }
                } else if (!entity.isShiftKeyDown()) {
                    entity.setShiftKeyDown(true);
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("Bouncelizard is sitting"), true);
                    }
                }
            }
        }
    }
}
