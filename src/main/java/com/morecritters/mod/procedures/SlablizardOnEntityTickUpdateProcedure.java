package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.BouncelizardEntity;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SlablizardOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double rate2 = 0.0;
            double snorerate = 0.0;
            if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby()) {
                entity.getPersistentData().putDouble("size", 0.3);
                entity.getPersistentData().putDouble("hitboxsize", 0.6);
                if (!(entity instanceof BouncelizardEntity _datEntL3 && _datEntL3.getEntityData().get(BouncelizardEntity.DATA_fromegg))) {
                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    rate = Mth.nextInt(RandomSource.create(), 1, 4);
                    if (rate == 1.0) {
                        world.setBlock(BlockPos.containing(x, y, z), MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState(), 3);
                        int _value = 0;
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        BlockState _bs = world.getBlockState(_pos);
                        if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                            && _integerProp.getPossibleValues().contains(_value)) {
                            world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                        }
                    } else if (rate == 2.0) {
                        world.setBlock(BlockPos.containing(x, y, z), MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState(), 3);
                        int _value = 2;
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        BlockState _bs = world.getBlockState(_pos);
                        if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                            && _integerProp.getPossibleValues().contains(_value)) {
                            world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                        }
                    } else if (rate == 3.0) {
                        world.setBlock(BlockPos.containing(x, y, z), MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState(), 3);
                        int _value = 3;
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        BlockState _bs = world.getBlockState(_pos);
                        if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                            && _integerProp.getPossibleValues().contains(_value)) {
                            world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                        }
                    } else if (rate == 4.0) {
                        world.setBlock(BlockPos.containing(x, y, z), MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState(), 3);
                        int _value = 4;
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        BlockState _bs = world.getBlockState(_pos);
                        if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                            && _integerProp.getPossibleValues().contains(_value)) {
                            world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                        }
                    }
                }
            } else {
                entity.getPersistentData().putDouble("size", 1.0);
                entity.getPersistentData().putDouble("hitboxsize", 1.0);
            }

            if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.3, 1.3, 1.3), e -> true).isEmpty()
                && !(entity instanceof LivingEntity _livEnt17 && _livEnt17.isBaby())) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.65), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entity != entityiterator
                        && !(entityiterator instanceof BouncelizardEntity)
                        && !(entityiterator instanceof WebEntityEntity)
                        && !(entityiterator instanceof ExperienceOrb)
                        && !(entityiterator instanceof MoriRootsEntity)
                        && !entityiterator.onGround()) {
                        if (entity instanceof BouncelizardEntity _datEntL24 && _datEntL24.getEntityData().get(BouncelizardEntity.DATA_sleeping)) {
                            if (entity instanceof BouncelizardEntity) {
                                ((BouncelizardEntity)entity).setAnimation("bounce_big");
                            }

                            MoreCritters.queueServerWork(25, () -> {
                                if (entity instanceof BouncelizardEntity) {
                                    ((BouncelizardEntity)entity).setAnimation("empty");
                                }
                            });
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 30, false, false));
                            }

                            entityiterator.setDeltaMovement(
                                new Vec3(
                                    entityiterator.getDeltaMovement().x(),
                                    ServerConfig.CONFIG.bouncelizardSuperJump.get(),
                                    entityiterator.getDeltaMovement().z()
                                )
                            );
                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.big_bounce")),
                                        SoundSource.BLOCKS,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.big_bounce")),
                                        SoundSource.BLOCKS,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.sendParticles(MoreCrittersModParticleTypes.BOOST.get(), x, y + 0.7, z, 2, 0.4, 0.2, 0.4, 0.0);
                            }

                            MoreCritters.queueServerWork(2, () -> {
                                if (world instanceof ServerLevel _levelx) {
                                    _levelx.sendParticles(MoreCrittersModParticleTypes.BOOST.get(), x, y + 1.5, z, 2, 0.4, 0.2, 0.4, 0.0);
                                }

                                MoreCritters.queueServerWork(2, () -> {
                                    if (world instanceof ServerLevel _levelxx) {
                                        _levelxx.sendParticles(MoreCrittersModParticleTypes.BOOST.get(), x, y + 2.5, z, 2, 0.4, 0.2, 0.4, 0.0);
                                    }

                                    MoreCritters.queueServerWork(2, () -> {
                                        if (world instanceof ServerLevel _levelxxx) {
                                            _levelxxx.sendParticles(MoreCrittersModParticleTypes.BOOST.get(), x, y + 3.5, z, 2, 0.4, 0.2, 0.4, 0.0);
                                        }
                                    });
                                });
                            });
                        } else {
                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.bounce")),
                                        SoundSource.BLOCKS,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.bounce")),
                                        SoundSource.BLOCKS,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (entity instanceof BouncelizardEntity) {
                                ((BouncelizardEntity)entity).setAnimation("empty");
                            }

                            if (entity instanceof BouncelizardEntity) {
                                ((BouncelizardEntity)entity).setAnimation("bounce");
                            }

                            MoreCritters.queueServerWork(10, () -> {
                                if (entity instanceof BouncelizardEntity) {
                                    ((BouncelizardEntity)entity).setAnimation("empty");
                                }
                            });
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 30, false, false));
                            }

                            entityiterator.setDeltaMovement(
                                new Vec3(
                                    entityiterator.getDeltaMovement().x(), ServerConfig.CONFIG.bouncelizardJump.get(), entityiterator.getDeltaMovement().z()
                                )
                            );
                        }
                    }
                }
            }

            if (entity instanceof BouncelizardEntity _datEntL54 && _datEntL54.getEntityData().get(BouncelizardEntity.DATA_sleeping)) {
                if (!entity.getDisplayName().getString().equals("Skippy")
                    && !entity.getDisplayName().getString().equals("Skippybuttersz")
                    && !entity.getDisplayName().getString().equals("Skipster43")
                    && !entity.getDisplayName().getString().equals("Skipster")) {
                    if (!entity.getDisplayName().getString().equals("Dusty") && !entity.getDisplayName().getString().equals("athe7revx")) {
                        if (!entity.getDisplayName().getString().equals("Cutie") && !entity.getDisplayName().getString().equals("noname_thing")) {
                            if (!entity.getDisplayName().getString().equals("Waffle") && !entity.getDisplayName().getString().equals("BelgianCatWaffle")) {
                                if (!entity.getDisplayName().getString().equals("Rubber") && !entity.getDisplayName().getString().equals("Caticorny")) {
                                    if (!entity.getDisplayName().getString().equals("Offcolor") && !entity.getDisplayName().getString().equals("Lexpresstart")) {
                                        if (!entity.getDisplayName().getString().equals("Coralee")
                                            && !entity.getDisplayName().getString().equals("ProfessorScottie")) {
                                            if (!entity.getDisplayName().getString().equals("Breakfast")
                                                && !entity.getDisplayName().getString().equals("VictorGraves")) {
                                                if (!entity.getDisplayName().getString().equals("Wild")
                                                    && !entity.getDisplayName().getString().equals("Yarilis20")) {
                                                    if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null")
                                                            .equals("bouncelizard0")
                                                        && entity instanceof BouncelizardEntity animatable) {
                                                        animatable.setTexture("bouncelizard0_sleep");
                                                    }
                                                } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null")
                                                        .equals("bouncelizard9")
                                                    && entity instanceof BouncelizardEntity animatable) {
                                                    animatable.setTexture("bouncelizard9_sleep");
                                                }
                                            } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null")
                                                    .equals("bouncelizard8")
                                                && entity instanceof BouncelizardEntity animatable) {
                                                animatable.setTexture("bouncelizard8_sleep");
                                            }
                                        } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null").equals("bouncelizard7")
                                            && entity instanceof BouncelizardEntity animatable) {
                                            animatable.setTexture("bouncelizard7_sleep");
                                        }
                                    } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null").equals("bouncelizard6")
                                        && entity instanceof BouncelizardEntity animatable) {
                                        animatable.setTexture("bouncelizard6_sleep");
                                    }
                                } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null").equals("bouncelizard5")
                                    && entity instanceof BouncelizardEntity animatable) {
                                    animatable.setTexture("bouncelizard5_sleep");
                                }
                            } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null").equals("bouncelizard4")
                                && entity instanceof BouncelizardEntity animatable) {
                                animatable.setTexture("bouncelizard4_sleep");
                            }
                        } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null").equals("bouncelizard3")
                            && entity instanceof BouncelizardEntity animatable) {
                            animatable.setTexture("bouncelizard3_sleep");
                        }
                    } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null").equals("bouncelizard2")
                        && entity instanceof BouncelizardEntity animatable) {
                        animatable.setTexture("bouncelizard2_sleep");
                    }
                } else if ((entity instanceof BouncelizardEntity animatable ? animatable.getTexture() : "null").equals("bouncelizard1")
                    && entity instanceof BouncelizardEntity animatable) {
                    animatable.setTexture("bouncelizard1_sleep");
                }

                rate2 = Mth.nextInt(RandomSource.create(), 1, 6);
                if (rate2 == 1.0 && world instanceof ServerLevel _level) {
                    _level.sendParticles(MoreCrittersModParticleTypes.ZZZ.get(), x, y + 0.5, z, 2, 0.5, 0.04, 0.5, 0.01);
                }
            } else if (!(entity instanceof BouncelizardEntity _datEntL97 && _datEntL97.getEntityData().get(BouncelizardEntity.DATA_sleeping))) {
                if (!entity.getDisplayName().getString().equals("Skippy")
                    && !entity.getDisplayName().getString().equals("Skippybuttersz")
                    && !entity.getDisplayName().getString().equals("Skipster43")
                    && !entity.getDisplayName().getString().equals("Skipster")) {
                    if (!entity.getDisplayName().getString().equals("Dusty") && !entity.getDisplayName().getString().equals("athe7revx")) {
                        if (!entity.getDisplayName().getString().equals("Cutie") && !entity.getDisplayName().getString().equals("noname_thing")) {
                            if (!entity.getDisplayName().getString().equals("Waffle") && !entity.getDisplayName().getString().equals("BelgianCatWaffle")) {
                                if (!entity.getDisplayName().getString().equals("Rubber") && !entity.getDisplayName().getString().equals("Caticorny")) {
                                    if (!entity.getDisplayName().getString().equals("Offcolor") && !entity.getDisplayName().getString().equals("Lexpresstart")) {
                                        if (!entity.getDisplayName().getString().equals("Coralee")
                                            && !entity.getDisplayName().getString().equals("ProfessorScottie")) {
                                            if (!entity.getDisplayName().getString().equals("Breakfast")
                                                && !entity.getDisplayName().getString().equals("VictorGraves")) {
                                                if (!entity.getDisplayName().getString().equals("Wild")
                                                    && !entity.getDisplayName().getString().equals("Yarilis20")) {
                                                    if (entity instanceof BouncelizardEntity animatable) {
                                                        animatable.setTexture("bouncelizard0");
                                                    }
                                                } else if (entity instanceof BouncelizardEntity animatable) {
                                                    animatable.setTexture("bouncelizard9");
                                                }
                                            } else if (entity instanceof BouncelizardEntity animatable) {
                                                animatable.setTexture("bouncelizard8");
                                            }
                                        } else if (entity instanceof BouncelizardEntity animatable) {
                                            animatable.setTexture("bouncelizard7");
                                        }
                                    } else if (entity instanceof BouncelizardEntity animatable) {
                                        animatable.setTexture("bouncelizard6");
                                    }
                                } else if (entity instanceof BouncelizardEntity animatable) {
                                    animatable.setTexture("bouncelizard5");
                                }
                            } else if (entity instanceof BouncelizardEntity animatable) {
                                animatable.setTexture("bouncelizard4");
                            }
                        } else if (entity instanceof BouncelizardEntity animatable) {
                            animatable.setTexture("bouncelizard3");
                        }
                    } else if (entity instanceof BouncelizardEntity animatable) {
                        animatable.setTexture("bouncelizard2");
                    }
                } else if (entity instanceof BouncelizardEntity animatable) {
                    animatable.setTexture("bouncelizard1");
                }
            }

            entity.getPersistentData().putDouble("snore", entity.getPersistentData().getDouble("snore") - 1.0);
            entity.getPersistentData().putDouble("idle", entity.getPersistentData().getDouble("idle") - 1.0);
            if (entity.getPersistentData().getDouble("snore") < 0.0) {
                entity.getPersistentData().putDouble("snore", Mth.nextInt(RandomSource.create(), 60, 120));
                if (entity instanceof BouncelizardEntity _datEntL135 && _datEntL135.getEntityData().get(BouncelizardEntity.DATA_sleeping)) {
                    snorerate = Mth.nextDouble(RandomSource.create(), 1.0, 100.0);
                    if (!world.isClientSide()) {
                        if (snorerate == 1.0) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.snore_mimimi")),
                                        SoundSource.VOICE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.snore_mimimi")),
                                        SoundSource.VOICE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        } else if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.snore")),
                                    SoundSource.VOICE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.snore")),
                                    SoundSource.VOICE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("idle") < 0.0) {
                entity.getPersistentData().putDouble("idle", Mth.nextInt(RandomSource.create(), 100, 300));
                if (!(entity instanceof BouncelizardEntity _datEntL143 && _datEntL143.getEntityData().get(BouncelizardEntity.DATA_sleeping))
                    && !world.isClientSide()
                    && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.idle")),
                            SoundSource.VOICE,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.idle")),
                            SoundSource.VOICE,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }

            if (entity instanceof BouncelizardEntity _datEntL146 && _datEntL146.getEntityData().get(BouncelizardEntity.DATA_sleeping)) {
                if (!((BouncelizardEntity)entity).animationprocedure.equals("bounce")
                    && !((BouncelizardEntity)entity).animationprocedure.equals("bounce_big")
                    && !((BouncelizardEntity)entity).animationprocedure.equals("sleep")
                    && entity instanceof BouncelizardEntity) {
                    ((BouncelizardEntity)entity).setAnimation("sleep");
                }
            } else if (((BouncelizardEntity)entity).animationprocedure.equals("sleep") && entity instanceof BouncelizardEntity) {
                ((BouncelizardEntity)entity).setAnimation("empty");
            }
        }
    }
}
