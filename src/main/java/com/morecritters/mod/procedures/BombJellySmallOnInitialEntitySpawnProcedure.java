package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class BombJellySmallOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("animation", 3.0);
            entity.getPersistentData().putDouble("air", 200.0);
        }
    }
}
