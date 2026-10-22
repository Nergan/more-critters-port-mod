package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ShimmeringChrysalisBlockValidPlacementConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z, Direction facing) {
        Block support = world.getBlockState(BlockPos.containing(x, y, z).relative(facing.getOpposite())).getBlock();
        return support == Blocks.CHORUS_PLANT || support == Blocks.CHORUS_FLOWER;
    }
}
