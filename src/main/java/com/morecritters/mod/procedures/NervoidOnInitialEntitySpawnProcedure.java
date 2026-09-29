package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class NervoidOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("attack", 100.0);
        }
    }
}
