package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class ShimmeringChrysalisBlockValidPlacementConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.CHORUS_PLANT
            || world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == Blocks.CHORUS_FLOWER
            || world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.CHORUS_PLANT
            || world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() == Blocks.CHORUS_FLOWER
            || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.CHORUS_PLANT
            || world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() == Blocks.CHORUS_FLOWER
            || world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.CHORUS_PLANT
            || world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() == Blocks.CHORUS_FLOWER;
    }
}
