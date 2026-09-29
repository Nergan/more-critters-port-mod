package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.BalloonRatEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BalloonRatOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity) {
                _entity.removeEffect(MobEffects.POISON);
            }

            if (entity instanceof BalloonRatEntity _datEntL1 && _datEntL1.getEntityData().get(BalloonRatEntity.DATA_sit) && entity instanceof BalloonRatEntity) {
                ((BalloonRatEntity)entity).setAnimation("sit");
            }

            if ((entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 0) {
                if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).isEmpty()) {
                    Entity _center = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (_center instanceof Player _plr && _plr.getAbilities().instabuild) {
                        _center = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null);
                        if (_center instanceof Player _plrx && _plrx.getAbilities().instabuild) {
                            entity.getPersistentData().putDouble("inflated", 0.0);
                        }
                    } else {
                        entity.getPersistentData().putDouble("inflated", 1.0);
                    }
                } else {
                    entity.getPersistentData().putDouble("inflated", 0.0);
                }

                if (entity.getPersistentData().getDouble("inflated") == 1.0) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 1, false, false));
                    }

                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * -0.05, -0.2, entity.getLookAngle().z * -0.05));
                    if ((entity instanceof BalloonRatEntity animatable ? animatable.getTexture() : "null").equals("balloon_rat")) {
                        if (!((BalloonRatEntity)entity).animationprocedure.equals("inflate") && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.inflate")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.inflate")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (entity instanceof BalloonRatEntity) {
                            ((BalloonRatEntity)entity).setAnimation("inflate");
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 30, false, false));
                        }

                        entity.setDeltaMovement(new Vec3(0.0, 0.01, 0.0));
                        entity.lookAt(
                            Anchor.EYES,
                            new Vec3(
                                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                        }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getX(),
                                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                                        .stream()
                                        .sorted((new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }).compareDistOf(x, y, z))
                                        .findFirst()
                                        .orElse(null)
                                        .getY()
                                    + 1.0,
                                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                        }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .getZ()
                            )
                        );
                        MoreCritters.queueServerWork(17, () -> {
                            if (entity instanceof BalloonRatEntity animatable) {
                                animatable.setTexture("balloon_rat_inflated");
                            }
                        });
                    }
                } else if (entity.getPersistentData().getDouble("inflated") == 0.0
                    && (entity instanceof BalloonRatEntity animatable ? animatable.getTexture() : "null").equals("balloon_rat_inflated")) {
                    if (!((BalloonRatEntity)entity).animationprocedure.equals("deflate") && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.deflate")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.deflate")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof BalloonRatEntity) {
                        ((BalloonRatEntity)entity).setAnimation("deflate");
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                    }

                    MoreCritters.queueServerWork(16, () -> {
                        if (entity instanceof BalloonRatEntity animatable) {
                            animatable.setTexture("balloon_rat");
                        }
                    });
                }

                if (!(entity instanceof BalloonRatEntity animatable ? animatable.getTexture() : "null").equals("balloon_rat_inflated")
                    && entity instanceof BalloonRatEntity animatable) {
                    animatable.setTexture("balloon_rat");
                }

                if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(MoreCrittersModParticleTypes.MEDIC_STRIPE.get(), x, y, z, 6, 0.5, 0.0, 0.5, 0.0);
                    }

                    if (entity instanceof BalloonRatEntity _datEntSetI) {
                        _datEntSetI.getEntityData().set(BalloonRatEntity.DATA_variant, 1);
                    }
                }
            } else if ((entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 1) {
                if (!(entity instanceof BalloonRatEntity animatable ? animatable.getTexture() : "null").equals("balloon_rat_medic_inflated")
                    && entity instanceof BalloonRatEntity animatable) {
                    animatable.setTexture("balloon_rat_medic");
                }
            } else if ((entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2
                && !(entity instanceof BalloonRatEntity animatable ? animatable.getTexture() : "null").equals("balloon_rat_soldier_inflated")
                && entity instanceof BalloonRatEntity animatable) {
                animatable.setTexture("balloon_rat_soldier");
            }

            entity.getPersistentData().putDouble("heal", entity.getPersistentData().getDouble("heal") - 1.0);
            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            if (entity.getPersistentData().getDouble("heal") <= -1.0) {
                entity.getPersistentData().putDouble("heal", 1200.0);
                if ((entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 1
                    && !(entity instanceof BalloonRatEntity _datEntL58 && _datEntL58.getEntityData().get(BalloonRatEntity.DATA_sit))) {
                    if (entity instanceof BalloonRatEntity) {
                        ((BalloonRatEntity)entity).setAnimation("inflate");
                    }

                    MoreCritters.queueServerWork(10, () -> {
                        if (entity instanceof BalloonRatEntity animatable) {
                            animatable.setTexture("balloon_rat_medic_inflated");
                        }
                    });
                    MoreCritters.queueServerWork(20, () -> {
                        if (entity instanceof BalloonRatEntity animatable) {
                            animatable.setTexture("balloon_rat_medic");
                        }
                    });
                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof LivingEntity
                            && (
                                entityiterator == (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null)
                                    || entityiterator instanceof TamableAnimal _tamIsTamedBy
                                        && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt
                                        && _tamIsTamedBy.isOwnedBy(_livEnt)
                                    || entityiterator == entity
                            )) {
                            MoreCritters.queueServerWork(20, () -> {
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, true));
                                }
                            });
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("attack") <= -1.0) {
                if ((entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2
                    && !(entity instanceof BalloonRatEntity _datEntL75 && _datEntL75.getEntityData().get(BalloonRatEntity.DATA_sit))
                    && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                    && (
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                                ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                : -1.0F
                        )
                        <= 5.0F
                    && entity.onGround()) {
                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.6, 0.5, entity.getLookAngle().z * 0.6));
                    if (entity instanceof BalloonRatEntity) {
                        ((BalloonRatEntity)entity).setAnimation("inflate");
                    }

                    MoreCritters.queueServerWork(10, () -> {
                        if (entity instanceof BalloonRatEntity animatable) {
                            animatable.setTexture("balloon_rat_soldier_inflated");
                        }
                    });
                    MoreCritters.queueServerWork(20, () -> {
                        if (entity instanceof BalloonRatEntity animatable) {
                            animatable.setTexture("balloon_rat_soldier");
                        }
                    });
                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof LivingEntity
                            && entityiterator != (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null)
                            && !(
                                entityiterator instanceof TamableAnimal _tamIsTamedBy
                                    && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt
                                    && _tamIsTamedBy.isOwnedBy(_livEnt)
                            )
                            && entityiterator != entity) {
                            MoreCritters.queueServerWork(20, () -> {
                                if (entity instanceof LivingEntity _livEnt95 && _livEnt95.hasEffect(MoreCrittersModMobEffects.STAGNATION)) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.STAGNATION, 100, 2, false, true));
                                    }
                                } else if (entity instanceof LivingEntity _livEnt97 && _livEnt97.hasEffect(MoreCrittersModMobEffects.BRITTLENESS)) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.BRITTLENESS, 100, 2, false, true));
                                    }
                                } else if (entity instanceof LivingEntity _livEnt99 && _livEnt99.hasEffect(MoreCrittersModMobEffects.ASPHYXIATION)) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.ASPHYXIATION, 100, 2, false, true));
                                    }
                                } else if (entity instanceof LivingEntity _livEnt101 && _livEnt101.hasEffect(MoreCrittersModMobEffects.HALLUCINAZIUM)) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.HALLUCINAZIUM, 100, 2, false, true));
                                    }
                                } else if (entity instanceof LivingEntity _livEnt103 && _livEnt103.hasEffect(MoreCrittersModMobEffects.MUSCLE_ACHE)) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.MUSCLE_ACHE, 100, 2, false, true));
                                    }
                                } else if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 2, false, true));
                                }
                            });
                        }
                    }
                }

                entity.getPersistentData().putDouble("attack", 100.0);
            }

            if (entity instanceof LivingEntity _livEnt109 && _livEnt109.isBaby()) {
                entity.getPersistentData().putDouble("size", 0.7);
            } else {
                entity.getPersistentData().putDouble("size", 1.2);
            }

            if (entity instanceof LivingEntity _livEnt112 && _livEnt112.hasEffect(MoreCrittersModMobEffects.STAGNATION)) {
                if (entity instanceof BalloonRatEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_stagnation, true);
                }
            } else if (entity instanceof BalloonRatEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_stagnation, false);
            }

            if (entity instanceof LivingEntity _livEnt115 && _livEnt115.hasEffect(MoreCrittersModMobEffects.ASPHYXIATION)) {
                if (entity instanceof BalloonRatEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_asphyxiation, true);
                }
            } else if (entity instanceof BalloonRatEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_asphyxiation, false);
            }

            if (entity instanceof LivingEntity _livEnt118 && _livEnt118.hasEffect(MoreCrittersModMobEffects.BRITTLENESS)) {
                if (entity instanceof BalloonRatEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_brittleness, true);
                }
            } else if (entity instanceof BalloonRatEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_brittleness, false);
            }

            if (entity instanceof LivingEntity _livEnt121 && _livEnt121.hasEffect(MoreCrittersModMobEffects.HALLUCINAZIUM)) {
                if (entity instanceof BalloonRatEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_hallucinazium, true);
                }
            } else if (entity instanceof BalloonRatEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_hallucinazium, false);
            }

            if (entity instanceof LivingEntity _livEnt124 && _livEnt124.hasEffect(MoreCrittersModMobEffects.MUSCLE_ACHE)) {
                if (entity instanceof BalloonRatEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_muscle_ache, true);
                }
            } else if (entity instanceof BalloonRatEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(BalloonRatEntity.DATA_has_muscle_ache, false);
            }
        }
    }
}
