package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class ThunderballProjectileWhileProjectileFlyingTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(MoreCrittersModParticleTypes.ZAP_SPARK.get(), x, y, z, 5, 0.2, 0.2, 0.2, 0.02);
        }
    }
}
