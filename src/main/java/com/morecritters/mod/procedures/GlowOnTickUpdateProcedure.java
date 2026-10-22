package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class GlowOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos pos = BlockPos.containing(x, y, z);
        if (world.getBlockState(pos).is(MoreCrittersModBlocks.GLOW.get())) {
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
    }
}
