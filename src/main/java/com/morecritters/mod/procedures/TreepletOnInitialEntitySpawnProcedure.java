package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class TreepletOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("spin", Mth.nextInt(RandomSource.create(), 200, 500));
            entity.getPersistentData().putDouble("shoot", 25.0);
        }
    }
}
