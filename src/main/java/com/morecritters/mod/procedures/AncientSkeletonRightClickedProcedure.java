package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AncientSkeletonRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, ItemStack itemstack) {
        if (direction != null) {
            itemstack.shrink(1);
            if (direction == Direction.UP) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y + 1.0, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:ancient_skeleton"
                        );
                }

                Entity var10 = world.getEntitiesOfClass(AncientSkeletonEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if (var10 instanceof AncientSkeletonEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(AncientSkeletonEntity.DATA_set, true);
                }
            } else if (direction == Direction.DOWN) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y - 1.0, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:ancient_skeleton"
                        );
                }

                Entity var22 = world.getEntitiesOfClass(AncientSkeletonEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if (var22 instanceof AncientSkeletonEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(AncientSkeletonEntity.DATA_set, true);
                }
            } else if (direction == Direction.NORTH) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y - 0.0, z - 1.0),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:ancient_skeleton"
                        );
                }

                Entity var23 = world.getEntitiesOfClass(AncientSkeletonEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if (var23 instanceof AncientSkeletonEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(AncientSkeletonEntity.DATA_set, true);
                }
            } else if (direction == Direction.SOUTH) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y - 0.0, z + 1.0),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:ancient_skeleton"
                        );
                }

                Entity var24 = world.getEntitiesOfClass(AncientSkeletonEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if (var24 instanceof AncientSkeletonEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(AncientSkeletonEntity.DATA_set, true);
                }
            } else if (direction == Direction.WEST) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x - 1.0, y - 0.0, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:ancient_skeleton"
                        );
                }

                Entity var25 = world.getEntitiesOfClass(AncientSkeletonEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if (var25 instanceof AncientSkeletonEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(AncientSkeletonEntity.DATA_set, true);
                }
            } else if (direction == Direction.EAST) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 1.5, y - 0.0, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:ancient_skeleton"
                        );
                }

                Entity var26 = world.getEntitiesOfClass(AncientSkeletonEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if (var26 instanceof AncientSkeletonEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(AncientSkeletonEntity.DATA_set, true);
                }
            }
        }
    }
}
