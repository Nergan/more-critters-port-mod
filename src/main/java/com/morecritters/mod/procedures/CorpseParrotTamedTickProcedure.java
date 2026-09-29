package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.PebbleEntity;
import com.morecritters.mod.entity.TamedCorpseParrotEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class CorpseParrotTamedTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double shimmer = 0.0;
            double rate = 0.0;
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            entity.getPersistentData().putDouble("throw", entity.getPersistentData().getDouble("throw") - 1.0);
            if (entity.getPersistentData().getDouble("throw") == -1.0) {
                entity.getPersistentData().putDouble("throw", 100.0);
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity && !entity.onGround()) {
                    if (entity instanceof TamedCorpseParrotEntity) {
                        ((TamedCorpseParrotEntity)entity).setAnimation("throw");
                    }

                    MoreCritters.queueServerWork(3, () -> {
                        Entity _shootFrom = entity;
                        Level projectileLevel = _shootFrom.level();
                        if (!projectileLevel.isClientSide()) {
                            Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    PebbleEntity entityToSpawn = new PebbleEntity(MoreCrittersModEntities.PEBBLE.get(), level);
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            }).getArrow(projectileLevel, entity, 2.0F, 1);
                            _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1.0F, 0.0F);
                            projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                    });
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_parrot.throw")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_parrot.throw")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("timer") <= -1.0) {
                entity.getPersistentData().putDouble("timer", Mth.nextInt(RandomSource.create(), 100, 300));
                if (entity.onGround()) {
                    if (entity instanceof TamedCorpseParrotEntity) {
                        ((TamedCorpseParrotEntity)entity).setAnimation("ready");
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 29, false, false));
                    }

                    MoreCritters.queueServerWork(
                        7, () -> entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.2, 0.2, entity.getLookAngle().z * 0.2))
                    );
                }
            }

            if (entity.onGround()
                && !((TamedCorpseParrotEntity)entity).animationprocedure.equals("ready")
                && !((TamedCorpseParrotEntity)entity).animationprocedure.equals("land")) {
                entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
            }

            if (entity instanceof TamedCorpseParrotEntity _datEntL29 && _datEntL29.getEntityData().get(TamedCorpseParrotEntity.DATA_sit)) {
                if (entity.onGround()) {
                    if (entity instanceof TamedCorpseParrotEntity) {
                        ((TamedCorpseParrotEntity)entity).setAnimation("sitting");
                    }
                } else {
                    entity.setDeltaMovement(new Vec3(0.0, -0.2, 0.0));
                }
            }
        }
    }
}
