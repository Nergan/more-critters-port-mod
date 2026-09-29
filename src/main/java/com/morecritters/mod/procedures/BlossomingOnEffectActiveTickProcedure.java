package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class BlossomingOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        rate = Mth.nextInt(RandomSource.create(), 1, 10);
        if (rate == 1.0 && world instanceof ServerLevel _level) {
            _level.sendParticles(
                MoreCrittersModParticleTypes.BLOSSOM_PARTICLE.get(), x, y + 1.0, z, (int)Mth.nextDouble(RandomSource.create(), 2.0, 5.0), 0.4, 0.4, 0.4, 0.01
            );
        }
    }
}
