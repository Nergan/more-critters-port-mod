package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class GravediggerOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("growl", Mth.nextDouble(RandomSource.create(), 100.0, 200.0));
            entity.getPersistentData().putDouble("wait", -3.0);
        }
    }
}
