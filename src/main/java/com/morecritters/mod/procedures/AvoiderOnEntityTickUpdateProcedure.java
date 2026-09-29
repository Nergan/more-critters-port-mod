package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.AvoiderEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AvoiderOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double stuck = 0.0;
            if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6 && entity.isInWaterOrBubble()) {
                rate = Mth.nextInt(RandomSource.create(), 1, 3);
                if (rate == 1.0 && world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:bubble ~ ~0.2 ~ 0.1 0.1 0.1 0.1 1 force"
                        );
                }
            }

            entity.getPersistentData().putDouble("leap", entity.getPersistentData().getDouble("leap") - 1.0);
            if (entity.getPersistentData().getDouble("leap") < 0.0) {
                entity.getPersistentData().putDouble("leap", Mth.nextInt(RandomSource.create(), 200, 300));
                if (entity.isInWaterOrBubble() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.LEAPER, 200, 0, false, false));
                }
            }

            if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MoreCrittersModMobEffects.LEAPER)) {
                if (entity.isInWaterOrBubble()) {
                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.4, 0.5, entity.getLookAngle().z * 0.4));
                } else {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.removeEffect(MoreCrittersModMobEffects.LEAPER);
                    }

                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.4, 0.5, entity.getLookAngle().z * 0.4));
                    if (entity instanceof AvoiderEntity) {
                        ((AvoiderEntity)entity).setAnimation("air");
                    }
                }
            }

            if (entity.isInWaterOrBubble()) {
                if (entity instanceof LivingEntity _liveEnt
                    && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z)).findFirst().orElse(null) != null
                    && _liveEnt.hasLineOfSight(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).stream().sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null)
                    )) {
                    Entity _entfound = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (_entfound instanceof Player _plr && _plr.getAbilities().instabuild) {
                        if (entity instanceof AvoiderEntity animatable) {
                            animatable.setTexture("avoider");
                        }

                        if (((AvoiderEntity)entity).animationprocedure.equals("run") && entity instanceof AvoiderEntity) {
                            ((AvoiderEntity)entity).setAnimation("run_end");
                        }
                    } else {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20, 2, false, false));
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:bubble ~ ~0.2 ~ 0.1 0.1 0.1 0.1 1 force"
                                );
                        }

                        if (!((AvoiderEntity)entity).animationprocedure.equals("run")) {
                            if (entity instanceof AvoiderEntity) {
                                ((AvoiderEntity)entity).setAnimation("run_start");
                            }

                            MoreCritters.queueServerWork(5, () -> {
                                if (entity instanceof AvoiderEntity) {
                                    ((AvoiderEntity)entity).setAnimation("run");
                                }
                            });
                        }

                        if (entity instanceof AvoiderEntity animatable) {
                            animatable.setTexture("avoider_scared");
                        }
                    }
                } else {
                    if (entity instanceof AvoiderEntity animatable) {
                        animatable.setTexture("avoider");
                    }

                    if (((AvoiderEntity)entity).animationprocedure.equals("run") && entity instanceof AvoiderEntity) {
                        ((AvoiderEntity)entity).setAnimation("run_end");
                    }
                }

                if (((AvoiderEntity)entity).animationprocedure.equals("air") && entity instanceof AvoiderEntity) {
                    ((AvoiderEntity)entity).setAnimation("run_end");
                }
            } else {
                if (entity instanceof AvoiderEntity animatable) {
                    animatable.setTexture("avoider");
                }

                if (((AvoiderEntity)entity).animationprocedure.equals("run") && entity instanceof AvoiderEntity) {
                    ((AvoiderEntity)entity).setAnimation("run_end");
                }

                if (!entity.onGround()) {
                    if (entity instanceof AvoiderEntity) {
                        ((AvoiderEntity)entity).setAnimation("air");
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 1, false, false));
                    }

                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.4, entity.getDeltaMovement().y(), entity.getLookAngle().z * 0.4));
                } else if (((AvoiderEntity)entity).animationprocedure.equals("air") && entity instanceof AvoiderEntity) {
                    ((AvoiderEntity)entity).setAnimation("run_end");
                }
            }

            if ((entity instanceof AvoiderEntity animatable ? animatable.getTexture() : "null").equals("avoider_scared")
                && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.KELP_PLANT) {
                world.destroyBlock(BlockPos.containing(x, y, z), false);
                if (world instanceof Level _level) {
                    _level.updateNeighborsAt(BlockPos.containing(x, y + 1.0, z), _level.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock());
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 7);
                if (rate == 1.0) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.avoider.stun")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.avoider.stun")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.STUNNED, 100, 0, false, false));
                    }
                }
            }

            if (entity.isInWaterOrBubble()) {
                entity.getPersistentData().putDouble("air", 200.0);
            } else {
                entity.getPersistentData().putDouble("air", entity.getPersistentData().getDouble("air") - 1.0);
            }

            if (entity.getPersistentData().getDouble("air") <= -1.0) {
                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)), 1.0F);
                entity.getPersistentData().putDouble("air", 20.0);
            }

            if (entity instanceof LivingEntity _livEnt70 && _livEnt70.isBaby()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.AVOIDER_FRY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof Player && entityiterator instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:breed_avoider"));
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
