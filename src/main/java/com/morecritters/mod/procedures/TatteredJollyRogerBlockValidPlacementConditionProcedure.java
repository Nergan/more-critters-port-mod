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

public class TatteredJollyRogerBlockValidPlacementConditionProcedure {
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
                != Direction.NORTH
            || !world.getBlockState(BlockPos.containing(x, y, z + 1.0)).isFaceSturdy(world, BlockPos.containing(x, y, z + 1.0), Direction.NORTH)
                && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != MoreCrittersModBlocks.FISH_BONE_POLE.get()
                && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != MoreCrittersModBlocks.ECTOMETAL_SCREW.get()) {
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
                    != Direction.SOUTH
                || !world.getBlockState(BlockPos.containing(x, y, z - 1.0)).isFaceSturdy(world, BlockPos.containing(x, y, z - 1.0), Direction.SOUTH)
                    && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != MoreCrittersModBlocks.FISH_BONE_POLE.get()
                    && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != MoreCrittersModBlocks.ECTOMETAL_SCREW.get()) {
                return (new Object() {
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
                            != Direction.EAST
                        || !world.getBlockState(BlockPos.containing(x - 1.0, y, z)).isFaceSturdy(world, BlockPos.containing(x - 1.0, y, z), Direction.EAST)
                            && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != MoreCrittersModBlocks.FISH_BONE_POLE.get()
                            && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != MoreCrittersModBlocks.ECTOMETAL_SCREW.get()
                    ? (new Object() {
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
                        && (
                            world.getBlockState(BlockPos.containing(x + 1.0, y, z)).isFaceSturdy(world, BlockPos.containing(x + 1.0, y, z), Direction.WEST)
                                || world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == MoreCrittersModBlocks.FISH_BONE_POLE.get()
                                || world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() == MoreCrittersModBlocks.ECTOMETAL_SCREW.get()
                        )
                    : true;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}
