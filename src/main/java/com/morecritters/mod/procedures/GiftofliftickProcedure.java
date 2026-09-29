package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GiftofliftickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            rate = Mth.nextInt(RandomSource.create(), 1, 8);
            if (rate == 1.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight(), z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:angel ~ ~ ~ 0.5 0.5 0.5 0.01 1 force"
                        );
                }

                MoreCritters.queueServerWork(
                    10,
                    () -> {
                        if (world instanceof Level _levelxx) {
                            if (!_levelxx.isClientSide()) {
                                _levelxx.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.angel.heal")),
                                    SoundSource.PLAYERS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _levelxx.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.angel.heal")),
                                    SoundSource.PLAYERS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (entity instanceof LivingEntity _entity) {
                            _entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) + Mth.nextInt(RandomSource.create(), 1, 3));
                        }

                        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 3.0, 6.0); index0++) {
                            if (world instanceof ServerLevel _levelx) {
                                _levelx.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(x, y + entity.getBbHeight(), z),
                                                Vec2.ZERO,
                                                _levelx,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _levelx.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle more_critters:heal_shimmer ~ ~ ~ 0.3 0.3 0.3 0.02 1 force"
                                    );
                            }
                        }
                    }
                );
            }
        }
    }
}
