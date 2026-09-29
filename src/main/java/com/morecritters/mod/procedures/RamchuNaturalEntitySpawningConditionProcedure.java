package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class RamchuNaturalEntitySpawningConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z));
    }
}
