package com.morecritters.mod.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class WanderingCollectorEntityIsHurtProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y + 1.0, z, 5, 0.2, 0.2, 0.2, 1.0);
        }
    }
}
