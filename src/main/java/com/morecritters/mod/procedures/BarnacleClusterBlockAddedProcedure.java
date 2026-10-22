package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BarnacleClusterBlockAddedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        apply(world, BlockPos.containing(x, y, z), BlockVariants.barnacle(BlockPos.containing(x, y, z)));
    }

    private static void apply(LevelAccessor world, BlockPos pos, int value) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty property
            && property.getPossibleValues().contains(value)
            && state.getValue(property) != value) {
            world.setBlock(pos, state.setValue(property, value), 3);
        }
    }
}
