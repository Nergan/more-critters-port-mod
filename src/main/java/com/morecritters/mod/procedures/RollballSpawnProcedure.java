package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class RollballSpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("idle", Mth.nextInt(RandomSource.create(), 60, 200));
            entity.getPersistentData().putDouble("jump", Mth.nextInt(RandomSource.create(), 60, 200));
            entity.getPersistentData().putDouble("roll", Mth.nextInt(RandomSource.create(), 60, 200));
        }
    }
}
