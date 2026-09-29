package com.morecritters.mod.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class FlyingPearlProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof Level _level && !_level.isClientSide()) {
            _level.explode(null, x, y, z, 3.0F, ExplosionInteraction.NONE);
        }
    }
}
