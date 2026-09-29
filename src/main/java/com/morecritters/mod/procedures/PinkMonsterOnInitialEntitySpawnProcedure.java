package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class PinkMonsterOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            double timer = 0.0;
            entity.getPersistentData().putDouble("timer", 40.0);
        }
    }
}
