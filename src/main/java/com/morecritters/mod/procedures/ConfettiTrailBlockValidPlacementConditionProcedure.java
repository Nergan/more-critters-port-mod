package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class ConfettiTrailBlockValidPlacementConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != Blocks.AIR
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != MoreCrittersModBlocks.CONFETTI_TRAIL.get();
    }
}
