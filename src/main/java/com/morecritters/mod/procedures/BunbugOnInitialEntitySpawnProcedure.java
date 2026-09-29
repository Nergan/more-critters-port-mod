package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class BunbugOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            boolean bred = false;
            entity.getPersistentData().putDouble("shed", Mth.nextDouble(RandomSource.create(), 10000.0, 15000.0));
        }
    }
}
