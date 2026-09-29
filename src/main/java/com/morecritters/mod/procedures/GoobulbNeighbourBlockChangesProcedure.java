package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GoobulbNeighbourBlockChangesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == MoreCrittersModBlocks.GOOBULB.get()
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == MoreCrittersModBlocks.GOOBULB.get()) {
            int _value = 1;
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        } else if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != MoreCrittersModBlocks.GOOBULB.get()
            && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == MoreCrittersModBlocks.GOOBULB.get()) {
            int _value = 0;
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        } else if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() != MoreCrittersModBlocks.GOOBULB.get()
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == MoreCrittersModBlocks.GOOBULB.get()) {
            int _value = 2;
            BlockPos _pos = BlockPos.containing(x, y, z);
            BlockState _bs = world.getBlockState(_pos);
            if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                && _integerProp.getPossibleValues().contains(_value)) {
                world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
            }
        } else {
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
