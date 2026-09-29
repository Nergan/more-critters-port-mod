package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.GravediggerEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GravediggerOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double monsterx = 0.0;
            double monstery = 0.0;
            double monsterz = 0.0;
            double random = 0.0;
            double rarity2 = 0.0;
            double disc = 0.0;
            double rarity = 0.0;
            if (entity instanceof GravediggerEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(
                        GravediggerEntity.DATA_dig,
                        (entity instanceof GravediggerEntity _datEntI ? _datEntI.getEntityData().get(GravediggerEntity.DATA_dig) : 0) - 1
                    );
            }

            entity.getPersistentData().putDouble("wait", entity.getPersistentData().getDouble("wait") - 1.0);
            entity.getPersistentData().putDouble("growl", entity.getPersistentData().getDouble("growl") - 1.0);
            if (entity.getPersistentData().getDouble("growl") <= 0.0) {
                entity.getPersistentData().putDouble("growl", Mth.nextDouble(RandomSource.create(), 100.0, 200.0));
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof Player
                        && entity instanceof LivingEntity _liveEnt
                        && entityiterator != null
                        && _liveEnt.hasLineOfSight(entityiterator)
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
                        && !world.isClientSide()
                        && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.gravedigger.growl")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.gravedigger.growl")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if ((entity instanceof GravediggerEntity _datEntI ? _datEntI.getEntityData().get(GravediggerEntity.DATA_dig) : 0) <= 0) {
                if (entity instanceof GravediggerEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(GravediggerEntity.DATA_dig, 100);
                }

                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof Player
                        && entity instanceof LivingEntity _liveEnt
                        && entityiterator != null
                        && _liveEnt.hasLineOfSight(entityiterator)
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
                        && entity.onGround()) {
                        if (entity instanceof GravediggerEntity) {
                            ((GravediggerEntity)entity).setAnimation("dig_down");
                        }

                        entity.getPersistentData().putDouble("wait", 40.0);
                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.gravedigger.dig_down")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.gravedigger.dig_down")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    }
                }
            }

            if (((GravediggerEntity)entity).animationprocedure.equals("dig_down")) {
                entity.setDeltaMovement(new Vec3(0.0, -2.0, 0.0));
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:block{block_state:\"XXX\"} ~ ~ ~ 0.2 0 0.2 1 3 force"
                                .replace("XXX", BuiltInRegistries.BLOCK.getKey(world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock()).toString())
                        );
                }
            }

            if (entity.getPersistentData().getDouble("wait") == 0.0) {
                if (entity instanceof GravediggerEntity) {
                    ((GravediggerEntity)entity).setAnimation("dig_up");
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.gravedigger.dig_up")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.gravedigger.dig_up")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                rarity = Mth.nextInt(RandomSource.create(), 1, 5);
                if (rarity == 1.0) {
                    rarity2 = Mth.nextInt(RandomSource.create(), 1, 3);
                    if (rarity2 == 1.0) {
                        if (world instanceof ServerLevel _level) {
                            Entity entityToSpawn = MoreCrittersModEntities.AMALGAM
                                .get()
                                .spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                            }
                        }
                    } else {
                        random = Mth.nextInt(RandomSource.create(), 1, 2);
                        if (random == 1.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.ZOMBIE_VILLAGER.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                }
                            }
                        } else if (random == 2.0 && world instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                            }
                        }
                    }
                } else {
                    random = Mth.nextInt(RandomSource.create(), 1, 4);
                    if (random == 1.0) {
                        disc = Mth.nextInt(RandomSource.create(), 1, 50);
                        if (disc == 1.0) {
                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(x, y, z),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/summon zombie ~0.5 ~-1 ~0.5 {HandItems:[{id:\"more_critters:music_disc_waddle\",count:1},{}],HandDropChances:[1f,0f]}"
                                    );
                            }

                            world.getEntitiesOfClass(Zombie.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).stream().sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z)).findFirst().orElse(null).setDeltaMovement(new Vec3(0.0, 0.7, 0.0));
                        } else if (world instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                            }
                        }
                    } else if (random == 2.0) {
                        if (world instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                            }
                        }
                    } else if (random == 3.0) {
                        if (world instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.5, 0.0);
                            }
                        }
                    } else if (random == 4.0 && world instanceof ServerLevel _level) {
                        Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.5, 0.0);
                        }
                    }
                }

                MoreCritters.queueServerWork(30, () -> {
                    if (entity instanceof GravediggerEntity) {
                        ((GravediggerEntity)entity).setAnimation("reset");
                    }
                });
            }
        }
    }
}
