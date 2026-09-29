package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TatteredJollyRogerNeighbourBlockChangesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
        if ((new Object() {
                    public Direction getDirection(BlockState _bs) {
                        if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                            return _bs.getValue(_dp);
                        } else {
                            return _bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                                    && _ep.getPossibleValues().toArray()[0] instanceof Axis
                                ? Direction.fromAxisAndDirection((Axis) _bs.getValue(_ep), AxisDirection.POSITIVE)
                                : Direction.NORTH;
                        }
                    }
                })
                .getDirection(blockstate)
            == Direction.NORTH) {
            if (world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != MoreCrittersModBlocks.FISH_BONE_POLE.get()
                && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != MoreCrittersModBlocks.ECTOMETAL_SCREW.get()) {
                int _value = 0;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else {
                int _value = 1;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            }
        } else if ((new Object() {
                    public Direction getDirection(BlockState _bs) {
                        if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                            return _bs.getValue(_dp);
                        } else {
                            return _bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                                    && _ep.getPossibleValues().toArray()[0] instanceof Axis
                                ? Direction.fromAxisAndDirection((Axis) _bs.getValue(_ep), AxisDirection.POSITIVE)
                                : Direction.NORTH;
                        }
                    }
                })
                .getDirection(blockstate)
            == Direction.SOUTH) {
            if (world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != MoreCrittersModBlocks.FISH_BONE_POLE.get()
                && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != MoreCrittersModBlocks.ECTOMETAL_SCREW.get()) {
                int _value = 0;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else {
                int _value = 1;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            }
        } else if ((new Object() {
                    public Direction getDirection(BlockState _bs) {
                        if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                            return _bs.getValue(_dp);
                        } else {
                            return _bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                                    && _ep.getPossibleValues().toArray()[0] instanceof Axis
                                ? Direction.fromAxisAndDirection((Axis) _bs.getValue(_ep), AxisDirection.POSITIVE)
                                : Direction.NORTH;
                        }
                    }
                })
                .getDirection(blockstate)
            == Direction.EAST) {
            if (world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != MoreCrittersModBlocks.FISH_BONE_POLE.get()
                && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != MoreCrittersModBlocks.ECTOMETAL_SCREW.get()) {
                int _value = 0;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else {
                int _value = 1;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            }
        } else if ((new Object() {
                    public Direction getDirection(BlockState _bs) {
                        if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof DirectionProperty _dp) {
                            return _bs.getValue(_dp);
                        } else {
                            return _bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ep
                                    && _ep.getPossibleValues().toArray()[0] instanceof Axis
                                ? Direction.fromAxisAndDirection((Axis) _bs.getValue(_ep), AxisDirection.POSITIVE)
                                : Direction.NORTH;
                        }
                    }
                })
                .getDirection(blockstate)
            == Direction.WEST) {
            if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != MoreCrittersModBlocks.FISH_BONE_POLE.get()
                && world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != MoreCrittersModBlocks.ECTOMETAL_SCREW.get()) {
                int _value = 0;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else {
                int _value = 1;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            }
        }
    }
}
