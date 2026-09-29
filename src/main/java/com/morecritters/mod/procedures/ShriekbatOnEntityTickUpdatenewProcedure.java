package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.ShriekbatEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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

public class ShriekbatOnEntityTickUpdatenewProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("flapsound", entity.getPersistentData().getDouble("flapsound") - 1.0);
            if (entity.getPersistentData().getDouble("flapsound") <= 0.0) {
                entity.getPersistentData().putDouble("flapsound", Mth.nextInt(RandomSource.create(), 100, 200));
            }

            if (world.getBlockState(BlockPos.containing(x, y + 2.0, z)).canOcclude()) {
                if (entity instanceof ShriekbatEntity _datEntL6 && _datEntL6.getEntityData().get(ShriekbatEntity.DATA_agro)) {
                    entity.setDeltaMovement(new Vec3(0.0, -0.5, 0.0));
                } else if (((ShriekbatEntity)entity).animationprocedure.equals("idle_angry")) {
                    entity.setDeltaMovement(new Vec3(0.0, 1.0, 0.0));
                } else {
                    if (entity instanceof ShriekbatEntity) {
                        ((ShriekbatEntity)entity).setAnimation("idle_hang");
                    }

                    entity.setDeltaMovement(new Vec3(0.0, 1.0, 0.0));
                }
            } else {
                if (!(entity instanceof ShriekbatEntity _datEntL12 && _datEntL12.getEntityData().get(ShriekbatEntity.DATA_agro))) {
                    if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
                        if (entity instanceof ShriekbatEntity) {
                            ((ShriekbatEntity)entity).setAnimation("empty");
                        }
                    } else {
                        if (entity instanceof ShriekbatEntity) {
                            ((ShriekbatEntity)entity).setAnimation("fly_angry");
                        }

                        entity.setDeltaMovement(new Vec3(0.1 * entity.getLookAngle().x, 0.5, 0.1 * entity.getLookAngle().z));
                        if (entity.getPersistentData().getDouble("flapsound") <= 0.0 && !world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.flap")),
                                    SoundSource.HOSTILE,
                                    2.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.flap")),
                                    SoundSource.HOSTILE,
                                    2.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    }
                }

                if (((ShriekbatEntity)entity).animationprocedure.equals("idle_hang") && entity instanceof ShriekbatEntity) {
                    ((ShriekbatEntity)entity).setAnimation("empty");
                }
            }

            entity.getPersistentData().putDouble("test", entity.getPersistentData().getDouble("test") - 1.0);
            if (entity.getPersistentData().getDouble("test") == 1.0) {
                entity.getPersistentData().putDouble("test", Mth.nextInt(RandomSource.create(), 200, 700));
                if (((ShriekbatEntity)entity).animationprocedure.equals("idle_hang")) {
                    if (entity instanceof ShriekbatEntity) {
                        ((ShriekbatEntity)entity).setAnimation("empty");
                    }

                    if (entity instanceof ShriekbatEntity) {
                        ((ShriekbatEntity)entity).setAnimation("idle_angry");
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.test_shriek")),
                                SoundSource.HOSTILE,
                                3.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.test_shriek")),
                                SoundSource.HOSTILE,
                                3.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    MoreCritters.queueServerWork(59, () -> {
                        if (entity instanceof ShriekbatEntity) {
                            ((ShriekbatEntity)entity).setAnimation("idle_hang");
                        }
                    });
                    if (entity.isAlive()) {
                        MoreCritters.queueServerWork(
                            42,
                            () -> {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = MoreCrittersModEntities.TESTER_SHRIEK
                                        .get()
                                        .spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }

                                MoreCritters.queueServerWork(
                                    5,
                                    () -> {
                                        if (world instanceof ServerLevel _levelx) {
                                            Entity entityToSpawnx = MoreCrittersModEntities.TESTER_SHRIEK
                                                .get()
                                                .spawn(_levelx, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                            if (entityToSpawnx != null) {
                                                entityToSpawnx.setDeltaMovement(0.0, 0.0, 0.0);
                                            }
                                        }

                                        MoreCritters.queueServerWork(
                                            5,
                                            () -> {
                                                if (world instanceof ServerLevel _levelxx) {
                                                    Entity entityToSpawnxx = MoreCrittersModEntities.TESTER_SHRIEK
                                                        .get()
                                                        .spawn(_levelxx, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                                    if (entityToSpawnxx != null) {
                                                        entityToSpawnxx.setDeltaMovement(0.0, 0.0, 0.0);
                                                    }
                                                }
                                            }
                                        );
                                    }
                                );
                            }
                        );
                    }
                }
            }

            if (!((ShriekbatEntity)entity).animationprocedure.equals("idle_angry") && !((ShriekbatEntity)entity).animationprocedure.equals("shriek")) {
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
            } else if (!entity.getDisplayName().getString().equals("Misty")
                && !entity.getDisplayName().getString().equals("misty")
                && !entity.getDisplayName().getString().equals("MistyJam")
                && !entity.getDisplayName().getString().equals("mistyjam")
                && !entity.getDisplayName().getString().equals("Mistyjam")) {
                if (entity instanceof ShriekbatEntity animatable) {
                    animatable.setTexture("shriekbat_open");
                }
            } else if (entity instanceof ShriekbatEntity animatable) {
                animatable.setTexture("shriekbat_misty_open");
            }

            entity.getPersistentData().putDouble("agro", entity.getPersistentData().getDouble("agro") - 1.0);
            if (entity.getPersistentData().getDouble("agro") == 1.0 && entity instanceof ShriekbatEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(ShriekbatEntity.DATA_agro, false);
            }

            if (entity.isInWall()) {
                Entity _ent = entity;
                _ent.teleportTo(x, y - 1.0, z);
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection.teleport(x, y - 1.0, z, _ent.getYRot(), _ent.getXRot());
                }
            }

            entity.getPersistentData().putDouble("shriek", entity.getPersistentData().getDouble("shriek") - 1.0);
            if (entity.getPersistentData().getDouble("shriek") == 1.0) {
                entity.getPersistentData().putDouble("shriek", 100.0);
                if (entity instanceof ShriekbatEntity _datEntL69 && _datEntL69.getEntityData().get(ShriekbatEntity.DATA_agro)) {
                    if (entity instanceof ShriekbatEntity) {
                        ((ShriekbatEntity)entity).setAnimation("empty");
                    }

                    MoreCritters.queueServerWork(
                        1,
                        () -> {
                            if (entity instanceof ShriekbatEntity) {
                                ((ShriekbatEntity)entity).setAnimation("shriek");
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.sendParticles(MoreCrittersModParticleTypes.SHRIEKBAT_SHRIEK.get(), x, y, z, 1, 0.0, 0.0, 0.0, 0.0);
                            }

                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.shriek")),
                                        SoundSource.HOSTILE,
                                        3.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.shriek")),
                                        SoundSource.HOSTILE,
                                        3.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            Vec3 _center = new Vec3(x, y, z);

                            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), e -> true)
                                .stream()
                                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                .toList()) {
                                if (entityiterator instanceof Monster
                                    && entityiterator instanceof LivingEntity _liveEnt
                                    && world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true)
                                            .stream()
                                            .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                            }).compareDistOf(x, y, z))
                                            .findFirst()
                                            .orElse(null)
                                        != null
                                    && _liveEnt.hasLineOfSight(
                                        world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true)
                                            .stream()
                                            .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                            }).compareDistOf(x, y, z))
                                            .findFirst()
                                            .orElse(null)
                                    )
                                    && entityiterator instanceof Mob _entity) {
                                    Entity patt10959$temp = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40.0, 40.0, 40.0), e -> true)
                                        .stream()
                                        .sorted((new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }).compareDistOf(x, y, z))
                                        .findFirst()
                                        .orElse(null);
                                    if (patt10959$temp instanceof LivingEntity _ent) {
                                        _entity.setTarget(_ent);
                                    }
                                }
                            }
                        }
                    );
                }
            }

            if (entity instanceof ShriekbatEntity _datEntL82 && _datEntL82.getEntityData().get(ShriekbatEntity.DATA_agro)) {
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
                if (!((ShriekbatEntity)entity).animationprocedure.equals("shriek") && entity instanceof ShriekbatEntity) {
                    ((ShriekbatEntity)entity).setAnimation("fly_angry");
                }
            } else if (((ShriekbatEntity)entity).animationprocedure.equals("fly_angry")) {
                MoreCritters.queueServerWork(2, () -> {
                    if (entity instanceof ShriekbatEntity) {
                        ((ShriekbatEntity)entity).setAnimation("empty");
                    }
                });
            }
        }
    }
}
