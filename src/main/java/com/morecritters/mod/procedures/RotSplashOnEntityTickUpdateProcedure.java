package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.FrightshroomEntity;
import com.morecritters.mod.entity.MightshroomEntity;
import com.morecritters.mod.entity.NightshroomEntity;
import com.morecritters.mod.entity.RotSplashEntity;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class RotSplashOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double sound = 0.0;
            if ((entity instanceof RotSplashEntity animatable ? animatable.getTexture() : "null").equals("rot_splash0")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof RotSplashEntity animatablex) {
                        animatablex.setTexture("rot_splash1");
                    }
                });
            } else if ((entity instanceof RotSplashEntity animatable ? animatable.getTexture() : "null").equals("rot_splash1")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof RotSplashEntity animatablex) {
                        animatablex.setTexture("rot_splash2");
                    }
                });
            } else if ((entity instanceof RotSplashEntity animatable ? animatable.getTexture() : "null").equals("rot_splash2")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof RotSplashEntity animatablex) {
                        animatablex.setTexture("rot_splash3");
                    }
                });
            } else if ((entity instanceof RotSplashEntity animatable ? animatable.getTexture() : "null").equals("rot_splash3")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof RotSplashEntity animatablex) {
                        animatablex.setTexture("rot_splash4");
                    }
                });
            } else if ((entity instanceof RotSplashEntity animatable ? animatable.getTexture() : "null").equals("rot_splash4")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof RotSplashEntity animatablex) {
                        animatablex.setTexture("rot_splash0");
                    }
                });
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.25), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (!(entityiterator instanceof RotSplashEntity)
                    && !(entityiterator instanceof MightshroomEntity)
                    && !(entityiterator instanceof FrightshroomEntity)
                    && !(entityiterator instanceof NightshroomEntity)) {
                    entityiterator.push(0.0, 0.5, 0.0);
                }
            }

            entity.setDeltaMovement(new Vec3(0.0, -2.0, 0.0));
            rate = Mth.nextInt(RandomSource.create(), 1, 3);
            if (rate == 1.0 && world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle more_critters:rot ~ ~3 ~ 0.5 0 0.5 0.01 5 force"
                    );
            }

            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            if (entity.getPersistentData().getDouble("timer") == 1.0) {
                if (entity instanceof RotSplashEntity) {
                    ((RotSplashEntity)entity).setAnimation("end");
                }

                MoreCritters.queueServerWork(
                    22,
                    () -> {
                        if (!world.isClientSide() && world instanceof Level _levelx) {
                            if (!_levelx.isClientSide()) {
                                _levelx.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.end")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _levelx.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.end")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }
                    }
                );
            }

            if (!entity.onGround()) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
                }

                entity.setDeltaMovement(new Vec3(0.0, -2.0, 0.0));
            } else if (entity instanceof LivingEntity _entity) {
                _entity.removeAllEffects();
            }

            if (entity.isInWall()) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.end")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.end")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle more_critters:rot ~ ~ ~ 0.2 0 0.2 0.01 5 force"
                    );
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"minecraft:mycelium\"} ~ ~ ~ 0.3 0 0.3 0.01 2 force"
                    );
            }

            sound = Mth.nextInt(RandomSource.create(), 1, 5);
            if (sound == 1.0 && !world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.idle")),
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.idle")),
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F,
                        false
                    );
                }
            }

            if (!(entity.getPersistentData().getDouble("size") >= 2.0)) {
                entity.getPersistentData().putDouble("size", entity.getPersistentData().getDouble("size") + 0.1);
            }
        }
    }
}
