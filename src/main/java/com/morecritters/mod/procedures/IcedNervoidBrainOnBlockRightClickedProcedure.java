package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class IcedNervoidBrainOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.TORCH) {
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ICED_NERVOID_BRAIN.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(MoreCrittersModParticleTypes.ICE_OFF.get(), x + 0.5, y + 0.5, z + 0.5, 3, 0.3, 0.3, 0.3, 0.01);
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.candle.extinguish")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.candle.extinguish")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.NERVOID_BRAIN.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var18) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (entity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:ice_off_brain"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria()) {
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }

                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ICED_DECOMPOSING_NERVOID_BRAIN.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(MoreCrittersModParticleTypes.ICE_OFF.get(), x + 0.5, y + 0.5, z + 0.5, 3, 0.3, 0.3, 0.3, 0.01);
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.candle.extinguish")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.candle.extinguish")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.DECOMPOSING_NERVOID_BRAIN.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var17) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (entity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:ice_off_brain"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria()) {
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }

                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ICED_ROTTEN_NERVOID_BRAIN.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(MoreCrittersModParticleTypes.ICE_OFF.get(), x + 0.5, y + 0.5, z + 0.5, 3, 0.3, 0.3, 0.3, 0.01);
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.candle.extinguish")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.candle.extinguish")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var16) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (entity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:ice_off_brain"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria()) {
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }
            }
        }
    }
}
