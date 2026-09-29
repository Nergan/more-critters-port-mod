package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class SplinterWhileProjectileFlyingTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        world.addParticle(
            MoreCrittersModParticleTypes.RESIN.get(),
            x + Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
            y + Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
            z + Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
            0.0,
            0.0,
            0.0
        );
    }
}
