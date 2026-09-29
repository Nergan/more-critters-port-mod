package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class BlubberValidPlacementProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
        if (!(blockstate.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1))) {
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
                    == Direction.NORTH
                && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).isFaceSturdy(world, BlockPos.containing(x, y, z + 1.0), Direction.NORTH)) {
                return true;
            }

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
                    == Direction.SOUTH
                && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).isFaceSturdy(world, BlockPos.containing(x, y, z - 1.0), Direction.SOUTH)) {
                return true;
            }

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
                    == Direction.EAST
                && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).isFaceSturdy(world, BlockPos.containing(x - 1.0, y, z), Direction.EAST)) {
                return true;
            }

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
                    == Direction.WEST
                && world.getBlockState(BlockPos.containing(x + 1.0, y, z)).isFaceSturdy(world, BlockPos.containing(x + 1.0, y, z), Direction.WEST)) {
                return true;
            }

            if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep19
                        ? blockstate.getValue(_getep19).toString()
                        : "")
                    .equals("CEILING")
                && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1.0, z), Direction.DOWN)) {
                return true;
            }

            if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep22
                        ? blockstate.getValue(_getep22).toString()
                        : "")
                    .equals("FLOOR")
                && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1.0, z), Direction.UP)) {
                return true;
            }
        }

        return false;
    }
}
