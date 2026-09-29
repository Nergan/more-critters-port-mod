package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class RumBottleBlockValidPlacementConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return world.getBlockState(BlockPos.containing(x, y - 1.0, z)).canOcclude();
    }
}
