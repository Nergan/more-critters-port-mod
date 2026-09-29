package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.ShriekbatEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ShriekbatOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).canOcclude() && entity instanceof ShriekbatEntity) {
                ((ShriekbatEntity)entity).setAnimation("idle_hang");
            }

            if (!entity.getDisplayName().getString().equals("Misty")
                && !entity.getDisplayName().getString().equals("misty")
                && !entity.getDisplayName().getString().equals("MistyJam")
                && !entity.getDisplayName().getString().equals("mistyjam")
                && !entity.getDisplayName().getString().equals("Mistyjam")) {
                if (entity instanceof ShriekbatEntity animatable) {
                    animatable.setTexture("shriekbat");
                }
            } else if (entity instanceof ShriekbatEntity animatable) {
                animatable.setTexture("shriekbat_misty");
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof Player) {
                    if (entityiterator instanceof Player _plr && _plr.getAbilities().instabuild) {
                        if (entityiterator instanceof Player _plrx && _plrx.getAbilities().instabuild) {
                            entity.getPersistentData().putBoolean("mad", false);
                            if (!world.getBlockState(BlockPos.containing(x, y + 1.0, z)).canOcclude()) {
                                if (entity instanceof ShriekbatEntity) {
                                    ((ShriekbatEntity)entity).setAnimation("fly");
                                }
                            } else if (entity instanceof ShriekbatEntity) {
                                ((ShriekbatEntity)entity).setAnimation("idle_hang");
                            }
                        }
                    } else if (!(entityiterator instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MoreCrittersModMobEffects.SHRIEK_RESISTANCE))) {
                        entity.getPersistentData().putBoolean("mad", true);
                        if (entity instanceof ShriekbatEntity) {
                            ((ShriekbatEntity)entity).setAnimation("fly_angry");
                        }

                        if (!(entity.getPersistentData().getDouble("echo") < 10.0)) {
                            entity.setDeltaMovement(
                                new Vec3(
                                    (
                                            entity.level()
                                                    .clip(
                                                        new ClipContext(
                                                            entity.getEyePosition(1.0F),
                                                            entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)),
                                                            Block.OUTLINE,
                                                            Fluid.NONE,
                                                            entity
                                                        )
                                                    )
                                                    .getBlockPos()
                                                    .getX()
                                                - x
                                        )
                                        / 3.0,
                                    Mth.nextDouble(RandomSource.create(), -0.5, 0.5),
                                    (
                                            entity.level()
                                                    .clip(
                                                        new ClipContext(
                                                            entity.getEyePosition(1.0F),
                                                            entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)),
                                                            Block.OUTLINE,
                                                            Fluid.NONE,
                                                            entity
                                                        )
                                                    )
                                                    .getBlockPos()
                                                    .getZ()
                                                - z
                                        )
                                        / 3.0
                                )
                            );
                        }
                    }
                }
            }

            entity.getPersistentData().putDouble("echo", entity.getPersistentData().getDouble("echo") - 1.0);
            if (entity.getPersistentData().getDouble("echo") < 0.0) {
                entity.getPersistentData().putDouble("echo", 100.0);
                Vec3 _center2 = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center2, _center2).inflate(20.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center2)))
                    .toList()) {
                    if (entityiterator instanceof Player
                        && !(entityiterator instanceof Player _plr && _plr.getAbilities().instabuild)
                        && !(entityiterator instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MoreCrittersModMobEffects.SHRIEK_RESISTANCE))) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.shriek")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.shriek")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (world instanceof ServerLevel _level) {
                            Entity entityToSpawn = MoreCrittersModEntities.ECHO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                            }
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("echo") < 5.0) {
                Vec3 _center3 = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center3, _center3).inflate(20.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center3)))
                    .toList()) {
                    if (entityiterator instanceof Player
                        && !(entityiterator instanceof Player _plr && _plr.getAbilities().instabuild)
                        && !(entityiterator instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MoreCrittersModMobEffects.SHRIEK_RESISTANCE))) {
                        if (entity instanceof ShriekbatEntity) {
                            ((ShriekbatEntity)entity).setAnimation("shriek");
                        }

                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                    }
                }
            }

            if (entity.getPersistentData().getDouble("echo") < 5.0 && entity.getPersistentData().getBoolean("mad")) {
                Vec3 _center4 = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center4, _center4).inflate(20.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center4)))
                    .toList()) {
                    if (entityiterator instanceof Monster && entityiterator instanceof Mob _entity) {
                        Entity var47 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null);
                        if (var47 instanceof LivingEntity _ent) {
                            _entity.setTarget(_ent);
                        }
                    }
                }
            }

            entity.getPersistentData().putDouble("hang", entity.getPersistentData().getDouble("hang") - 1.0);
            if (entity.getPersistentData().getDouble("hang") < 0.0) {
                entity.getPersistentData().putDouble("hang", Mth.nextInt(RandomSource.create(), 100, 200));
                Vec3 _center5 = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center5, _center5).inflate(20.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center5)))
                    .toList()) {
                    if (entityiterator instanceof Player
                        && (
                            entityiterator instanceof Player _plr && _plr.getAbilities().instabuild
                                || entity instanceof LivingEntity _livEnt55 && _livEnt55.hasEffect(MoreCrittersModMobEffects.SHRIEK_RESISTANCE)
                        )
                        && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
                        entity.setDeltaMovement(new Vec3(0.0, 1.0, 0.0));
                    }
                }
            }

            entity.getPersistentData().putDouble("flap", entity.getPersistentData().getDouble("flap") - 1.0);
            if (entity.getPersistentData().getDouble("flap") < 0.0) {
                entity.getPersistentData().putDouble("flap", Mth.nextInt(RandomSource.create(), 40, 60));
                if (((ShriekbatEntity)entity).animationprocedure.equals("fly_angry") && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.flap")),
                            SoundSource.HOSTILE,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.flap")),
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
}
