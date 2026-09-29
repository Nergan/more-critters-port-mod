package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ImminentDeathOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double rage = 0.0;
            double grumble = 0.0;
            rate = Mth.nextInt(RandomSource.create(), 1, 8);
            if (rate == 1.0) {
                if (entity instanceof Player _plr && _plr.getAbilities().instabuild) {
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
                                "/particle more_critters:mad_reaper ~ ~ ~ 0.5 0.5 0.5 0.01 1 force"
                            );
                    }

                    grumble = Mth.nextInt(RandomSource.create(), 1, 7);
                    if (grumble == 1.0 && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.reaper.grumble")),
                                SoundSource.AMBIENT,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.reaper.grumble")),
                                SoundSource.AMBIENT,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                } else {
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
                                "/particle more_critters:reaper ~ ~ ~ 0.5 0.5 0.5 0.01 1 force"
                            );
                    }

                    MoreCritters.queueServerWork(
                        5,
                        () -> {
                            if (world instanceof Level _levelx) {
                                if (!_levelx.isClientSide()) {
                                    _levelx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.reaper.ready")),
                                        SoundSource.AMBIENT,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.reaper.ready")),
                                        SoundSource.AMBIENT,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        }
                    );
                    MoreCritters.queueServerWork(
                        15,
                        () -> {
                            if (world instanceof Level _levelx) {
                                if (!_levelx.isClientSide()) {
                                    _levelx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.reaper.hit")),
                                        SoundSource.AMBIENT,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.reaper.hit")),
                                        SoundSource.AMBIENT,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            entity.hurt(
                                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                                (float)Mth.nextDouble(RandomSource.create(), 3.0, 6.0)
                            );
                        }
                    );
                }
            }
        }
    }
}
