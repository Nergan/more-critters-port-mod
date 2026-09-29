package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AvoiderEntity;
import com.morecritters.mod.entity.MightshroomEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class StunnedOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            if (entity.getPersistentData().getDouble("timer") == -1.0) {
                entity.getPersistentData().putDouble("timer", 40.0);
            }

            if (entity instanceof MightshroomEntity) {
                if (entity.getPersistentData().getBoolean("stun")) {
                    if (entity.getPersistentData().getDouble("timer") == 40.0) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:stun_star ~0.5 ~ ~ 0 0 0 0.02 1 force"
                                );
                        }
                    } else if (entity.getPersistentData().getDouble("timer") == 35.0) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:stun_star ~0.5 ~ ~0.5 0 0 0 0.02 1 force"
                                );
                        }
                    } else if (entity.getPersistentData().getDouble("timer") == 30.0) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:stun_star ~ ~ ~0.5 0 0 0 0.02 1 force"
                                );
                        }
                    } else if (entity.getPersistentData().getDouble("timer") == 25.0) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:stun_star ~-0.5 ~ ~0.5 0 0 0 0.02 1 force"
                                );
                        }
                    } else if (entity.getPersistentData().getDouble("timer") == 20.0) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:stun_star ~-0.5 ~ ~ 0 0 0 0.02 1 force"
                                );
                        }
                    } else if (entity.getPersistentData().getDouble("timer") == 15.0) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:stun_star ~-0.5 ~ ~-0.5 0 0 0 0.02 1 force"
                                );
                        }
                    } else if (entity.getPersistentData().getDouble("timer") == 10.0) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:stun_star ~ ~ ~-0.5 0 0 0 0.02 1 force"
                                );
                        }
                    } else if (entity.getPersistentData().getDouble("timer") == 5.0 && world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:stun_star ~0.5 ~ ~-0.5 0 0 0 0.02 1 force"
                            );
                    }
                }
            } else if (entity.getPersistentData().getDouble("timer") == 40.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:stun_star ~0.5 ~ ~ 0 0 0 0.02 1 force"
                        );
                }
            } else if (entity.getPersistentData().getDouble("timer") == 35.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:stun_star ~0.5 ~ ~0.5 0 0 0 0.02 1 force"
                        );
                }
            } else if (entity.getPersistentData().getDouble("timer") == 30.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:stun_star ~ ~ ~0.5 0 0 0 0.02 1 force"
                        );
                }
            } else if (entity.getPersistentData().getDouble("timer") == 25.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:stun_star ~-0.5 ~ ~0.5 0 0 0 0.02 1 force"
                        );
                }
            } else if (entity.getPersistentData().getDouble("timer") == 20.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:stun_star ~-0.5 ~ ~ 0 0 0 0.02 1 force"
                        );
                }
            } else if (entity.getPersistentData().getDouble("timer") == 15.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:stun_star ~-0.5 ~ ~-0.5 0 0 0 0.02 1 force"
                        );
                }
            } else if (entity.getPersistentData().getDouble("timer") == 10.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:stun_star ~ ~ ~-0.5 0 0 0 0.02 1 force"
                        );
                }
            } else if (entity.getPersistentData().getDouble("timer") == 5.0 && world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL,
                                new Vec3(x, y + entity.getBbHeight() + 0.5, z),
                                Vec2.ZERO,
                                _level,
                                4,
                                "",
                                Component.literal(""),
                                _level.getServer(),
                                null
                            )
                            .withSuppressedOutput(),
                        "/particle more_critters:stun_star ~0.5 ~ ~-0.5 0 0 0 0.02 1 force"
                    );
            }

            if (entity instanceof AvoiderEntity) {
                entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.02, entity.getLookAngle().y * 0.02, entity.getLookAngle().z * 0.02));
            }

            if (entity instanceof LivingEntity && !(entity instanceof AvoiderEntity) && !(entity instanceof MightshroomEntity)) {
                entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.02, entity.getLookAngle().y * 0.02, entity.getLookAngle().z * 0.02));
            }
        }
    }
}
