package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WebSackProjectileProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(
                    (Player)null,
                    BlockPos.containing(x, y, z),
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.web_sack.hit")),
                    SoundSource.AMBIENT,
                    1.0F,
                    1.0F
                );
            } else {
                _level.playLocalSound(
                    x,
                    y,
                    z,
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.web_sack.hit")),
                    SoundSource.AMBIENT,
                    1.0F,
                    1.0F,
                    false
                );
            }
        }

        if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
            world.setBlock(BlockPos.containing(x, y + 1.0, z), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL, new Vec3(x, y + 1.0, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                            )
                            .withSuppressedOutput(),
                        "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                    );
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL, new Vec3(x, y + 1.0, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                            )
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                    );
            }
        }

        MoreCritters.queueServerWork(
            0,
            () -> {
                if (world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getBlock() == Blocks.AIR) {
                    world.setBlock(BlockPos.containing(x, y + 2.0, z), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
                    if (world instanceof ServerLevel _levelxx) {
                        _levelxx.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x, y + 2.0, z),
                                        Vec2.ZERO,
                                        _levelxx,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _levelxx.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                            );
                    }

                    if (world instanceof ServerLevel _levelx) {
                        _levelx.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x, y + 2.0, z),
                                        Vec2.ZERO,
                                        _levelx,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _levelx.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                            );
                    }
                }
            }
        );
        rate = Mth.nextInt(RandomSource.create(), 1, 2);
        if (rate == 1.0) {
            MoreCritters.queueServerWork(
                1,
                () -> {
                    if (world.getBlockState(BlockPos.containing(x, y + 1.0, z + 1.0)).getBlock() == Blocks.AIR) {
                        world.setBlock(BlockPos.containing(x, y + 1.0, z + 1.0), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
                        if (world instanceof ServerLevel _levelxx) {
                            _levelxx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + 1.0, z + 1.0),
                                            Vec2.ZERO,
                                            _levelxx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelxx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                                );
                        }

                        if (world instanceof ServerLevel _levelx) {
                            _levelx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + 1.0, z + 1.0),
                                            Vec2.ZERO,
                                            _levelx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                                );
                        }
                    }
                }
            );
        }

        if (rate == 2.0) {
            MoreCritters.queueServerWork(
                1,
                () -> {
                    if (world.getBlockState(BlockPos.containing(x, y + 1.0, z + -1.0)).getBlock() == Blocks.AIR) {
                        world.setBlock(BlockPos.containing(x, y + 1.0, z + -1.0), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
                        if (world instanceof ServerLevel _levelxx) {
                            _levelxx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + 1.0, z + -1.0),
                                            Vec2.ZERO,
                                            _levelxx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelxx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                                );
                        }

                        if (world instanceof ServerLevel _levelx) {
                            _levelx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + 1.0, z + -1.0),
                                            Vec2.ZERO,
                                            _levelx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                                );
                        }
                    }
                }
            );
        }

        rate = Mth.nextInt(RandomSource.create(), 1, 2);
        if (rate == 1.0) {
            MoreCritters.queueServerWork(
                1,
                () -> {
                    if (world.getBlockState(BlockPos.containing(x + 1.0, y + 2.0, z + -1.0)).getBlock() == Blocks.AIR) {
                        world.setBlock(BlockPos.containing(x + 1.0, y + 2.0, z + -1.0), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
                        if (world instanceof ServerLevel _levelxx) {
                            _levelxx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0, y + 2.0, z + -1.0),
                                            Vec2.ZERO,
                                            _levelxx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelxx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                                );
                        }

                        if (world instanceof ServerLevel _levelx) {
                            _levelx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0, y + 2.0, z + -1.0),
                                            Vec2.ZERO,
                                            _levelx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                                );
                        }
                    }
                }
            );
        }

        if (rate == 2.0) {
            MoreCritters.queueServerWork(
                1,
                () -> {
                    if (world.getBlockState(BlockPos.containing(x + -1.0, y + 2.0, z + -1.0)).getBlock() == Blocks.AIR) {
                        world.setBlock(BlockPos.containing(x + -1.0, y + 2.0, z + -1.0), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
                        if (world instanceof ServerLevel _levelxx) {
                            _levelxx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + -1.0, y + 2.0, z + -1.0),
                                            Vec2.ZERO,
                                            _levelxx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelxx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                                );
                        }

                        if (world instanceof ServerLevel _levelx) {
                            _levelx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + -1.0, y + 2.0, z + -1.0),
                                            Vec2.ZERO,
                                            _levelx,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _levelx.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                                );
                        }
                    }
                }
            );
        }
    }
}
