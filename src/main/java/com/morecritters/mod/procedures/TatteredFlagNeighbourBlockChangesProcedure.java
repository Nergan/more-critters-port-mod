package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TatteredFlagNeighbourBlockChangesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
        if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == MoreCrittersModBlocks.TATTERED_FLAG.get()) {
            if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1)
                    == 4
                || (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1)
                    == 5
                || (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7 ? blockstate.getValue(_getip7) : -1)
                    == 6
                || (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1)
                    == 7) {
                int _value = (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0);
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            }
        } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
                        ? blockstate.getValue(_getip13)
                        : -1
                )
                == 0
            || (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15 ? blockstate.getValue(_getip15) : -1)
                == 1
            || (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17 ? blockstate.getValue(_getip17) : -1)
                == 2
            || (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19 ? blockstate.getValue(_getip19) : -1)
                == 3) {
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
