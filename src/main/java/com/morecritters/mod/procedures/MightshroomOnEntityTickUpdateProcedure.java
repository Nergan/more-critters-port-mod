package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.FungalZombieEntity;
import com.morecritters.mod.entity.MightshroomEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MightshroomOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            if (entity.getPersistentData().getDouble("attack") == 1.0) {
                entity.getPersistentData().putDouble("attack", Mth.nextInt(RandomSource.create(), 100, 200));
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    rate = Mth.nextInt(RandomSource.create(), 1, 3);
                    if (rate == 1.0) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 30, false, false));
                        }

                        if (entity instanceof MightshroomEntity) {
                            ((MightshroomEntity)entity).setAnimation("stomp");
                        }

                        entity.getPersistentData().putBoolean("stun", true);
                        MoreCritters.queueServerWork(20, () -> entity.getPersistentData().putBoolean("stun", false));
                        Vec3 _center = new Vec3(x, y, z);

                        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                            .stream()
                            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                            .toList()) {
                            MoreCritters.queueServerWork(22, () -> {
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.TREMBLE, 10, 0, false, false));
                                }
                            });
                        }

                        MoreCritters.queueServerWork(
                            21,
                            () -> {
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.stomp")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.stomp")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z + 1.0)).canOcclude()) {
                                    if (world instanceof ServerLevel _level) {
                                        Entity entityToSpawn = MoreCrittersModEntities.FUNGAL_ZOMBIE
                                            .get()
                                            .spawn(_level, BlockPos.containing(x + 1.0, y - 1.0, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setYRot((float)Math.random());
                                            entityToSpawn.setYBodyRot((float)Math.random());
                                            entityToSpawn.setYHeadRot((float)Math.random());
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (world instanceof ServerLevel _level) {
                                        _level.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(x + 1.0, y, z + 1.0),
                                                        Vec2.ZERO,
                                                        _level,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _level.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle minecraft:block{block_state:\"minecraft:mycelium\"} ~ ~ ~ 0.2 0 0.2 0.05 55"
                                            );
                                    }
                                }

                                if (world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z + 1.0)).canOcclude()) {
                                    if (world instanceof ServerLevel _level) {
                                        Entity entityToSpawn = MoreCrittersModEntities.FUNGAL_ZOMBIE
                                            .get()
                                            .spawn(_level, BlockPos.containing(x - 1.0, y - 1.0, z + 1.0), MobSpawnType.MOB_SUMMONED);
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setYRot((float)Math.random());
                                            entityToSpawn.setYBodyRot((float)Math.random());
                                            entityToSpawn.setYHeadRot((float)Math.random());
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (world instanceof ServerLevel _level) {
                                        _level.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(x - 1.0, y, z + 1.0),
                                                        Vec2.ZERO,
                                                        _level,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _level.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle minecraft:block{block_state:\"minecraft:mycelium\"} ~ ~ ~ 0.2 0 0.2 0.05 55"
                                            );
                                    }
                                }

                                if (world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z - 1.0)).canOcclude()) {
                                    if (world instanceof ServerLevel _level) {
                                        Entity entityToSpawn = MoreCrittersModEntities.FUNGAL_ZOMBIE
                                            .get()
                                            .spawn(_level, BlockPos.containing(x + 1.0, y - 1.0, z - 1.0), MobSpawnType.MOB_SUMMONED);
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setYRot((float)Math.random());
                                            entityToSpawn.setYBodyRot((float)Math.random());
                                            entityToSpawn.setYHeadRot((float)Math.random());
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (world instanceof ServerLevel _level) {
                                        _level.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(x + 1.0, y, z - 1.0),
                                                        Vec2.ZERO,
                                                        _level,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _level.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle minecraft:block{block_state:\"minecraft:mycelium\"} ~ ~ ~ 0.2 0 0.2 0.05 55"
                                            );
                                    }
                                }

                                if (world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z - 1.0)).canOcclude()) {
                                    if (world instanceof ServerLevel _level) {
                                        Entity entityToSpawn = MoreCrittersModEntities.FUNGAL_ZOMBIE
                                            .get()
                                            .spawn(_level, BlockPos.containing(x - 1.0, y - 1.0, z - 1.0), MobSpawnType.MOB_SUMMONED);
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setYRot((float)Math.random());
                                            entityToSpawn.setYBodyRot((float)Math.random());
                                            entityToSpawn.setYHeadRot((float)Math.random());
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (world instanceof ServerLevel _level) {
                                        _level.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(x - 1.0, y, z - 1.0),
                                                        Vec2.ZERO,
                                                        _level,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _level.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle minecraft:block{block_state:\"minecraft:mycelium\"} ~ ~ ~ 0.2 0 0.2 0.05 55"
                                            );
                                    }
                                }

                                Vec3 _centerx = new Vec3(x, y, z);

                                for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(3.0), e -> true)
                                    .stream()
                                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerx)))
                                    .toList()) {
                                    if (entityiteratorx instanceof FungalZombieEntity) {
                                        entityiteratorx.setDeltaMovement(new Vec3(0.0, 0.7, 0.0));
                                    }
                                }
                            }
                        );
                    } else if (rate != 2.0 && rate != 3.0) {
                        if (rate == 4.0) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                            }

                            if (entity instanceof MightshroomEntity) {
                                ((MightshroomEntity)entity).setAnimation("peck_start");
                            }

                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.peck_ready")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.peck_ready")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            entity.getPersistentData().putBoolean("stun", true);
                            MoreCritters.queueServerWork(
                                20,
                                () -> {
                                    Vec3 _centerx = new Vec3(x, y, z);

                                    for (Entity entityiteratorx : world.getEntitiesOfClass(Entity.class, new AABB(_centerx, _centerx).inflate(3.0), e -> true)
                                        .stream()
                                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_centerx)))
                                        .toList()) {
                                        if (entityiteratorx == (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)) {
                                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 30, false, false));
                                            }

                                            entity.getPersistentData().putBoolean("stun", false);
                                            if (entity instanceof MightshroomEntity) {
                                                ((MightshroomEntity)entity).setAnimation("peck_hard");
                                            }

                                            if (world instanceof Level _level) {
                                                if (!_level.isClientSide()) {
                                                    _level.playSound(
                                                        (Player)null,
                                                        BlockPos.containing(x, y, z),
                                                        BuiltInRegistries.SOUND_EVENT
                                                            .get(ResourceLocation.parse("more_critters:entity.mightshroom.peck_hit")),
                                                        SoundSource.HOSTILE,
                                                        1.0F,
                                                        1.0F
                                                    );
                                                } else {
                                                    _level.playLocalSound(
                                                        x,
                                                        y,
                                                        z,
                                                        BuiltInRegistries.SOUND_EVENT
                                                            .get(ResourceLocation.parse("more_critters:entity.mightshroom.peck_hit")),
                                                        SoundSource.HOSTILE,
                                                        1.0F,
                                                        1.0F,
                                                        false
                                                    );
                                                }
                                            }

                                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                                .hurt(
                                                    new DamageSource(
                                                        world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)
                                                    ),
                                                    5.0F
                                                );
                                        } else {
                                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 30, false, false));
                                            }

                                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.STUNNED, 80, 30, false, false));
                                            }

                                            if (entity instanceof MightshroomEntity) {
                                                ((MightshroomEntity)entity).setAnimation("peck_fail");
                                            }

                                            if (world instanceof Level _level) {
                                                if (!_level.isClientSide()) {
                                                    _level.playSound(
                                                        (Player)null,
                                                        BlockPos.containing(x, y, z),
                                                        BuiltInRegistries.SOUND_EVENT
                                                            .get(ResourceLocation.parse("more_critters:entity.mightshroom.peck_miss")),
                                                        SoundSource.HOSTILE,
                                                        1.0F,
                                                        1.0F
                                                    );
                                                } else {
                                                    _level.playLocalSound(
                                                        x,
                                                        y,
                                                        z,
                                                        BuiltInRegistries.SOUND_EVENT
                                                            .get(ResourceLocation.parse("more_critters:entity.mightshroom.peck_miss")),
                                                        SoundSource.HOSTILE,
                                                        1.0F,
                                                        1.0F,
                                                        false
                                                    );
                                                }
                                            }

                                            MoreCritters.queueServerWork(80, () -> entity.getPersistentData().putBoolean("stun", false));
                                        }
                                    }
                                }
                            );
                        }
                    } else {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 30, false, false));
                        }

                        if (entity instanceof MightshroomEntity) {
                            ((MightshroomEntity)entity).setAnimation("jump_start");
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.leap_ready")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.leap_ready")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        MoreCritters.queueServerWork(
                            10,
                            () -> {
                                entity.lookAt(
                                    Anchor.EYES,
                                    new Vec3(
                                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY(),
                                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                                    )
                                );
                                entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 2.0, 1.5, entity.getLookAngle().z * 2.0));
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.leap")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.leap")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                MoreCritters.queueServerWork(1, () -> entity.getPersistentData().putBoolean("air", true));
                            }
                        );
                    }
                }
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                if (!entity.getPersistentData().getBoolean("target")) {
                    if (entity instanceof MightshroomEntity) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 30, false, false));
                        }

                        if (entity instanceof MightshroomEntity) {
                            ((MightshroomEntity)entity).setAnimation("scream");
                        }

                        MoreCritters.queueServerWork(
                            10,
                            () -> {
                                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _entity
                                    && !_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.TREMBLE, 30, 0, false, false));
                                }

                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.scream")),
                                            SoundSource.HOSTILE,
                                            2.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.scream")),
                                            SoundSource.HOSTILE,
                                            2.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }
                            }
                        );
                    }

                    entity.getPersistentData().putBoolean("target", true);
                }
            } else {
                entity.getPersistentData().putBoolean("target", false);
            }

            if (entity.onGround() && entity.getPersistentData().getBoolean("air")) {
                if (entity instanceof MightshroomEntity) {
                    ((MightshroomEntity)entity).setAnimation("empty");
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                }

                if (entity instanceof MightshroomEntity) {
                    ((MightshroomEntity)entity).setAnimation("jump_end");
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.crash")),
                            SoundSource.HOSTILE,
                            2.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.crash")),
                            SoundSource.HOSTILE,
                            2.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.MIGHTSHROOM_ECHO
                        .get()
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    MoreCritters.queueServerWork(2, () -> {
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.TREMBLE, 10, 0, false, false));
                        }
                    });
                }

                entity.getPersistentData().putBoolean("air", false);
            }

            if (entity.getPersistentData().getBoolean("air") && entity instanceof MightshroomEntity) {
                ((MightshroomEntity)entity).setAnimation("air");
            }
        }
    }
}
