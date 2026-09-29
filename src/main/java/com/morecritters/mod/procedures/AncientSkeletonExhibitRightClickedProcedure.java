package com.morecritters.mod.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AncientSkeletonExhibitRightClickedProcedure {
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
                            "/summon more_critters:ancient_skeleton_exhibit"
                        );
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
                            "/summon more_critters:ancient_skeleton_exhibit"
                        );
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
                            "/summon more_critters:ancient_skeleton_exhibit"
                        );
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
                            "/summon more_critters:ancient_skeleton_exhibit"
                        );
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
                            "/summon more_critters:ancient_skeleton_exhibit"
                        );
                }
            } else if (direction == Direction.EAST && world instanceof ServerLevel _level) {
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
                        "/summon more_critters:ancient_skeleton_exhibit"
                    );
            }
        }
    }
}
