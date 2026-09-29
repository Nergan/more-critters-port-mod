package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.StincarpEntity;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class StincarpOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double sound = 0.0;
            entity.getPersistentData().putDouble("zap", entity.getPersistentData().getDouble("zap") - 1.0);
            entity.getPersistentData().putDouble("zap_animation", entity.getPersistentData().getDouble("zap_animation") - 1.0);
            entity.getPersistentData().putDouble("hurt", entity.getPersistentData().getDouble("hurt") - 1.0);
            if (entity.isInWaterOrBubble()) {
                entity.getPersistentData().putDouble("dry", 200.0);
            } else if (!entity.isInWaterOrBubble()) {
                entity.getPersistentData().putDouble("dry", entity.getPersistentData().getDouble("dry") - 1.0);
            }

            if (entity.getPersistentData().getDouble("zap") == 1.0) {
                entity.getPersistentData().putDouble("zap", Mth.nextInt(RandomSource.create(), 100, 200));
                if (entity instanceof StincarpEntity) {
                    ((StincarpEntity)entity).setAnimation("shock");
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 30, false, false));
                }

                entity.getPersistentData().putDouble("zap_animation", 10.0);
            }

            if (entity.getPersistentData().getDouble("zap_animation") <= 0.0) {
                if (!(entity instanceof StincarpEntity animatable ? animatable.getTexture() : "null").equals("stincarp")
                    && !(entity instanceof StincarpEntity animatable ? animatable.getTexture() : "null").equals("stincarp_skeleton2")) {
                    if ((entity instanceof StincarpEntity animatable ? animatable.getTexture() : "null").equals("stincarp_loop1")) {
                        MoreCritters.queueServerWork(3, () -> {
                            if (entity instanceof StincarpEntity animatablex) {
                                animatablex.setTexture("stincarp_loop2");
                            }
                        });
                    } else if ((entity instanceof StincarpEntity animatable ? animatable.getTexture() : "null").equals("stincarp_loop2")) {
                        MoreCritters.queueServerWork(3, () -> {
                            if (entity instanceof StincarpEntity animatablex) {
                                animatablex.setTexture("stincarp_loop3");
                            }
                        });
                    } else if ((entity instanceof StincarpEntity animatable ? animatable.getTexture() : "null").equals("stincarp_loop3")) {
                        MoreCritters.queueServerWork(3, () -> {
                            if (entity instanceof StincarpEntity animatablex) {
                                animatablex.setTexture("stincarp_loop4");
                            }
                        });
                    } else if ((entity instanceof StincarpEntity animatable ? animatable.getTexture() : "null").equals("stincarp_loop4")) {
                        MoreCritters.queueServerWork(3, () -> {
                            if (entity instanceof StincarpEntity animatablex) {
                                animatablex.setTexture("stincarp_loop5");
                            }
                        });
                    } else if ((entity instanceof StincarpEntity animatable ? animatable.getTexture() : "null").equals("stincarp_loop5")) {
                        MoreCritters.queueServerWork(3, () -> {
                            if (entity instanceof StincarpEntity animatablex) {
                                animatablex.setTexture("stincarp_loop1");
                            }
                        });
                    }
                } else if (entity instanceof StincarpEntity animatable) {
                    animatable.setTexture("stincarp_loop1");
                }
            } else if (entity.getPersistentData().getDouble("zap_animation") != 10.0
                && entity.getPersistentData().getDouble("zap_animation") != 8.0
                && entity.getPersistentData().getDouble("zap_animation") != 6.0
                && entity.getPersistentData().getDouble("zap_animation") != 4.0
                && entity.getPersistentData().getDouble("zap_animation") != 2.0) {
                if (entity.getPersistentData().getDouble("zap_animation") == 9.0
                    || entity.getPersistentData().getDouble("zap_animation") == 7.0
                    || entity.getPersistentData().getDouble("zap_animation") == 5.0
                    || entity.getPersistentData().getDouble("zap_animation") == 3.0
                    || entity.getPersistentData().getDouble("zap_animation") == 1.0) {
                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(MoreCrittersModParticleTypes.ZAP.get(), x, y, z, 2, 1.0, 1.0, 1.0, 0.0);
                    }

                    if (entity instanceof StincarpEntity animatable) {
                        animatable.setTexture("stincarp_skeleton2");
                    }
                }
            } else {
                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(MoreCrittersModParticleTypes.ZAP.get(), x, y, z, 2, 1.0, 1.0, 1.0, 0.0);
                }

                if (entity instanceof StincarpEntity animatable) {
                    animatable.setTexture("stincarp_skeleton1");
                }
            }

            if (entity.getPersistentData().getDouble("dry") <= -1.0) {
                entity.getPersistentData().putDouble("dry", 20.0);
                entity.hurt(
                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)),
                    (float)Mth.nextDouble(RandomSource.create(), 1.0, 2.0)
                );
            }
        }
    }
}
