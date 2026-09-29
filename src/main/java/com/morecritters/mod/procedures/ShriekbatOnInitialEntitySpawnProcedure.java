package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class ShriekbatOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("echo", 100.0);
            entity.getPersistentData().putDouble("flap", Mth.nextInt(RandomSource.create(), 40, 60));
            entity.getPersistentData().putDouble("hang", Mth.nextInt(RandomSource.create(), 100, 200));
            entity.getPersistentData().putDouble("test", 100.0);
            entity.getPersistentData().putDouble("shriek", 100.0);
        }
    }
}
