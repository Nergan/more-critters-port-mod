package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class BlubberfishOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("air", 200.0);
        }
    }
}
