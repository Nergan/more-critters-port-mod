package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TatteredFlagBlockAddedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == MoreCrittersModBlocks.TATTERED_FLAG.get()) {
            int _value = (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0);
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        } else {
            int _value = (int)Mth.nextDouble(RandomSource.create(), 4.0, 7.0);
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        }
    }
}
