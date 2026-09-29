package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class SlablizardOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("snore", Mth.nextDouble(RandomSource.create(), 60.0, 120.0));
            entity.getPersistentData().putDouble("idle", Mth.nextDouble(RandomSource.create(), 100.0, 300.0));
        }
    }
}
