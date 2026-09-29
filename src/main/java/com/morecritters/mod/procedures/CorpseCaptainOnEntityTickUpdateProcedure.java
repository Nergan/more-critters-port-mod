package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.entity.CorpseCrewEntity;
import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.entity.CorpseTankEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CorpseCaptainOnEntityTickUpdateProcedure {
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
                    && !(entityiterator instanceof CorpseCrewEntity)
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

            entity.getPersistentData().putDouble("summon", entity.getPersistentData().getDouble("summon") - 1.0);
            entity.getPersistentData().putDouble("call", entity.getPersistentData().getDouble("call") - 1.0);
            entity.getPersistentData().putDouble("callcrew", entity.getPersistentData().getDouble("callcrew") - 1.0);
            if (entity.getPersistentData().getDouble("callcrew") == 0.0) {
                entity.getPersistentData().putDouble("callcrew", 600.0);
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    Vec3 _centerx = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(32.0), ex -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof CorpseParrotEntity
                            || entityiterator instanceof CorpseTankEntity
                            || entityiterator instanceof CorpseMateEntity
                            || entityiterator instanceof CorpseQuartermasterEntity
                            || entityiterator instanceof CorpseCaptainEntity) {
                            MoreCritters.queueServerWork(40, () -> {
                                if (entityiterator instanceof LivingEntity _entityxx && !_entityxx.level().isClientSide()) {
                                    _entityxx.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, true));
                                }

                                if (entityiterator instanceof LivingEntity _entityx && !_entityx.level().isClientSide()) {
                                    _entityx.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, false, true));
                                }
                            });
                        }
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.heal")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.heal")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof CorpseCaptainEntity) {
                        ((CorpseCaptainEntity)entity).setAnimation("call");
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 45, 99, false, false));
                    }
                }
            }

            if (entity.getPersistentData().getDouble("call") == 0.0) {
                entity.getPersistentData().putDouble("call", 200.0);
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    if (!world.getEntitiesOfClass(CorpseParrotEntity.class, AABB.ofSize(new Vec3(x, y, z), 64.0, 64.0, 64.0), ex -> true).isEmpty()) {
                        Vec3 _centerx = new Vec3(x, y, z);

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(32.0), ex -> true)
                            .stream()
                            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                            .toList()) {
                            if (entityiterator instanceof CorpseParrotEntity
                                && !((entityiterator instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)
                                && entityiterator instanceof Mob _entity
                                && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _ent) {
                                _entity.setTarget(_ent);
                            }
                        }
                    }
                } else if (!world.getEntitiesOfClass(CorpseParrotEntity.class, AABB.ofSize(new Vec3(x, y, z), 64.0, 64.0, 64.0), ex -> true).isEmpty()) {
                    Vec3 _centerx = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(32.0), ex -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof CorpseParrotEntity
                            && !((entityiterator instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)
                            && entityiterator instanceof Mob _entity) {
                            _entity.getNavigation().moveTo(x, y, z, 2.0);
                        }
                    }
                }
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
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.sing")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.sing")),
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
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.speech")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.speech")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if ((entity instanceof CorpseCaptainEntity animatable ? animatable.getTexture() : "null").equals("corpse_captain1")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof CorpseCaptainEntity animatable) {
                        animatable.setTexture("corpse_captain2");
                    }
                });
            } else if ((entity instanceof CorpseCaptainEntity animatable ? animatable.getTexture() : "null").equals("corpse_captain2")) {
                MoreCritters.queueServerWork(3, () -> {
                    if (entity instanceof CorpseCaptainEntity animatable) {
                        animatable.setTexture("corpse_captain3");
                    }
                });
            } else if ((entity instanceof CorpseCaptainEntity animatable ? animatable.getTexture() : "null").equals("corpse_captain3")) {
                MoreCritters.queueServerWork(3, () -> {
                    if (entity instanceof CorpseCaptainEntity animatable) {
                        animatable.setTexture("corpse_captain4");
                    }
                });
            } else if ((entity instanceof CorpseCaptainEntity animatable ? animatable.getTexture() : "null").equals("corpse_captain4")) {
                MoreCritters.queueServerWork(3, () -> {
                    if (entity instanceof CorpseCaptainEntity animatable) {
                        animatable.setTexture("corpse_captain5");
                    }
                });
            } else if ((entity instanceof CorpseCaptainEntity animatable ? animatable.getTexture() : "null").equals("corpse_captain5")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof CorpseCaptainEntity animatable) {
                        animatable.setTexture("corpse_captain1");
                    }
                });
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                if (!entity.getPersistentData().getBoolean("target")) {
                    if (entity instanceof CorpseCaptainEntity) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 30, false, false));
                        }

                        if (entity instanceof CorpseCaptainEntity) {
                            ((CorpseCaptainEntity)entity).setAnimation("alert");
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.alert")),
                                    SoundSource.HOSTILE,
                                    2.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.corpse_captain.alert")),
                                    SoundSource.HOSTILE,
                                    2.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, entity.getY() + entity.getBbHeight() + 1.0, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:alert"
                                );
                        }

                        MoreCritters.queueServerWork(
                            10,
                            () -> {
                                Vec3 _centerx = new Vec3(x, y, z);

                                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(50.0), ex -> true)
                                    .stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                    .toList()) {
                                    if ((
                                            entityiterator instanceof CorpseParrotEntity
                                                || entityiterator instanceof CorpseMateEntity
                                                || entityiterator instanceof CorpseQuartermasterEntity
                                                || entityiterator instanceof CorpseTankEntity
                                        )
                                        && entityiterator instanceof LivingEntity _liveEnt
                                        && (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null) != null
                                        && _liveEnt.hasLineOfSight(entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null)) {
                                        if (entityiterator instanceof Mob _entityxx
                                            && (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null) instanceof LivingEntity _entx) {
                                            _entityxx.setTarget(_entx);
                                        }

                                        if (entityiterator instanceof Mob _entityx) {
                                            _entityx.getNavigation().moveTo(x, y, z, 0.8);
                                        }

                                        if (world instanceof ServerLevel _level) {
                                            _level.getServer()
                                                .getCommands()
                                                .performPrefixedCommand(
                                                    new CommandSourceStack(
                                                            CommandSource.NULL,
                                                            new Vec3(
                                                                entityiterator.getX(),
                                                                entityiterator.getY() + entityiterator.getBbHeight() + 1.0,
                                                                entityiterator.getZ()
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
                                                    "/particle more_critters:alerted"
                                                );
                                        }
                                    }
                                }
                            }
                        );
                    }

                    entity.getPersistentData().putBoolean("target", true);
                }
            } else {
                entity.getPersistentData().putBoolean("target", false);
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
