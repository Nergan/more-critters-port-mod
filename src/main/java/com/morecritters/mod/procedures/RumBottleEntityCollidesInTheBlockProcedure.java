package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;

public class RumBottleEntityCollidesInTheBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6 && entity.onGround()) {
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
                    entity.setDeltaMovement(new Vec3(0.0, 0.3, 1.0));
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
                    entity.setDeltaMovement(new Vec3(1.0, 0.3, 0.0));
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
                    entity.setDeltaMovement(new Vec3(0.0, 0.3, -1.0));
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
                    entity.setDeltaMovement(new Vec3(-1.0, 0.3, 0.0));
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 100);
                if (entity instanceof Player) {
                    if (rate == 1.0) {
                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.big_slip")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.big_slip")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.slip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.slip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                } else if (rate == 1.0) {
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.big_slip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.big_slip")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                } else if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.slip")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.rum.slip")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }
        }
    }
}
