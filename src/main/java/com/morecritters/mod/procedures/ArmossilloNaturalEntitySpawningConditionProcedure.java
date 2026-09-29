package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class ArmossilloNaturalEntitySpawningConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.WATER && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z));
    }
}
