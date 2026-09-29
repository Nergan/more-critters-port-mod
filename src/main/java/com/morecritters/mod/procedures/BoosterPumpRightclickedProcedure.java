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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BoosterPumpRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity != null) {
            if (entity.isInWaterOrBubble()) {
                if (entity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
                }

                ItemStack _ist = itemstack;
                if (world instanceof ServerLevel _serverLevel) {
                    _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                }

                entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * -2.0, entity.getLookAngle().y * -2.0, entity.getLookAngle().z * -2.0));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 2, false, false));
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.booster_pump.underwater")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.booster_pump.underwater")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:dash ~ ~ ~ 0 0 0 0 1 force"
                        );
                }

                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 6.0, 10.0); index0++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:bubble ~ ~ ~ 0.3 0.3 0.3 0.02 1 force"
                            );
                    }

                    MoreCritters.queueServerWork(
                        1,
                        () -> {
                            if (world instanceof ServerLevel _levelx) {
                                _levelx.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                                Vec2.ZERO,
                                                _levelx,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _levelx.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:bubble ~ ~ ~ 0.3 0.3 0.3 0.02 1 force"
                                    );
                            }

                            MoreCritters.queueServerWork(
                                1,
                                () -> {
                                    if (world instanceof ServerLevel _levelxx) {
                                        _levelxx.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                                        Vec2.ZERO,
                                                        _levelxx,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _levelxx.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle minecraft:bubble ~ ~ ~ 0.3 0.3 0.3 0.02 1 force"
                                            );
                                    }

                                    MoreCritters.queueServerWork(
                                        1,
                                        () -> {
                                            if (world instanceof ServerLevel _levelxxx) {
                                                _levelxxx.getServer()
                                                    .getCommands()
                                                    .performPrefixedCommand(
                                                        new CommandSourceStack(
                                                                CommandSource.NULL,
                                                                new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                                                Vec2.ZERO,
                                                                _levelxxx,
                                                                4,
                                                                "",
                                                                Component.literal(""),
                                                                _levelxxx.getServer(),
                                                                null
                                                            )
                                                            .withSuppressedOutput(),
                                                        "/particle minecraft:bubble ~ ~ ~ 0.3 0.3 0.3 0.02 1 force"
                                                    );
                                            }

                                            MoreCritters.queueServerWork(
                                                1,
                                                () -> {
                                                    if (world instanceof ServerLevel _levelxxxx) {
                                                        _levelxxxx.getServer()
                                                            .getCommands()
                                                            .performPrefixedCommand(
                                                                new CommandSourceStack(
                                                                        CommandSource.NULL,
                                                                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                                                        Vec2.ZERO,
                                                                        _levelxxxx,
                                                                        4,
                                                                        "",
                                                                        Component.literal(""),
                                                                        _levelxxxx.getServer(),
                                                                        null
                                                                    )
                                                                    .withSuppressedOutput(),
                                                                "/particle minecraft:bubble ~ ~ ~ 0.3 0.3 0.3 0.02 1 force"
                                                            );
                                                    }
                                                }
                                            );
                                        }
                                    );
                                }
                            );
                        }
                    );
                }
            } else if (entity instanceof LivingEntity _livEnt40 && _livEnt40.isFallFlying()) {
                if (entity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 200);
                }

                ItemStack _ist = itemstack;
                if (world instanceof ServerLevel _serverLevel) {
                    _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:dash ~ ~ ~ 0 0 0 0 1 force"
                        );
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.booster_pump.land")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.booster_pump.land")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 1.0, 1.0, entity.getDeltaMovement().z() * 1.0));
            } else {
                if (entity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 50);
                }

                ItemStack _ist = itemstack;
                if (world instanceof ServerLevel _serverLevel) {
                    _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:dash ~ ~ ~ 0 0 0 0 1 force"
                        );
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.booster_pump.land")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.booster_pump.land")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 3.0, 1.0, entity.getDeltaMovement().z() * 3.0));
            }
        }
    }
}
