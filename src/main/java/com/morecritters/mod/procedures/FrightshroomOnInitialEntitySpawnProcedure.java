package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class FrightshroomOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("attack", Mth.nextInt(RandomSource.create(), 100, 150));
        }
    }
}
