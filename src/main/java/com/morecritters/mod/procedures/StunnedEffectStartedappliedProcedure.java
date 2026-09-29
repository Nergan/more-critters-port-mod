package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class StunnedEffectStartedappliedProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("timer", 40.0);
        }
    }
}
