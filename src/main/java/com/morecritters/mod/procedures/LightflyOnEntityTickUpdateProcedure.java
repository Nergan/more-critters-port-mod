package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.LightflyEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class LightflyOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof LightflyEntity _datEntL0
                && _datEntL0.getEntityData().get(LightflyEntity.DATA_targeting)
                && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                entity.getPersistentData().putDouble("speed", entity.getPersistentData().getDouble("speed") + 0.03);
                entity.lookAt(
                    Anchor.EYES,
                    new Vec3(
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY(),
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                    )
                );
                entity.setDeltaMovement(
                    new Vec3(
                        entity.getLookAngle().x * entity.getPersistentData().getDouble("speed"),
                        entity.getLookAngle().y * entity.getPersistentData().getDouble("speed"),
                        entity.getLookAngle().z * entity.getPersistentData().getDouble("speed")
                    )
                );
                MoreCritters.queueServerWork(
                    3,
                    () -> {
                        if (world instanceof ServerLevel _levelx) {
                            _levelx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~1 ~ 0 0 0 0.01 1 force"
                                );
                        }
                    }
                );
            }

            MoreCritters.queueServerWork(
                3,
                () -> {
                    if (world instanceof ServerLevel _levelx) {
                        _levelx.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:wax_off ~ ~ ~ 0 0 0 1 1 force"
                            );
                    }

                    MoreCritters.queueServerWork(
                        2,
                        () -> {
                            if (world instanceof ServerLevel _levelxx) {
                                _levelxx.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(x, y, z),
                                                Vec2.ZERO,
                                                _levelxx,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _levelxx.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:wax_off ~ ~ ~ 0 0 0 1 1 force"
                                    );
                            }

                            MoreCritters.queueServerWork(
                                2,
                                () -> {
                                    if (world instanceof ServerLevel _levelxxx) {
                                        _levelxxx.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(x, y, z),
                                                        Vec2.ZERO,
                                                        _levelxxx,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _levelxxx.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle minecraft:wax_off ~ ~ ~ 0 0 0 1 1 force"
                                            );
                                    }
                                }
                            );
                        }
                    );
                }
            );
            entity.getPersistentData().putDouble("life", entity.getPersistentData().getDouble("life") + 1.0);
            if (entity.getPersistentData().getDouble("life") == 100.0) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:wax_off ~ ~ ~ 0 0 0 1 1 force"
                        );
                }
            }
        }
    }
}
