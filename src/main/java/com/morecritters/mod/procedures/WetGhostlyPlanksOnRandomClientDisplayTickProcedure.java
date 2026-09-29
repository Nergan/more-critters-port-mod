package com.morecritters.mod.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class WetGhostlyPlanksOnRandomClientDisplayTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        rate = Mth.nextInt(RandomSource.create(), 1, 10);
        if (rate == 1.0) {
            world.addParticle(
                ParticleTypes.DRIPPING_WATER,
                x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.4, 0.4),
                y,
                z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.4, 0.4),
                0.0,
                0.0,
                0.0
            );
        }
    }
}
