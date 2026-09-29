package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class RotZombieOnEntityTickUpdateProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!(entity.getPersistentData().getDouble("size") >= 1.0)) {
                entity.getPersistentData().putDouble("size", entity.getPersistentData().getDouble("size") + 0.1);
            }
        }
    }
}
