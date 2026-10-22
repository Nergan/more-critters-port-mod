package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public final class BlockVariants {
    private BlockVariants() {
    }

    public static int barnacle(BlockPos pos) {
        int index = Math.floorMod(mix(pos), 3);
        return index == 0 ? 0 : index == 1 ? 2 : 3;
    }

    public static int confetti(BlockPos pos) {
        return Math.floorMod(mix(pos), 3);
    }

    public static int tatteredFlag(LevelAccessor world, BlockPos pos) {
        boolean stacked = world.getBlockState(pos.below()).is(MoreCrittersModBlocks.TATTERED_FLAG.get());
        return (stacked ? 0 : 4) + Math.floorMod(mix(pos), 3);
    }

    private static int mix(BlockPos pos) {
        return pos.getX() * 734287 ^ pos.getY() * 912931 ^ pos.getZ() * 456791;
    }
}
