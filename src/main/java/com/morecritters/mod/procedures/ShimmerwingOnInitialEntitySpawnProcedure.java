package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class ShimmerwingOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("timer", Mth.nextInt(RandomSource.create(), 100, 300));
            entity.getPersistentData().putDouble("eat", 5.0);
        }
    }
}
