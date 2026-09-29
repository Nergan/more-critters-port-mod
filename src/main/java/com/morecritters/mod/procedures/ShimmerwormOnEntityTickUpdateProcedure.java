package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ShimmerwormOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double shimmer = 0.0;
            entity.getPersistentData().putDouble("age", entity.getPersistentData().getDouble("age") - 1.0);
            if (1.0 == entity.getPersistentData().getDouble("age")) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.SHIMMERWING.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setXRot(entity.getXRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            }

            if (entity.isInWaterRainOrBubble()) {
                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:portal ~ ~ ~ 0.2 0.2 0.2 0.1 5 normal"
                        );
                }

                Entity _ent = entity;
                _ent.teleportTo(
                    x + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                    y + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                    z + Mth.nextDouble(RandomSource.create(), -10.0, 10.0)
                );
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection
                        .teleport(
                            x + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                            y + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                            z + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                            _ent.getYRot(),
                            _ent.getXRot()
                        );
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }

            if (entity.isInWall()) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:portal ~ ~ ~ 0.2 0.2 0.2 0.1 5 normal"
                        );
                }

                Entity _ent = entity;
                _ent.teleportTo(
                    x + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                    y + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                    z + Mth.nextDouble(RandomSource.create(), -10.0, 10.0)
                );
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection
                        .teleport(
                            x + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                            y + Mth.nextDouble(RandomSource.create(), 0.0, 2.0),
                            z + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                            _ent.getYRot(),
                            _ent.getXRot()
                        );
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")),
                            SoundSource.NEUTRAL,
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
