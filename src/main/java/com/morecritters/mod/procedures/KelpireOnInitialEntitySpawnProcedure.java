package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class KelpireOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("down", Mth.nextInt(RandomSource.create(), 60, 200));
            entity.getPersistentData().putDouble("air", 400.0);
        }
    }
}
