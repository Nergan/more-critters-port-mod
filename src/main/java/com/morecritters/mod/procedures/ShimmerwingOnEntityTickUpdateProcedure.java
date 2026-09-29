package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.ShimmerwingEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ShimmerwingOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double shimmer = 0.0;
            double rate = 0.0;
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (!(entityiterator instanceof ShimmerwingEntity)
                    && entityiterator instanceof LivingEntity _livEnt1
                    && _livEnt1.hasEffect(MoreCrittersModMobEffects.ENDS_BLESSING)
                    && !(entity.getPersistentData().getDouble("teleport") > 1.0)
                    && (Boolean)ServerConfig.CONFIG.shimmerwingFollow.get()
                    && entity instanceof Mob _entity) {
                    _entity.getNavigation().moveTo(entityiterator.getX(), entityiterator.getY() + 2.0, entityiterator.getZ(), 1.0);
                }
            }

            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            entity.getPersistentData().putDouble("eat", entity.getPersistentData().getDouble("eat") - 1.0);
            entity.getPersistentData().putDouble("teleport", entity.getPersistentData().getDouble("teleport") - 1.0);
            if (entity.getPersistentData().getDouble("timer") == 1.0) {
                entity.getPersistentData().putDouble("timer", Mth.nextInt(RandomSource.create(), 100, 300));
                if (entity.onGround()) {
                    if (entity instanceof ShimmerwingEntity) {
                        ((ShimmerwingEntity)entity).setAnimation("ready");
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 29, false, false));
                    }

                    MoreCritters.queueServerWork(
                        7, () -> entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.2, 0.2, entity.getLookAngle().z * 0.2))
                    );
                }
            }

            if (entity.getPersistentData().getDouble("eat") <= -1.0) {
                entity.getPersistentData().putDouble("eat", 7.0);
                if (entity.getPersistentData().getDouble("teleport") > 1.0 && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                        );
                    }
                }
            }

            shimmer = Mth.nextInt(RandomSource.create(), 1, 5);
            if (shimmer == 1.0) {
                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0); index0++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:shimmer ~ ~ ~ 0.3 0.03 0.03 0.02 1 force"
                            );
                    }
                }
            }

            if (entity.onGround()
                && !((ShimmerwingEntity)entity).animationprocedure.equals("ready")
                && !((ShimmerwingEntity)entity).animationprocedure.equals("land")) {
                entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
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
                    y + Mth.nextDouble(RandomSource.create(), 0.0, 3.0),
                    z + Mth.nextDouble(RandomSource.create(), -10.0, 10.0)
                );
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection
                        .teleport(
                            x + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                            y + Mth.nextDouble(RandomSource.create(), 0.0, 3.0),
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
                    y + Mth.nextDouble(RandomSource.create(), 0.0, 3.0),
                    z + Mth.nextDouble(RandomSource.create(), -10.0, 10.0)
                );
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection
                        .teleport(
                            x + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                            y + Mth.nextDouble(RandomSource.create(), 0.0, 3.0),
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

            if (entity.getPersistentData().getDouble("teleport") > 1.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"minecraft:chorus_fruit\"} ~ ~0.5 ~ 0.1 0.1 0.1 0.02 1 normal"
                        );
                }

                entity.setDeltaMovement(new Vec3(0.0, -0.1, 0.0));
            }

            if (entity.getPersistentData().getDouble("teleport") == 1.0) {
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
                    y + Mth.nextDouble(RandomSource.create(), 0.0, 3.0),
                    z + Mth.nextDouble(RandomSource.create(), -10.0, 10.0)
                );
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection
                        .teleport(
                            x + Mth.nextDouble(RandomSource.create(), -10.0, 10.0),
                            y + Mth.nextDouble(RandomSource.create(), 0.0, 3.0),
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
