package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class HallucinaziumEffectStartedappliedProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("jumpscare", 80.0);
        }
    }
}
