package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BarnacleClusterBlockAddedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        rate = Mth.nextInt(RandomSource.create(), 1, 3);
        if (rate == 1.0) {
            int _value = 0;
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        } else if (rate == 2.0) {
            int _value = 2;
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        } else if (rate == 3.0) {
            int _value = 3;
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        }
    }
}
