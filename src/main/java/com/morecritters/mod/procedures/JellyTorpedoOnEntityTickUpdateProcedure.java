package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.JellyTorpedoEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class JellyTorpedoOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.isInWaterOrBubble()) {
                entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.6, entity.getLookAngle().y * 0.6, entity.getLookAngle().z * 0.6));
                if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
                    for (int index0 = 0; index0 < 3; index0++) {
                        MoreCritters.queueServerWork(
                            5,
                            () -> {
                                if (world instanceof ServerLevel _levelx) {
                                    _levelx.getServer()
                                        .getCommands()
                                        .performPrefixedCommand(
                                            new CommandSourceStack(
                                                    CommandSource.NULL,
                                                    new Vec3(x, y, z),
                                                    Vec2.ZERO,
                                                    _levelx,
                                                    4,
                                                    "",
                                                    Component.literal(""),
                                                    _levelx.getServer(),
                                                    null
                                                )
                                                .withSuppressedOutput(),
                                            "/particle minecraft:bubble ~ ~0.2 ~ 0.1 0.1 0.1 0.1 1 force"
                                        );
                                }
                            }
                        );
                    }

                    if (entity.getPersistentData().getBoolean("explode")) {
                        Vec3 _center = new Vec3(x, y, z);

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5), e -> true)
                            .stream()
                            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                            .toList()) {
                            if (entityiterator instanceof LivingEntity
                                && !(entityiterator instanceof JellyTorpedoEntity)
                                && !(entityiterator instanceof Player _plr && _plr.getAbilities().instabuild)) {
                                if (!entity.level().isClientSide()) {
                                    entity.discard();
                                }

                                if (world instanceof Level _level && !_level.isClientSide()) {
                                    _level.explode(null, x, y, z, 2.0F, ExplosionInteraction.MOB);
                                }

                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.jelly_torpedo.explode")),
                                            SoundSource.BLOCKS,
                                            2.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.jelly_torpedo.explode")),
                                            SoundSource.BLOCKS,
                                            2.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }
                            }
                        }
                    }
                }

                if ((
                        world.getBlockState(BlockPos.containing(x + 0.5, y, z)).canOcclude()
                            || world.getBlockState(BlockPos.containing(x - 0.5, y, z)).canOcclude()
                            || world.getBlockState(BlockPos.containing(x, y, z + 0.5)).canOcclude()
                            || world.getBlockState(BlockPos.containing(x, y, z - 0.5)).canOcclude()
                    )
                    && entity.getPersistentData().getBoolean("explode")) {
                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.jelly_torpedo.explode")),
                                SoundSource.BLOCKS,
                                2.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.jelly_torpedo.explode")),
                                SoundSource.BLOCKS,
                                2.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (world instanceof Level _level && !_level.isClientSide()) {
                        _level.explode(null, x, y, z, 2.0F, ExplosionInteraction.MOB);
                    }
                }
            } else {
                for (int index1 = 0; index1 < 3; index1++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:explosive_jelly\"} ~ ~ ~ 0.5 0.5 0.5 0 3 force"
                            );
                    }
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            }
        }
    }
}
