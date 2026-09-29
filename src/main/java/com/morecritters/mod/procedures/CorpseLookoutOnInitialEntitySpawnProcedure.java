package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class CorpseLookoutOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("speech", Mth.nextDouble(RandomSource.create(), 200.0, 600.0));
            entity.getPersistentData().putDouble("attack", 20.0);
        }
    }
}
