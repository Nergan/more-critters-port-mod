package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class EvolightenedOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        boolean found = false;
        double rate = 0.0;
        double sx = 0.0;
        double sy = 0.0;
        double sz = 0.0;
        double epic_particle = 0.0;
        epic_particle = Mth.nextInt(RandomSource.create(), 1, 30);
        if (epic_particle == 1.0) {
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle more_critters:evolightened_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
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
                                "/particle more_critters:evolightened_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
                            );
                    }

                    MoreCritters.queueServerWork(
                        3,
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
                                        "/particle more_critters:evolightened_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
                                    );
                            }

                            MoreCritters.queueServerWork(
                                3,
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
                                                "/particle more_critters:evolightened_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
                                            );
                                    }
                                }
                            );
                        }
                    );
                }
            );
        }
    }
}
