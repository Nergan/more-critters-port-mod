package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.BalloonRatEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HallucinaziumOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double ratex = 0.0;
            double ratez = 0.0;
            double idlerate = 0.0;
            if (!(entity instanceof BalloonRatEntity)) {
                entity.getPersistentData().putDouble("jumpscare", entity.getPersistentData().getDouble("jumpscare") - 1.0);
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0, false, false));
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 10);
                if (rate == 1.0) {
                    for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 2.0, 5.0); index0++) {
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
                                    "/particle more_critters:pink_eye ~ ~ ~ 0.5 0.5 0.5 0.12 1 force"
                                );
                        }

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
                                    "/particle more_critters:pink_spiral ~ ~ ~ 0.2 0.2 0.2 0.05 1 force"
                                );
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("jumpscare") == 1.0) {
                    entity.getPersistentData().putDouble("jumpscare", 80.0);
                    if (entity instanceof Player) {
                        ratex = Mth.nextInt(RandomSource.create(), 1, 2);
                        ratez = Mth.nextInt(RandomSource.create(), 1, 2);
                        MoreCritters.queueServerWork(
                            40,
                            () -> {
                                entity.hurt(
                                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
                                    (float)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)
                                );
                                if (world instanceof Level _levelx) {
                                    if (!_levelx.isClientSide()) {
                                        _levelx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }
                            }
                        );
                        if (ratex == 1.0 && ratez == 1.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = MoreCrittersModEntities.PINK_MONSTER
                                    .get()
                                    .spawn(_level, BlockPos.containing(x + -2.0, y + entity.getBbHeight() + 1.0, z + -2.0), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        } else if (ratex == 1.0 && ratez == 2.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = MoreCrittersModEntities.PINK_MONSTER
                                    .get()
                                    .spawn(_level, BlockPos.containing(x + 2.0, y + entity.getBbHeight() + 1.0, z + -2.0), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        } else if (ratex == 2.0 && ratez == 1.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = MoreCrittersModEntities.PINK_MONSTER
                                    .get()
                                    .spawn(_level, BlockPos.containing(x + -2.0, y + entity.getBbHeight() + 1.0, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        } else if (ratex == 2.0 && ratez == 2.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = MoreCrittersModEntities.PINK_MONSTER
                                    .get()
                                    .spawn(_level, BlockPos.containing(x + 2.0, y + entity.getBbHeight() + 1.0, z + 2.0), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        }
                    } else if (!(entity instanceof Player)) {
                        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 10.0F);

                        for (int index1 = 0; index1 < 15; index1++) {
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
                                        "/particle more_critters:pink_eye ~ ~ ~ 0.5 0.5 0.5 0.12 1 force"
                                    );
                            }

                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.hallucinazium_monster.laugh")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        }
                    }
                }

                idlerate = Mth.nextInt(RandomSource.create(), 1, 10);
                if (idlerate == 1.0 && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.hallucinazium.idle")),
                            SoundSource.AMBIENT,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.hallucinazium.idle")),
                            SoundSource.AMBIENT,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }
        }
    }
}
