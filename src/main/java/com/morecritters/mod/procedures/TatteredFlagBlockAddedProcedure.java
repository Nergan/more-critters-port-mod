package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TatteredFlagBlockAddedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos pos = BlockPos.containing(x, y, z);
        int value = BlockVariants.tatteredFlag(world, pos);
        BlockState state = world.getBlockState(pos);
        if (state.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty property
            && property.getPossibleValues().contains(value)
            && state.getValue(property) != value) {
            world.setBlock(pos, state.setValue(property, value), 3);
        }
    }
}
