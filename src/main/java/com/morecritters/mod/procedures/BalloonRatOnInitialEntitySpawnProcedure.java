package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class BalloonRatOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("heal", 1200.0);
            entity.getPersistentData().putDouble("attack", 100.0);
            entity.getPersistentData().putDouble("inflated", 0.0);
        }
    }
}
