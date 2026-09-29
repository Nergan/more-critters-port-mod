package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class EvolutionerOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("attack", 160.0);
        }
    }
}
