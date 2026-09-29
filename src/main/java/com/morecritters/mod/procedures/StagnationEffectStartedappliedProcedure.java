package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BalloonRatEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class StagnationEffectStartedappliedProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!(entity instanceof BalloonRatEntity)) {
                entity.getPersistentData().putDouble("health", entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0);
            }
        }
    }
}
