package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.entity.LookoutSpitEntity;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CorpseLookoutOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double ultra = 0.0;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60.0), ex -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof Player
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

            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            if (entity.getPersistentData().getDouble("attack") == 0.0) {
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    ultra = Mth.nextInt(RandomSource.create(), 1, 5);
                    if (ultra == 1.0) {
                        if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
                            if (entity instanceof CorpseLookoutEntity) {
                                ((CorpseLookoutEntity)entity).setAnimation("ultra_spit2");
                            }
                        } else if (entity instanceof CorpseLookoutEntity) {
                            ((CorpseLookoutEntity)entity).setAnimation("ultra_spit1");
                        }

                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_lookout.spit")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    5.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_lookout.spit")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    5.0F,
                                    false
                                );
                            }
                        }

                        entity.lookAt(
                            Anchor.EYES,
                            new Vec3(
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY()
                                    + (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getBbHeight()
                                    + 50.0,
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                            )
                        );

                        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 6.0, 10.0); index0++) {
                            if (world instanceof ServerLevel projectileLevel) {
                                Projectile _entityToSpawn = (new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                        LookoutSpitEntity entityToSpawn = new LookoutSpitEntity(MoreCrittersModEntities.LOOKOUT_SPIT.get(), level);
                                        entityToSpawn.setOwner(shooter);
                                        entityToSpawn.setBaseDamage(damage);
                                        entityToSpawn.setKnockback(knockback);
                                        entityToSpawn.setSilent(true);
                                        return entityToSpawn;
                                    }
                                }).getArrow(projectileLevel, entity, 1.0F, 5);
                                _entityToSpawn.setPos(x, y, z);
                                _entityToSpawn.shoot(
                                    Mth.nextDouble(RandomSource.create(), -0.2, 0.2), 0.4, Mth.nextDouble(RandomSource.create(), -0.2, 0.2), 3.0F, 0.0F
                                );
                                projectileLevel.addFreshEntity(_entityToSpawn);
                            }
                        }
                    } else {
                        if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
                            if (entity instanceof CorpseLookoutEntity) {
                                ((CorpseLookoutEntity)entity).setAnimation("spit3");
                            }
                        } else if (entity instanceof CorpseLookoutEntity) {
                            ((CorpseLookoutEntity)entity).setAnimation("spit2");
                        }

                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_lookout.spit")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    5.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_lookout.spit")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    5.0F,
                                    false
                                );
                            }
                        }

                        entity.lookAt(
                            Anchor.EYES,
                            new Vec3(
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY()
                                    + (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getBbHeight(),
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                            )
                        );
                        Entity _shootFrom = entity;
                        Level projectileLevel = _shootFrom.level();
                        if (!projectileLevel.isClientSide()) {
                            Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    LookoutSpitEntity entityToSpawn = new LookoutSpitEntity(MoreCrittersModEntities.LOOKOUT_SPIT.get(), level);
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            }).getArrow(projectileLevel, entity, 1.0F, 5);
                            _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3.0F, 0.0F);
                            projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                    }

                    if ((
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                                    ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                    : -1.0F
                            )
                            > 0.0F
                        && (
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                                    ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                    : -1.0F
                            )
                            <= 3.0F) {
                        entity.getPersistentData().putDouble("attack", 20.0);
                    } else if ((
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                                    ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                    : -1.0F
                            )
                            > 3.0F
                        && (
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                                    ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                    : -1.0F
                            )
                            <= 10.0F) {
                        entity.getPersistentData().putDouble("attack", 40.0);
                    } else if ((
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                                ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                : -1.0F
                        )
                        > 10.0F) {
                        entity.getPersistentData().putDouble("attack", 100.0);
                    }
                } else {
                    entity.getPersistentData().putDouble("attack", 20.0);
                }
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                && (
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                            ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                            : -1.0F
                    )
                    > 0.0F
                && (
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                            ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                            : -1.0F
                    )
                    <= 4.0F
                && entity.onGround()) {
                entity.push(-0.2 * entity.getLookAngle().x, -0.2, -0.2 * entity.getLookAngle().z);
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
