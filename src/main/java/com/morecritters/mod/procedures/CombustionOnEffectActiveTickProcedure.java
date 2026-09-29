package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CombustionOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((
                    entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                        ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                        : 0
                )
                == 1) {
                if (!(new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.CREATIVE
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(entity)
                    && !(new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.SPECTATOR
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(entity)) {
                    if (world instanceof Level _level && !_level.isClientSide()) {
                        _level.explode(null, x, y, z, 4.0F, ExplosionInteraction.BLOCK);
                    }
                } else if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }

            if ((
                    entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                        ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                        : 0
                )
                <= 100) {
                if ((
                        entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                            ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                            : 0
                    )
                    > 20) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x, y + entity.getBbHeight() + 0.2, z),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:dust{color:[0.1,0.1,0.1],scale:1.5} ~ ~ ~ 0 0 0 1 1 force"
                            );
                    }
                } else if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight() + 0.2, z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:flame ~ ~ ~ 0 0 0 0 0 force"
                        );
                }
            }

            if ((
                    entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                        ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                        : 0
                )
                == 100) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            } else if ((
                    entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                        ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                        : 0
                )
                == 80) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.2F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.2F,
                            false
                        );
                    }
                }
            } else if ((
                    entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                        ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                        : 0
                )
                == 60) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.8F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.8F,
                            false
                        );
                    }
                }
            } else if ((
                    entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                        ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                        : 0
                )
                == 40) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            2.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_beep")),
                            SoundSource.PLAYERS,
                            1.0F,
                            2.0F,
                            false
                        );
                    }
                }
            } else if ((
                        entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.COMBUSTION)
                            ? _livEnt.getEffect(MoreCrittersModMobEffects.COMBUSTION).getDuration()
                            : 0
                    )
                    == 20
                && !world.isClientSide()
                && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_warning")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.combustion_warning")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F,
                        false
                    );
                }
            }
        }
    }
}
