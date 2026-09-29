package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SlablizardEggOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                == MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().asItem()) {
                if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                    (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if ((
                        blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9
                            ? blockstate.getValue(_getip9)
                            : -1
                    )
                    == 0) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    int _value = 2;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = world.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                    }
                } else if ((
                        blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
                            ? blockstate.getValue(_getip13)
                            : -1
                    )
                    == 2) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    int _value = 3;
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    BlockState _bs = world.getBlockState(_pos);
                    if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                        && _integerProp.getPossibleValues().contains(_value)) {
                        world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                    }
                } else if ((
                        blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17
                            ? blockstate.getValue(_getip17)
                            : -1
                    )
                    == 3) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    int _value = 4;
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
}
