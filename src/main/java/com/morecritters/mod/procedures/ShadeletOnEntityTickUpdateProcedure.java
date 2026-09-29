package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.ShadeletEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ShadeletOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (entity instanceof ShadeletEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(
                        ShadeletEntity.DATA_sugarrush,
                        (entity instanceof ShadeletEntity _datEntI ? _datEntI.getEntityData().get(ShadeletEntity.DATA_sugarrush) : 0) - 1
                    );
            }

            entity.getPersistentData().putDouble("spook", entity.getPersistentData().getDouble("spook") - 1.0);
            entity.getPersistentData().putDouble("run", entity.getPersistentData().getDouble("run") - 1.0);
            if (!entity.getDisplayName().getString().equals("Lolipop") && !entity.getDisplayName().getString().equals("lolipop")) {
                if (entity instanceof ShadeletEntity animatable) {
                    animatable.setTexture("shadelet");
                }
            } else if (entity instanceof ShadeletEntity animatable) {
                animatable.setTexture("shadelet_lolipop");
            }

            if ((entity instanceof ShadeletEntity _datEntI ? _datEntI.getEntityData().get(ShadeletEntity.DATA_sugarrush) : 0) > 0) {
                if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
                    entity.setSprinting(true);
                    rate = Mth.nextInt(RandomSource.create(), 1, 5);
                    if (rate == 1.0 && world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:falling_water ~ ~1 ~ 0.1 0.1 0.1 25 1 force"
                            );
                    }

                    if (((ShadeletEntity)entity).animationprocedure.equals("idle_shiver") && entity instanceof ShadeletEntity) {
                        ((ShadeletEntity)entity).setAnimation("anim_reset");
                    }
                } else {
                    entity.setSprinting(false);
                    if (!((ShadeletEntity)entity).animationprocedure.equals("scream") && entity instanceof ShadeletEntity) {
                        ((ShadeletEntity)entity).setAnimation("idle_shiver");
                    }
                }
            } else {
                entity.setSprinting(false);
            }

            if (entity.getPersistentData().getDouble("spook") < -1.0) {
                if (((ShadeletEntity)entity).animationprocedure.equals("idle_shiver") && entity instanceof ShadeletEntity) {
                    ((ShadeletEntity)entity).setAnimation("anim_reset");
                }

                if ((entity instanceof ShadeletEntity _datEntI ? _datEntI.getEntityData().get(ShadeletEntity.DATA_sugarrush) : 0) > 0) {
                    entity.getPersistentData().putDouble("spook", 60.0);
                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof Monster
                            && !(entityiterator instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(MoreCrittersModMobEffects.SPOOKED))) {
                            if (entity instanceof ShadeletEntity _datEntSetL) {
                                _datEntSetL.getEntityData().set(ShadeletEntity.DATA_chasing, true);
                            }

                            entity.setSprinting(true);
                        }
                    }
                } else {
                    entity.getPersistentData().putDouble("spook", Mth.nextInt(RandomSource.create(), 200, 400));
                    if (ServerConfig.CONFIG.shadeletJumpscare.get()) {
                        Vec3 _center = new Vec3(x, y, z);

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
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
                                                        && Minecraft.getInstance()
                                                                .getConnection()
                                                                .getPlayerInfo(_player.getGameProfile().getId())
                                                                .getGameMode()
                                                            == GameType.CREATIVE
                                                    : false;
                                            }
                                        }
                                    })
                                    .checkGamemode(entity)
                                && !(new Object() {
                                        public boolean checkGamemode(Entity _ent) {
                                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                            } else {
                                                return _ent.level().isClientSide() && _ent instanceof Player _player
                                                    ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                        && Minecraft.getInstance()
                                                                .getConnection()
                                                                .getPlayerInfo(_player.getGameProfile().getId())
                                                                .getGameMode()
                                                            == GameType.SPECTATOR
                                                    : false;
                                            }
                                        }
                                    })
                                    .checkGamemode(entity)
                                && !(entityiterator instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(MoreCrittersModMobEffects.SPOOKED))) {
                                if (entity instanceof ShadeletEntity _datEntSetL) {
                                    _datEntSetL.getEntityData().set(ShadeletEntity.DATA_chasing, true);
                                }

                                entity.setSprinting(true);
                            }
                        }
                    }
                }
            }

            if (entity instanceof ShadeletEntity _datEntL41 && _datEntL41.getEntityData().get(ShadeletEntity.DATA_chasing)) {
                if ((entity instanceof ShadeletEntity _datEntI ? _datEntI.getEntityData().get(ShadeletEntity.DATA_sugarrush) : 0) > 0) {
                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof Monster
                            && !(entityiterator instanceof LivingEntity _livEnt44 && _livEnt44.hasEffect(MoreCrittersModMobEffects.SPOOKED))) {
                            Entity _datEntSetL = world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                .stream()
                                .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }).compareDistOf(x, y, z))
                                .findFirst()
                                .orElse(null);
                            if (!(_datEntSetL instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(MoreCrittersModMobEffects.SPOOKED))
                                && entity instanceof Mob _entity) {
                                _entity.getNavigation()
                                    .moveTo(
                                        world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                            .stream()
                                            .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                            }).compareDistOf(x, y, z))
                                            .findFirst()
                                            .orElse(null)
                                            .getX(),
                                        world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                            .stream()
                                            .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                            }).compareDistOf(x, y, z))
                                            .findFirst()
                                            .orElse(null)
                                            .getY(),
                                        world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                            .stream()
                                            .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                            }).compareDistOf(x, y, z))
                                            .findFirst()
                                            .orElse(null)
                                            .getZ(),
                                        1.0
                                    );
                            }

                            if ((
                                    (Entity)world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                                .stream()
                                                .sorted((new Object() {
                                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                    }
                                                }).compareDistOf(x, y, z))
                                                .findFirst()
                                                .orElse(null)
                                            != null
                                        ? entity.distanceTo(
                                            world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                                .stream()
                                                .sorted((new Object() {
                                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                    }
                                                }).compareDistOf(x, y, z))
                                                .findFirst()
                                                .orElse(null)
                                        )
                                        : -1.0F
                                )
                                < 2.0F) {
                                _datEntSetL = world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3(x, y, z), 30.0, 30.0, 30.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                        }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null);
                                if (!(_datEntSetL instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(MoreCrittersModMobEffects.SPOOKED))) {
                                    if (entity instanceof ShadeletEntity) {
                                        ((ShadeletEntity)entity).setAnimation("scream");
                                    }

                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 49, false, false));
                                    }

                                    if (world instanceof Level _level) {
                                        if (!_level.isClientSide()) {
                                            _level.playSound(
                                                (Player)null,
                                                BlockPos.containing(x, y, z),
                                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shadelet.scream")),
                                                SoundSource.NEUTRAL,
                                                1.0F,
                                                1.0F
                                            );
                                        } else {
                                            _level.playLocalSound(
                                                x,
                                                y,
                                                z,
                                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shadelet.scream")),
                                                SoundSource.NEUTRAL,
                                                1.0F,
                                                1.0F,
                                                false
                                            );
                                        }
                                    }

                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.SPOOKED, 100, 0, false, true));
                                    }

                                    entity.lookAt(
                                        Anchor.EYES,
                                        new Vec3(entityiterator.getX(), entityiterator.getY() + entityiterator.getBbHeight(), entityiterator.getZ())
                                    );
                                    entity.getPersistentData().putDouble("run", 40.0);
                                    entity.setSprinting(false);
                                    if (entity instanceof ShadeletEntity _datEntSetLx) {
                                        _datEntSetLx.getEntityData().set(ShadeletEntity.DATA_chasing, false);
                                    }
                                }
                            }
                        }
                    }
                } else if (ServerConfig.CONFIG.shadeletJumpscare.get()) {
                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
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
                                .checkGamemode(entity)
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
                                .checkGamemode(entity)
                            && !(entityiterator instanceof LivingEntity _livEnt75 && _livEnt75.hasEffect(MoreCrittersModMobEffects.SPOOKED))) {
                            if (entity instanceof Mob _entity) {
                                _entity.getNavigation().moveTo(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 1.5);
                            }

                            if ((entityiterator != null ? entity.distanceTo(entityiterator) : -1.0F) < 2.0F) {
                                if (entity instanceof ShadeletEntity) {
                                    ((ShadeletEntity)entity).setAnimation("scream");
                                }

                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 49, false, false));
                                }

                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shadelet.scream")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shadelet.scream")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.SPOOKED, 100, 0, false, true));
                                }

                                entity.lookAt(
                                    Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + entityiterator.getBbHeight(), entityiterator.getZ())
                                );
                                entity.getPersistentData().putDouble("run", 40.0);
                                entity.setSprinting(false);
                                if (entity instanceof ShadeletEntity _datEntSetL) {
                                    _datEntSetL.getEntityData().set(ShadeletEntity.DATA_chasing, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
