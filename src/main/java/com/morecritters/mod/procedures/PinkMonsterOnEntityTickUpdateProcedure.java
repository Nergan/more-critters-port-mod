package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class PinkMonsterOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            Entity index0 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (index0 instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MoreCrittersModMobEffects.HALLUCINAZIUM)) {
                entity.lookAt(
                    Anchor.EYES,
                    new Vec3(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getX(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z)).findFirst().orElse(null).getY()
                            + world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z)).findFirst().orElse(null).getBbHeight(),
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getZ()
                    )
                );
                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z)).findFirst().orElse(null).lookAt(Anchor.EYES, new Vec3(x, y + entity.getBbHeight(), z));
                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z)).findFirst().orElse(null).setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            } else {
                index0 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8.0, 8.0, 8.0), e -> true).stream().sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z)).findFirst().orElse(null);
                if (!(index0 instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MoreCrittersModMobEffects.HALLUCINAZIUM))) {
                    for (int index0x = 0; index0x < 15; index0x++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:pink_eye ~ ~ ~ 0.5 0.5 0.5 0.12 1 force"
                                );
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }
                }
            }

            if (entity.getPersistentData().getDouble("timer") == 1.0) {
                for (int index1 = 0; index1 < 15; index1++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:pink_eye ~ ~ ~ 0.5 0.5 0.5 0.12 1 force"
                            );
                    }
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            }
        }
    }
}
