package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class SlashEffectOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("timer", 30.0);
            entity.getPersistentData().putDouble("size", 0.0);
        }
    }
}
