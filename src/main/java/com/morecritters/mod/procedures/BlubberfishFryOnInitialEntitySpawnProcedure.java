package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class BlubberfishFryOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("air", 200.0);
            entity.getPersistentData().putDouble("grow", 24000.0);
        }
    }
}
