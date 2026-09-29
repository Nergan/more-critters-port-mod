package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.ArmossilloEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ArmossilloOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof ArmossilloEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(
                        ArmossilloEntity.DATA_cooldown,
                        (entity instanceof ArmossilloEntity _datEntI ? _datEntI.getEntityData().get(ArmossilloEntity.DATA_cooldown) : 0) - 1
                    );
            }

            if (entity instanceof ArmossilloEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(
                        ArmossilloEntity.DATA_sneeze,
                        (entity instanceof ArmossilloEntity _datEntI ? _datEntI.getEntityData().get(ArmossilloEntity.DATA_sneeze) : 0) - 1
                    );
            }

            if ((entity instanceof ArmossilloEntity _datEntI ? _datEntI.getEntityData().get(ArmossilloEntity.DATA_cooldown) : 0) == 0) {
                if (entity instanceof ArmossilloEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(ArmossilloEntity.DATA_cooldown, 400);
                }

                if (!(entity instanceof ArmossilloEntity _datEntL6 && _datEntL6.getEntityData().get(ArmossilloEntity.DATA_sitting))) {
                    if (!(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6)) {
                        if (entity instanceof ArmossilloEntity _datEntSetL) {
                            _datEntSetL.getEntityData().set(ArmossilloEntity.DATA_sitting, true);
                        }

                        MoreCritters.queueServerWork(
                            7,
                            () -> {
                                if (!world.isClientSide() && world instanceof Level _levelx) {
                                    if (!_levelx.isClientSide()) {
                                        _levelx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.sit")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.sit")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }
                            }
                        );
                        MoreCritters.queueServerWork(
                            15,
                            () -> {
                                if (world instanceof Level _levelxx) {
                                    BlockPos _bp = BlockPos.containing(x, y - 1.0, z);
                                    if ((
                                            BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _levelxx, _bp)
                                                || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _levelxx, _bp, null)
                                        )
                                        && !_levelxx.isClientSide()) {
                                        _levelxx.levelEvent(2005, _bp, 0);
                                    }
                                }

                                if (world instanceof Level _levelx) {
                                    BlockPos _bp = BlockPos.containing(x, y - -0.1, z);
                                    if ((
                                            BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _levelx, _bp)
                                                || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _levelx, _bp, null)
                                        )
                                        && !_levelx.isClientSide()) {
                                        _levelx.levelEvent(2005, _bp, 0);
                                    }
                                }

                                MoreCritters.queueServerWork(
                                    1,
                                    () -> {
                                        if (world instanceof Level _levelxxx) {
                                            BlockPos _bpx = BlockPos.containing(x, y - -0.1, z);
                                            if ((
                                                    BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _levelxxx, _bpx)
                                                        || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _levelxxx, _bpx, null)
                                                )
                                                && !_levelxxx.isClientSide()) {
                                                _levelxxx.levelEvent(2005, _bpx, 0);
                                            }
                                        }

                                        MoreCritters.queueServerWork(
                                            1,
                                            () -> {
                                                if (world instanceof Level _levelxxxx) {
                                                    BlockPos _bpxx = BlockPos.containing(x, y - -0.1, z);
                                                    if ((
                                                            BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _levelxxxx, _bpxx)
                                                                || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _levelxxxx, _bpxx, null)
                                                        )
                                                        && !_levelxxxx.isClientSide()) {
                                                        _levelxxxx.levelEvent(2005, _bpxx, 0);
                                                    }
                                                }
                                            }
                                        );
                                    }
                                );
                            }
                        );
                        if ((entity instanceof ArmossilloEntity _datEntI ? _datEntI.getEntityData().get(ArmossilloEntity.DATA_sneeze) : 0) <= 0
                            && entity instanceof ArmossilloEntity) {
                            ((ArmossilloEntity)entity).setAnimation("sit_down");
                        }
                    }
                } else if (entity instanceof ArmossilloEntity _datEntL21 && _datEntL21.getEntityData().get(ArmossilloEntity.DATA_sitting)) {
                    if (entity instanceof ArmossilloEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(ArmossilloEntity.DATA_sitting, false);
                    }

                    MoreCritters.queueServerWork(
                        5,
                        () -> {
                            if (!world.isClientSide() && world instanceof Level _levelx) {
                                if (!_levelx.isClientSide()) {
                                    _levelx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.rise")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.rise")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        }
                    );
                    if (entity instanceof ArmossilloEntity) {
                        ((ArmossilloEntity)entity).setAnimation("sit_up");
                    }
                }
            }

            if (entity instanceof ArmossilloEntity _datEntL27
                && _datEntL27.getEntityData().get(ArmossilloEntity.DATA_sitting)
                && (entity instanceof ArmossilloEntity _datEntI ? _datEntI.getEntityData().get(ArmossilloEntity.DATA_sneeze) : 0) <= 0
                && entity instanceof ArmossilloEntity) {
                ((ArmossilloEntity)entity).setAnimation("sit_down");
            }

            if (entity instanceof LivingEntity _livEnt30 && _livEnt30.isBaby()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                world.setBlock(BlockPos.containing(x, y, z), MoreCrittersModBlocks.MOSS_CLUMP.get().defaultBlockState(), 3);
            }

            if ((entity instanceof ArmossilloEntity _datEntI ? _datEntI.getEntityData().get(ArmossilloEntity.DATA_sneeze) : 0) == 0) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.sneeze")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.sneeze")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 3.0, 6.0); index0++) {
                    if (world instanceof ServerLevel _level) {
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.GLOWING_OOZE.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }
                }

                entity.push(-1.0 * entity.getLookAngle().x, -1.0 * entity.getLookAngle().y, -1.0 * entity.getLookAngle().z);
            }
        }
    }
}
