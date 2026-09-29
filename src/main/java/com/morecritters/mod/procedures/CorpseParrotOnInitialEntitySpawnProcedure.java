package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class CorpseParrotOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("timer", Mth.nextInt(RandomSource.create(), 100, 300));
            entity.getPersistentData().putDouble("speech", Mth.nextDouble(RandomSource.create(), 100.0, 400.0));
            entity.getPersistentData().putDouble("throw", 100.0);
        }
    }
}
