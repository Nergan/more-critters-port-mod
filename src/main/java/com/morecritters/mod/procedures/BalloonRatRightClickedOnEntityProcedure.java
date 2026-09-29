package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.BalloonRatEntity;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BalloonRatRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == sourceentity) {
                if (sourceentity.isShiftKeyDown()) {
                    if ((entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 1) {
                        if (entity instanceof BalloonRatEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(BalloonRatEntity.DATA_variant, 2);
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(MoreCrittersModParticleTypes.SOLDIER_STRIPE.get(), x, y, z, 6, 0.5, 0.0, 0.5, 0.0);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.transform")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.transform")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2) {
                        if (entity instanceof BalloonRatEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(BalloonRatEntity.DATA_variant, 1);
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(MoreCrittersModParticleTypes.MEDIC_STRIPE.get(), x, y, z, 6, 0.5, 0.0, 0.5, 0.0);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.transform")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.transform")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    }
                } else if (entity instanceof BalloonRatEntity _datEntL12 && _datEntL12.getEntityData().get(BalloonRatEntity.DATA_sit)) {
                    if (entity instanceof BalloonRatEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_sit, false);
                    }

                    if (entity instanceof BalloonRatEntity) {
                        ((BalloonRatEntity)entity).setAnimation("sit_rise");
                    }
                } else if (entity instanceof BalloonRatEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_sit, true);
                }
            }
        }
    }
}
