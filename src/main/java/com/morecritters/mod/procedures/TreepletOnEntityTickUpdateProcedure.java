package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.TreepletEntity;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TreepletOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("spin", entity.getPersistentData().getDouble("spin") - 1.0);
            if (entity.getPersistentData().getDouble("spin") == 0.0) {
                entity.getPersistentData().putDouble("spin", Mth.nextInt(RandomSource.create(), 200, 500));
                if (!entity.isSprinting()) {
                    if (entity instanceof TreepletEntity) {
                        ((TreepletEntity)entity).setAnimation("spin");
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.treeplet.spin")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.treeplet.spin")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 29, false, false));
                    }
                }
            }

            entity.getPersistentData().putDouble("shoot", entity.getPersistentData().getDouble("shoot") - 1.0);
            if (entity.getPersistentData().getDouble("shoot") == 0.0) {
                entity.getPersistentData().putDouble("shoot", Mth.nextInt(RandomSource.create(), 15, 25));
                if (entity.isSprinting()) {
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.treeplet.spit")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.treeplet.spit")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof TreepletEntity) {
                        ((TreepletEntity)entity).setAnimation("shoot");
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:resin ~ ~ ~ 0.2 0.2 0.2 0.1 5 force"
                            );
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.RESIN_PUDDLE
                            .get()
                            .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                }
            }

            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).isEmpty()) {
                if (entity instanceof LivingEntity _liveEnt
                    && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z)).findFirst().orElse(null) != null
                    && _liveEnt.hasLineOfSight(
                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true).stream().sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null)
                    )) {
                    Entity var10 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var10 instanceof Player _plr && _plr.getAbilities().instabuild) {
                        entity.setSprinting(false);
                    } else {
                        entity.setSprinting(true);
                    }
                } else {
                    entity.setSprinting(false);
                }
            }
        }
    }
}
