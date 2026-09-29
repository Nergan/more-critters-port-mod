package com.morecritters.mod.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TamedParrotSpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("timer", Mth.nextInt(RandomSource.create(), 100, 300));
            entity.getPersistentData().putDouble("throw", 100.0);
            if (world instanceof ServerLevel _level) {
                _level.sendParticles(ParticleTypes.HEART, x, y + 1.0, z, 5, 0.5, 0.5, 0.5, 1.0);
            }
        }
    }
}
