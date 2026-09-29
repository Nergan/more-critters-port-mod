package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class RamchuOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            entity.getPersistentData().putDouble("air", 200.0);
            entity.getPersistentData().putDouble("ram", 100.0);
        }
    }
}
