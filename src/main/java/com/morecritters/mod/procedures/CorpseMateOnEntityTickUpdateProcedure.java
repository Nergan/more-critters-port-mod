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
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CorpseMateOnEntityTickUpdateProcedure {
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

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player _plr && _plr.getAbilities().instabuild)
                && (
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                            ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                            : -1.0F
                    )
                    <= 2.0F
                && !((CorpseMateEntity)entity).animationprocedure.equals("attack")) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.ready")),
                            SoundSource.HOSTILE,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.ready")),
                            SoundSource.HOSTILE,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity && entity instanceof CorpseMateEntity) {
                    ((CorpseMateEntity)entity).setAnimation("attack");
                }

                MoreCritters.queueServerWork(
                    5,
                    () -> {
                        if (entity.isAlive()) {
                            if ((entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) instanceof LivingEntity) {
                                if ((
                                        (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null) != null
                                            ? entity.distanceTo(entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null)
                                            : -1.0F
                                    )
                                    <= 2.0F) {
                                    MoreCritters.queueServerWork(
                                        3,
                                        () -> {
                                            if (entity.isAlive()
                                                && (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null) instanceof LivingEntity) {
                                                if ((entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null) instanceof LivingEntity _livEnt43
                                                    && _livEnt43.isBlocking()) {
                                                    if (!world.isClientSide() && world instanceof Level _levelx) {
                                                        if (!_levelx.isClientSide()) {
                                                            _levelx.playSound(
                                                                (Player)null,
                                                                BlockPos.containing(x, y, z),
                                                                BuiltInRegistries.SOUND_EVENT
                                                                    .get(ResourceLocation.parse("more_critters:entity.corpse_mate.miss")),
                                                                SoundSource.HOSTILE,
                                                                1.0F,
                                                                1.0F
                                                            );
                                                        } else {
                                                            _levelx.playLocalSound(
                                                                x,
                                                                y,
                                                                z,
                                                                BuiltInRegistries.SOUND_EVENT
                                                                    .get(ResourceLocation.parse("more_critters:entity.corpse_mate.miss")),
                                                                SoundSource.HOSTILE,
                                                                1.0F,
                                                                1.0F,
                                                                false
                                                            );
                                                        }
                                                    }
                                                } else {
                                                    (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null)
                                                        .hurt(
                                                            new DamageSource(
                                                                world.registryAccess()
                                                                    .registryOrThrow(Registries.DAMAGE_TYPE)
                                                                    .getHolderOrThrow(
                                                                        ResourceKey.create(
                                                                            Registries.DAMAGE_TYPE, ResourceLocation.parse("more_critters:slashed")
                                                                        )
                                                                    )
                                                            ),
                                                            5.0F
                                                        );
                                                    if (!world.isClientSide() && world instanceof Level _levelxx) {
                                                        if (!_levelxx.isClientSide()) {
                                                            _levelxx.playSound(
                                                                (Player)null,
                                                                BlockPos.containing(x, y, z),
                                                                BuiltInRegistries.SOUND_EVENT
                                                                    .get(ResourceLocation.parse("more_critters:entity.corpse_mate.attack")),
                                                                SoundSource.HOSTILE,
                                                                1.0F,
                                                                1.0F
                                                            );
                                                        } else {
                                                            _levelxx.playLocalSound(
                                                                x,
                                                                y,
                                                                z,
                                                                BuiltInRegistries.SOUND_EVENT
                                                                    .get(ResourceLocation.parse("more_critters:entity.corpse_mate.attack")),
                                                                SoundSource.HOSTILE,
                                                                1.0F,
                                                                1.0F,
                                                                false
                                                            );
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    );
                                } else if (!world.isClientSide() && world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.miss")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.miss")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }
                            }

                            MoreCritters.queueServerWork(23, () -> {
                                if (entity.isAlive() && entity instanceof CorpseMateEntity) {
                                    ((CorpseMateEntity)entity).setAnimation("empty");
                                }
                            });
                        }
                    }
                );
            }

            if (((CorpseMateEntity)entity).animationprocedure.equals("attack") && entity.onGround()) {
                entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }

            if ((entity instanceof CorpseMateEntity _datEntI ? _datEntI.getEntityData().get(CorpseMateEntity.DATA_variant) : 0) == 0) {
                if (entity instanceof CorpseMateEntity animatable) {
                    animatable.setTexture("corpse_mate0");
                }
            } else if ((entity instanceof CorpseMateEntity _datEntI ? _datEntI.getEntityData().get(CorpseMateEntity.DATA_variant) : 0) == 1) {
                if (entity instanceof CorpseMateEntity animatable) {
                    animatable.setTexture("corpse_mate1");
                }
            } else if ((entity instanceof CorpseMateEntity _datEntI ? _datEntI.getEntityData().get(CorpseMateEntity.DATA_variant) : 0) == 2) {
                if (entity instanceof CorpseMateEntity animatable) {
                    animatable.setTexture("corpse_mate2");
                }
            } else if ((entity instanceof CorpseMateEntity _datEntI ? _datEntI.getEntityData().get(CorpseMateEntity.DATA_variant) : 0) == 3) {
                if (entity instanceof CorpseMateEntity animatable) {
                    animatable.setTexture("corpse_mate3");
                }
            } else if ((entity instanceof CorpseMateEntity _datEntI ? _datEntI.getEntityData().get(CorpseMateEntity.DATA_variant) : 0) == 4
                && entity instanceof CorpseMateEntity animatable) {
                animatable.setTexture("corpse_mate4");
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
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.sing")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.sing")),
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
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.speech")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_mate.speech")),
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
