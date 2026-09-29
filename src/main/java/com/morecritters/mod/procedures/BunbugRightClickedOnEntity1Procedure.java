package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.BunbugEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
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

public class BunbugRightClickedOnEntity1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 0) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
                    if (entity instanceof BunbugEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(BunbugEntity.DATA_icing, 1);
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.cream")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.cream")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.COCOA_BEANS) {
                    if (entity instanceof BunbugEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(BunbugEntity.DATA_icing, 2);
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.cream")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.cream")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) != 0
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 0) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.SPRINKLES.get()) {
                    if (entity instanceof BunbugEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(BunbugEntity.DATA_sprinkles, 1);
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.sprinkle")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.sprinkle")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) != 0
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) != 0
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 0) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SWEET_BERRIES) {
                    if (entity instanceof BunbugEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(BunbugEntity.DATA_berries, 1);
                    }

                    if (sourceentity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:fully_decorate_bunbug"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria()) {
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.berry")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.berry")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }

                if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLOW_BERRIES) {
                    if (entity instanceof BunbugEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(BunbugEntity.DATA_berries, 2);
                    }

                    if (sourceentity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:fully_decorate_bunbug"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria()) {
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.berry")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.berry")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }

                if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.BOUNCEBERRY.get()) {
                    if (entity instanceof BunbugEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(BunbugEntity.DATA_berries, 3);
                    }

                    if (sourceentity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:fully_decorate_bunbug"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria()) {
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.berry")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.berry")),
                                SoundSource.NEUTRAL,
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
}
