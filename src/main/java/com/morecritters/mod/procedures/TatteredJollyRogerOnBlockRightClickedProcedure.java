package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TatteredJollyRogerOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity) {
                _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if ((blockstate.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _getip2 ? blockstate.getValue(_getip2) : -1)
                == 0) {
                int _value = 1;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1
                )
                == 1) {
                int _value = 2;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _getip8 ? blockstate.getValue(_getip8) : -1
                )
                == 2) {
                int _value = 0;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            }
        }
    }
}
