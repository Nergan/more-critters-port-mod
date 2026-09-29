package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.entity.CorpseTankEntity;
import com.morecritters.mod.entity.FlyingPearlEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class CorpseTankOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8.0), ex -> true)
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

            entity.getPersistentData().putDouble("fire", entity.getPersistentData().getDouble("fire") - 1.0);
            if (entity.getPersistentData().getDouble("fire") == 0.0) {
                entity.getPersistentData().putDouble("fire", ServerConfig.CONFIG.tankCooldown.get());
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                    && entity instanceof LivingEntity _liveEnt
                    && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                    && _liveEnt.hasLineOfSight(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)) {
                    if (entity instanceof CorpseTankEntity) {
                        ((CorpseTankEntity)entity).setAnimation("shoot");
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.ready")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.ready")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    MoreCritters.queueServerWork(30, () -> {
                        if (entity.isAlive() && entity instanceof CorpseTankEntity) {
                            ((CorpseTankEntity)entity).setAnimation("empty");
                        }
                    });
                    MoreCritters.queueServerWork(
                        18,
                        () -> {
                            if (entity.isAlive()) {
                                if (entity instanceof CorpseTankEntity _datEntSetL) {
                                    _datEntSetL.getEntityData().set(CorpseTankEntity.DATA_HasShot, true);
                                }

                                if (!world.isClientSide() && world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.shoot")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.shoot")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) instanceof LivingEntity) {
                                    entity.lookAt(
                                        Anchor.EYES,
                                        new Vec3(
                                            (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getX(),
                                            (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getY()
                                                + (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getBbHeight(),
                                            (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                                        )
                                    );
                                }

                                if (world instanceof ServerLevel projectileLevel) {
                                    Projectile _entityToSpawn = (new Object() {
                                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                            FlyingPearlEntity entityToSpawn = new FlyingPearlEntity(MoreCrittersModEntities.FLYING_PEARL.get(), level);
                                            entityToSpawn.setOwner(shooter);
                                            entityToSpawn.setBaseDamage(damage);
                                            entityToSpawn.setKnockback(knockback);
                                            entityToSpawn.setSilent(true);
                                            return entityToSpawn;
                                        }
                                    }).getArrow(projectileLevel, entity, 5.0F, 2);
                                    _entityToSpawn.setPos(x, y + 2.0, z);
                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2.0F, 0.0F);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                }
                            }
                        }
                    );
                }
            }

            if (((CorpseTankEntity)entity).animationprocedure.equals("shoot") && entity.onGround()) {
                entity.setDeltaMovement(new Vec3(0.0, -3.0, 0.0));
            }

            entity.getPersistentData().putDouble("speech", entity.getPersistentData().getDouble("speech") - 1.0);
            if (entity.getPersistentData().getDouble("speech") <= -1.0) {
                rate = Mth.nextInt(RandomSource.create(), 1, 10);
                if (rate == 1.0) {
                    entity.getPersistentData().putDouble("speech", 600.0);
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.sing")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.sing")),
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
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.speech")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_tank.speech")),
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
