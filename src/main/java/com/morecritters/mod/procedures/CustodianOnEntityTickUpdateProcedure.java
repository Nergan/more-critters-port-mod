package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.CustodianEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CustodianOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double Grow = 0.0;
            double TrackZ = 0.0;
            double TrackY = 0.0;
            double TrackX = 0.0;
            if ((
                    ((CustodianEntity)entity).animationprocedure.equals("open2")
                        || ((CustodianEntity)entity).animationprocedure.equals("open_small")
                        || ((CustodianEntity)entity).animationprocedure.equals("hurt1")
                        || ((CustodianEntity)entity).animationprocedure.equals("hurt2")
                )
                && entity instanceof LivingEntity _entity
                && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 25, false, false));
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Warden
                    && !((CustodianEntity)entity).animationprocedure.equals("open2")
                    && !((CustodianEntity)entity).animationprocedure.equals("open_small")) {
                    if (!((CustodianEntity)entity).animationprocedure.equals("close") && !world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.laser_start")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.laser_start")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    entity.getPersistentData().putDouble("shoot", 100.0);
                    if (entity instanceof CustodianEntity) {
                        ((CustodianEntity)entity).setAnimation("open2");
                    }

                    if (entity instanceof CustodianEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CustodianEntity.DATA_charging, true);
                    }
                }

                if (!((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Warden)
                    && !((CustodianEntity)entity).animationprocedure.equals("open2")
                    && !((CustodianEntity)entity).animationprocedure.equals("open_small")) {
                    if (!((CustodianEntity)entity).animationprocedure.equals("close") && !world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.laser_start")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.laser_start")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    entity.getPersistentData().putDouble("shoot", 100.0);
                    if (entity instanceof CustodianEntity) {
                        ((CustodianEntity)entity).setAnimation("open_small");
                    }

                    if (entity instanceof CustodianEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CustodianEntity.DATA_charging, true);
                    }
                }
            }

            if (!((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)
                && entity instanceof CustodianEntity _datEntL29
                && _datEntL29.getEntityData().get(CustodianEntity.DATA_charging)) {
                if (entity instanceof CustodianEntity) {
                    ((CustodianEntity)entity).setAnimation("open_cancel");
                }

                if (entity instanceof CustodianEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(CustodianEntity.DATA_charging, false);
                }
            }

            entity.getPersistentData().putDouble("shoot", entity.getPersistentData().getDouble("shoot") - 1.0);
            if (entity.getPersistentData().getDouble("shoot") == 1.0 && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Warden) {
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.laser_shoot_warden")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.laser_shoot_warden")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.close")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.close")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (world instanceof ServerLevel _level) {
                        ItemEntity entityToSpawn = new ItemEntity(
                            _level,
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY(),
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ(),
                            new ItemStack(MoreCrittersModItems.SCULK_ESSENCE.get())
                        );
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(
                                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY(),
                                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                                        ),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:warden_explosion ~ ~1 ~ 0 0 0 0 1 normal"
                            );
                    }

                    TrackX = entity.getX() - (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX();
                    TrackY = entity.getY()
                        - (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY()
                        + entity.getBbHeight() * 0.75
                        - (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getBbHeight() * 0.75;
                    TrackZ = entity.getZ() - (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ();
                    Grow = Grow;

                    for (int index0 = 0; index0 < 20; index0++) {
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(
                                MoreCrittersModParticleTypes.CUSTODIAN_LAZER.get(),
                                entity.getX() + TrackX * Grow,
                                entity.getY() + entity.getBbHeight() * 0.75 + 0.8 + TrackY * Grow,
                                entity.getZ() + TrackZ * Grow,
                                5,
                                0.05,
                                0.05,
                                0.05,
                                0.0
                            );
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(
                                ParticleTypes.SMOKE,
                                entity.getX() + TrackX * Grow,
                                entity.getY() + entity.getBbHeight() * 0.75 + 0.8 + TrackY * Grow,
                                entity.getZ() + TrackZ * Grow,
                                5,
                                0.05,
                                0.05,
                                0.05,
                                0.0
                            );
                        }

                        Grow -= 0.05;
                    }

                    if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _entity) {
                        _entity.setHealth(0.0F);
                    }

                    if (entity instanceof CustodianEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CustodianEntity.DATA_charging, false);
                    }

                    if (entity instanceof CustodianEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CustodianEntity.DATA_closed, true);
                    }

                    entity.getPersistentData().putDouble("cooldown", 12000.0);
                } else {
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.shoot")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.shoot")),
                                SoundSource.NEUTRAL,
                                5.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.close")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.close")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof Monster
                            && entity instanceof LivingEntity _liveEnt
                            && entityiterator != null
                            && _liveEnt.hasLineOfSight(entityiterator)) {
                            entityiterator.hurt(
                                new DamageSource(
                                    world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), entityiterator
                                ),
                                200.0F
                            );
                            entity.getPersistentData().putDouble("shot", 20.0);
                        }
                    }

                    if (entity instanceof CustodianEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CustodianEntity.DATA_charging, false);
                    }

                    if (entity instanceof CustodianEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(CustodianEntity.DATA_closed, true);
                    }

                    entity.getPersistentData().putDouble("cooldown", 12000.0);
                }
            }

            if (entity instanceof CustodianEntity _datEntL97 && _datEntL97.getEntityData().get(CustodianEntity.DATA_closed)) {
                if (!((CustodianEntity)entity).animationprocedure.equals("openup") && entity instanceof CustodianEntity) {
                    ((CustodianEntity)entity).setAnimation("close");
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:cloud ~ ~2.5 ~ 0 0 0 0.012 1 force"
                        );
                }

                entity.setDeltaMovement(new Vec3(0.0, -2.0, 0.0));
            }

            entity.getPersistentData().putDouble("cooldown", entity.getPersistentData().getDouble("cooldown") - 1.0);
            if (entity.getPersistentData().getDouble("cooldown") == 1.0 && entity instanceof CustodianEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(CustodianEntity.DATA_closed, false);
            }

            if (entity.getPersistentData().getDouble("cooldown") == 30.0 && entity instanceof CustodianEntity) {
                ((CustodianEntity)entity).setAnimation("openup");
            }

            entity.getPersistentData().putDouble("shot", entity.getPersistentData().getDouble("shot") - 1.0);
        }
    }
}
