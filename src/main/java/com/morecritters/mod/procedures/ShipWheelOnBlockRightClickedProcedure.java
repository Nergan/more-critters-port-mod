package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ShipWheelOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.isShiftKeyDown()) {
                if ((new Object() {
                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                    }
                }).getValue(world, BlockPos.containing(x, y, z), "level") > 0.0) {
                    if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x, y, z);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                            _blockEntity.getPersistentData().putDouble("level", (new Object() {
                                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                    return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                                }
                            }).getValue(world, BlockPos.containing(x, y, z), "level") - 1.0);
                        }

                        if (world instanceof Level _level) {
                            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                    }

                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = world.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp) {
                        world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.ship_wheel.spin")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.ship_wheel.spin")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    MoreCritters.queueServerWork(
                        1,
                        () -> {
                            int _value = 2;
                            BlockPos _posx = BlockPos.containing(x, y, z);
                            BlockState _bsx = world.getBlockState(_posx);
                            if (_bsx.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerPropx
                                && _integerPropx.getPossibleValues().contains(_value)) {
                                world.setBlock(_posx, _bsx.setValue(_integerPropx, _value), 3);
                            }
                        }
                    );
                }
            } else if ((new Object() {
                public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                    BlockEntity blockEntity = world.getBlockEntity(pos);
                    return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                }
            }).getValue(world, BlockPos.containing(x, y, z), "level") < 15.0) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("level", (new Object() {
                            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                            }
                        }).getValue(world, BlockPos.containing(x, y, z), "level") + 1.0);
                    }

                    if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.ship_wheel.spin")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.ship_wheel.spin")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, 0), 3);
                }

                MoreCritters.queueServerWork(
                    1,
                    () -> {
                        int _value = 1;
                        BlockPos _posx = BlockPos.containing(x, y, z);
                        BlockState _bsx = world.getBlockState(_posx);
                        if (_bsx.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerPropx
                            && _integerPropx.getPossibleValues().contains(_value)) {
                            world.setBlock(_posx, _bsx.setValue(_integerPropx, _value), 3);
                        }
                    }
                );
            }
        }
    }
}
