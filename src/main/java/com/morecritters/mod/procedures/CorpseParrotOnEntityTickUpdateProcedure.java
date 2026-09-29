package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.entity.CorpseTankEntity;
import com.morecritters.mod.entity.PebbleEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CorpseParrotOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double shimmer = 0.0;
            double rate = 0.0;
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            entity.getPersistentData().putDouble("throw", entity.getPersistentData().getDouble("throw") - 1.0);
            if (entity.getPersistentData().getDouble("throw") == 1.0) {
                entity.getPersistentData().putDouble("throw", 100.0);
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity && !entity.onGround()) {
                    if (entity instanceof CorpseParrotEntity) {
                        ((CorpseParrotEntity)entity).setAnimation("throw");
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
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_parrot.throw")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("timer") == 1.0) {
                entity.getPersistentData().putDouble("timer", Mth.nextInt(RandomSource.create(), 100, 300));
                if (entity.onGround()) {
                    if (entity instanceof CorpseParrotEntity) {
                        ((CorpseParrotEntity)entity).setAnimation("ready");
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
                && !((CorpseParrotEntity)entity).animationprocedure.equals("ready")
                && !((CorpseParrotEntity)entity).animationprocedure.equals("land")) {
                entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), ex -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if ((entityiterator instanceof Player || entityiterator instanceof Monster)
                    && !(entityiterator instanceof Creeper)
                    && !(entityiterator instanceof CorpseCaptainEntity)
                    && !(entityiterator instanceof CorpseLookoutEntity)
                    && !(entityiterator instanceof CorpseMateEntity)
                    && !(entityiterator instanceof CorpseParrotEntity)
                    && !(entityiterator instanceof CorpseQuartermasterEntity)
                    && !(entityiterator instanceof CorpseTankEntity)
                    && entity instanceof LivingEntity _liveEnt
                    && entityiterator != null
                    && _liveEnt.hasLineOfSight(entityiterator)
                    && !(new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.CREATIVE
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(entityiterator)
                    && !(new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.SPECTATOR
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(entityiterator)
                    && (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                        != MoreCrittersModItems.PIRATE_HELMET.get()
                    && (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                        != MoreCrittersModItems.PIRATE_CHESTPLATE.get()
                    && (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
                        != MoreCrittersModItems.PIRATE_LEGGINGS.get()
                    && (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                        != MoreCrittersModItems.PIRATE_BOOTS.get()
                    && entity instanceof Mob _entity
                    && entityiterator instanceof LivingEntity _ent) {
                    _entity.setTarget(_ent);
                }
            }

            entity.getPersistentData().putDouble("speech", entity.getPersistentData().getDouble("speech") - 1.0);
            if (entity.getPersistentData().getDouble("speech") <= -1.0) {
                rate = Mth.nextInt(RandomSource.create(), 1, 20);
                if (rate == 1.0) {
                    entity.getPersistentData().putDouble("speech", 600.0);
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_parrot.sing")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_parrot.sing")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                } else {
                    entity.getPersistentData().putDouble("speech", Mth.nextDouble(RandomSource.create(), 200.0, 600.0));
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_parrot.speech")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_parrot.speech")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                && (
                    (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player _plr && _plr.getAbilities().instabuild
                        || !(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).isAlive()
                )
                && entity instanceof Mob) {
                try {
                    ((Mob)entity).setTarget(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
