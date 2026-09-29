package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class BabyBunbugOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("age", 12000.0);
        }
    }
}
