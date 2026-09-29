package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class BarnacleClusterBlockValidPlacementConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
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
                == Direction.SOUTH
            && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).isFaceSturdy(world, BlockPos.containing(x, y, z - 1.0), Direction.SOUTH)) {
            return true;
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
                == Direction.EAST
            && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).isFaceSturdy(world, BlockPos.containing(x - 1.0, y, z), Direction.EAST)) {
            return true;
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
                == Direction.WEST
            && world.getBlockState(BlockPos.containing(x + 1.0, y, z)).isFaceSturdy(world, BlockPos.containing(x + 1.0, y, z), Direction.WEST)) {
            return true;
        } else {
            return (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep17
                            ? blockstate.getValue(_getep17).toString()
                            : "")
                        .equals("CEILING")
                    && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1.0, z), Direction.DOWN)
                ? true
                : (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep20
                            ? blockstate.getValue(_getep20).toString()
                            : "")
                        .equals("FLOOR")
                    && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1.0, z), Direction.UP);
        }
    }
}
