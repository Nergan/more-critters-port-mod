package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.ShriekbatEntity;
import com.morecritters.mod.entity.TesterShriekEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ShriekTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.AIR) {
                entity.setDeltaMovement(new Vec3(0.0, -0.4, 0.0));
            } else {
                entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }

            entity.lookAt(Anchor.EYES, new Vec3(x, y, z));
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            if (entity.getPersistentData().getDouble("timer") < 0.0 && !entity.level().isClientSide()) {
                entity.discard();
            }

            if (entity.getPersistentData().getDouble("timer") == 30.0 && entity instanceof TesterShriekEntity animatable) {
                animatable.setTexture("tester_shriek1");
            }

            if (entity.getPersistentData().getDouble("timer") == 20.0 && entity instanceof TesterShriekEntity animatable) {
                animatable.setTexture("tester_shriek2");
            }

            if (entity.getPersistentData().getDouble("timer") == 10.0 && entity instanceof TesterShriekEntity animatable) {
                animatable.setTexture("tester_shriek3");
            }

            if (!world.getEntitiesOfClass(ShriekbatEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true).isEmpty()) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
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
                        && !(entityiterator instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MoreCrittersModMobEffects.SHRIEK_RESISTANCE))
                        && entityiterator.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
                        entity.getPersistentData().putBoolean("alarm", true);
                    }
                }
            }

            if (entity.getPersistentData().getBoolean("alarm")) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof ShriekbatEntity
                        && entityiterator instanceof LivingEntity _liveEnt
                        && world.getEntitiesOfClass(ShriekbatEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                .stream()
                                .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }).compareDistOf(x, y, z))
                                .findFirst()
                                .orElse(null)
                            != null
                        && _liveEnt.hasLineOfSight(
                            world.getEntitiesOfClass(ShriekbatEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                                .stream()
                                .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }).compareDistOf(x, y, z))
                                .findFirst()
                                .orElse(null)
                        )) {
                        Entity var16 = world.getEntitiesOfClass(ShriekbatEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null);
                        if (var16 instanceof ShriekbatEntity _datEntSetL) {
                            _datEntSetL.getEntityData().set(ShriekbatEntity.DATA_agro, true);
                        }

                        world.getEntitiesOfClass(ShriekbatEntity.class, AABB.ofSize(new Vec3(x, y, z), 100.0, 100.0, 100.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null)
                            .getPersistentData()
                            .putDouble("agro", 600.0);
                    }
                }
            }
        }
    }
}
