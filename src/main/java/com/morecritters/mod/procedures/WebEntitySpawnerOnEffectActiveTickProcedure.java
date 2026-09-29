package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WebEntitySpawnerOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (!world.getEntitiesOfClass(WebEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).isEmpty()) {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                CommandSource.NULL,
                                _ent.position(),
                                _ent.getRotationVector(),
                                _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null,
                                4,
                                _ent.getName().getString(),
                                _ent.getDisplayName(),
                                _ent.level().getServer(),
                                _ent
                            ),
                            "/data merge entity @s {NoAI:1}"
                        );
                }

                _ent = entity;
                _ent.teleportTo(
                    world.getEntitiesOfClass(WebEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                    world.getEntitiesOfClass(WebEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z)).findFirst().orElse(null).getY(),
                    world.getEntitiesOfClass(WebEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                );
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection
                        .teleport(
                            world.getEntitiesOfClass(WebEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true)
                                .stream()
                                .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }).compareDistOf(x, y, z))
                                .findFirst()
                                .orElse(null)
                                .getX(),
                            world.getEntitiesOfClass(WebEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true)
                                .stream()
                                .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }).compareDistOf(x, y, z))
                                .findFirst()
                                .orElse(null)
                                .getY(),
                            world.getEntitiesOfClass(WebEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true)
                                .stream()
                                .sorted((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }).compareDistOf(x, y, z))
                                .findFirst()
                                .orElse(null)
                                .getZ(),
                            _ent.getYRot(),
                            _ent.getXRot()
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 50, false, false));
                }
            } else {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                CommandSource.NULL,
                                _ent.position(),
                                _ent.getRotationVector(),
                                _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null,
                                4,
                                _ent.getName().getString(),
                                _ent.getDisplayName(),
                                _ent.level().getServer(),
                                _ent
                            ),
                            "/data merge entity @s {NoAI:0}"
                        );
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.WEBBED);
                }
            }
        }
    }
}
