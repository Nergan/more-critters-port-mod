package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class StincarpOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("zap", Mth.nextInt(RandomSource.create(), 100, 200));
            entity.getPersistentData().putDouble("zap_animation", 0.0);
            entity.getPersistentData().putDouble("dry", 200.0);
            entity.getPersistentData().putDouble("hurt", 20.0);
        }
    }
}
