package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SoulRumProjectileProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        rate = Mth.nextInt(RandomSource.create(), 1, 3);
        if (rate == 1.0) {
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:cloud ~0.5 ~1 ~0.5 0.5 0 0.5 0.02 10 force"
                    );
            }

            for (int index0 = 0; index0 < 20; index0++) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(
                                        x + Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                                        y + Mth.nextDouble(RandomSource.create(), 1.0, 2.0),
                                        z + Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
                                    ),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:entity_effect{color:[0.91,0.57,0.75,1.0]} ~0.5 ~1 ~0.5 0.91 0.57 0.75 1 0"
                        );
                }
            }

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_MATE
                    .get()
                    .spawn(_level, BlockPos.containing(x + 0.5, y + 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }
        } else if (rate == 2.0) {
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:cloud ~0.5 ~1 ~0.5 0.5 0 0.5 0.02 10 force"
                    );
            }

            for (int index1 = 0; index1 < 20; index1++) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(
                                        x + Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                                        y + Mth.nextDouble(RandomSource.create(), 1.0, 2.0),
                                        z + Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
                                    ),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:entity_effect{color:[0.91,0.57,0.75,1.0]} ~0.5 ~1 ~0.5 0.91 0.57 0.75 1 0"
                        );
                }
            }

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_QUARTERMASTER
                    .get()
                    .spawn(_level, BlockPos.containing(x + 0.5, y + 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }
        } else if (rate == 3.0) {
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:cloud ~0.5 ~1 ~0.5 0.5 0 0.5 0.02 10 force"
                    );
            }

            for (int index2 = 0; index2 < 20; index2++) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(
                                        x + Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
                                        y + Mth.nextDouble(RandomSource.create(), 1.0, 2.0),
                                        z + Mth.nextDouble(RandomSource.create(), -1.0, 1.0)
                                    ),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:entity_effect{color:[0.91,0.57,0.75,1.0]} ~0.5 ~1 ~0.5 0.91 0.57 0.75 1 0"
                        );
                }
            }

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK
                    .get()
                    .spawn(_level, BlockPos.containing(x + 0.5, y + 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }
        }

        if (!world.isClientSide() && world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(
                    (Player)null,
                    BlockPos.containing(x, y, z),
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.soul_rum.break")),
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F
                );
            } else {
                _level.playLocalSound(
                    x,
                    y,
                    z,
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.soul_rum.break")),
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F,
                    false
                );
            }
        }
    }
}
