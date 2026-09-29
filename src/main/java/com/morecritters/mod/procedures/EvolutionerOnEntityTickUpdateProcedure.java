package com.morecritters.mod.procedures;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.EvolutionerEntity;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class EvolutionerOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double ultra = 0.0;
            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            entity.getPersistentData().putDouble("magic", entity.getPersistentData().getDouble("magic") - 1.0);
            if (entity instanceof EvolutionerEntity _datEntL4 && _datEntL4.getEntityData().get(EvolutionerEntity.DATA_magic)) {
                if (entity instanceof Mob _entity) {
                    _entity.getNavigation().stop();
                }

                if (!((EvolutionerEntity)entity).animationprocedure.equals("cast") && entity instanceof EvolutionerEntity) {
                    ((EvolutionerEntity)entity).setAnimation("spell");
                }

                if (entity instanceof EvolutionerEntity animatable) {
                    animatable.setTexture("evolutioner_arm");
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:witch ~ ~1 ~ 0.1 1 0.1 1 1 force"
                        );
                }
            } else if (entity instanceof EvolutionerEntity animatable) {
                animatable.setTexture("evolutioner");
            }

            if (entity.getPersistentData().getDouble("attack") == 1.0) {
                entity.getPersistentData().putDouble("attack", 150.0);
                entity.getPersistentData().putDouble("magic", 70.0);
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    if (entity instanceof EvolutionerEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(EvolutionerEntity.DATA_magic, true);
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.chant")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.chant")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("magic") == 10.0) {
                if (entity instanceof EvolutionerEntity) {
                    ((EvolutionerEntity)entity).setAnimation("empty");
                }

                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity && entity instanceof EvolutionerEntity) {
                    ((EvolutionerEntity)entity).setAnimation("cast");
                }
            }

            if (entity.getPersistentData().getDouble("magic") == 0.0 && entity instanceof EvolutionerEntity) {
                ((EvolutionerEntity)entity).setAnimation("empty");
            }

            if (entity.getPersistentData().getDouble("magic") == 5.0 && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), ex -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (!(entityiterator instanceof EvolutionerEntity)) {
                        if (entityiterator instanceof Witch) {
                            rate = Mth.nextInt(RandomSource.create(), 1, 3);
                            if (rate == 1.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.PILLAGER
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 2.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.VINDICATOR
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 3.0 && world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.EVOKER
                                    .spawn(
                                        _level,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setYRot(entity.getYRot());
                                    entityToSpawn.setYBodyRot(entity.getYRot());
                                    entityToSpawn.setYHeadRot(entity.getYRot());
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:witch ~ ~ ~ 0.5 1 0.5 0.02 12 force"
                                    );
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:poof ~ ~1 ~ 1 0.5 1 0.02 5 force"
                                    );
                            }

                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        entityiterator.getX(),
                                        entityiterator.getY(),
                                        entityiterator.getZ(),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (!entityiterator.level().isClientSide()) {
                                entityiterator.discard();
                            }
                        } else if (entityiterator instanceof Pillager) {
                            rate = Mth.nextInt(RandomSource.create(), 1, 3);
                            if (rate == 1.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.WITCH
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 2.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.VINDICATOR
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 3.0 && world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.EVOKER
                                    .spawn(
                                        _level,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setYRot(entity.getYRot());
                                    entityToSpawn.setYBodyRot(entity.getYRot());
                                    entityToSpawn.setYHeadRot(entity.getYRot());
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:witch ~ ~ ~ 0.5 1 0.5 0.02 12 force"
                                    );
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:poof ~ ~1 ~ 1 0.5 1 0.02 5 force"
                                    );
                            }

                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        entityiterator.getX(),
                                        entityiterator.getY(),
                                        entityiterator.getZ(),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (!entityiterator.level().isClientSide()) {
                                entityiterator.discard();
                            }
                        } else if (entityiterator instanceof Vindicator) {
                            rate = Mth.nextInt(RandomSource.create(), 1, 3);
                            if (rate == 1.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.WITCH
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 2.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.PILLAGER
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 3.0 && world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.EVOKER
                                    .spawn(
                                        _level,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setYRot(entity.getYRot());
                                    entityToSpawn.setYBodyRot(entity.getYRot());
                                    entityToSpawn.setYHeadRot(entity.getYRot());
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:witch ~ ~ ~ 0.5 1 0.5 0.02 12 force"
                                    );
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:poof ~ ~1 ~ 1 0.5 1 0.02 5 force"
                                    );
                            }

                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        entityiterator.getX(),
                                        entityiterator.getY(),
                                        entityiterator.getZ(),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (!entityiterator.level().isClientSide()) {
                                entityiterator.discard();
                            }
                        } else if (entityiterator instanceof Evoker) {
                            rate = Mth.nextInt(RandomSource.create(), 1, 3);
                            if (rate == 1.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.WITCH
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 2.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.PILLAGER
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 3.0 && world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.VINDICATOR
                                    .spawn(
                                        _level,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setYRot(entity.getYRot());
                                    entityToSpawn.setYBodyRot(entity.getYRot());
                                    entityToSpawn.setYHeadRot(entity.getYRot());
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:witch ~ ~ ~ 0.5 1 0.5 0.02 12 force"
                                    );
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:poof ~ ~1 ~ 1 0.5 1 0.02 5 force"
                                    );
                            }

                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        entityiterator.getX(),
                                        entityiterator.getY(),
                                        entityiterator.getZ(),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (!entityiterator.level().isClientSide()) {
                                entityiterator.discard();
                            }
                        } else if (entity instanceof LivingEntity _livEnt154
                            && _livEnt154.getType().is(EntityTypeTags.ILLAGER)
                            && !(entityiterator instanceof Evoker)
                            && !(entityiterator instanceof Pillager)
                            && !(entityiterator instanceof Vindicator)) {
                            rate = Mth.nextInt(RandomSource.create(), 1, 4);
                            if (rate == 1.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.WITCH
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 2.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.PILLAGER
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 3.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.VINDICATOR
                                        .spawn(
                                            _level,
                                            BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot(entity.getYRot());
                                        entityToSpawn.setYBodyRot(entity.getYRot());
                                        entityToSpawn.setYHeadRot(entity.getYRot());
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            } else if (rate == 4.0 && world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.EVOKER
                                    .spawn(
                                        _level,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setYRot(entity.getYRot());
                                    entityToSpawn.setYBodyRot(entity.getYRot());
                                    entityToSpawn.setYHeadRot(entity.getYRot());
                                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:witch ~ ~ ~ 0.5 1 0.5 0.02 12 force"
                                    );
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:poof ~ ~1 ~ 1 0.5 1 0.02 5 force"
                                    );
                            }

                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        entityiterator.getX(),
                                        entityiterator.getY(),
                                        entityiterator.getZ(),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.evolutioner.transform")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (!entityiterator.level().isClientSide()) {
                                entityiterator.discard();
                            }
                        }
                    }
                }

                if (world.getEntitiesOfClass(Vindicator.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), ex -> true).isEmpty()
                    && world.getEntitiesOfClass(Pillager.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), ex -> true).isEmpty()
                    && world.getEntitiesOfClass(Witch.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), ex -> true).isEmpty()
                    && world.getEntitiesOfClass(Evoker.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), ex -> true).isEmpty()
                    && world.getEntitiesOfClass(SpellcasterIllager.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), ex -> true).isEmpty()
                    && entity instanceof LivingEntity _liveEnt
                    && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                    && _liveEnt.hasLineOfSight(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.EVOLITE_MAW
                            .get()
                            .spawn(
                                _level,
                                BlockPos.containing(
                                    x + Mth.nextDouble(RandomSource.create(), -8.0, 8.0), y, z + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                ),
                                MobSpawnType.MOB_SUMMONED
                            );
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.EVOLITE_MAW
                            .get()
                            .spawn(
                                _level,
                                BlockPos.containing(
                                    x + Mth.nextDouble(RandomSource.create(), -8.0, 8.0), y, z + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                ),
                                MobSpawnType.MOB_SUMMONED
                            );
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.EVOLITE_MAW
                            .get()
                            .spawn(
                                _level,
                                BlockPos.containing(
                                    x + Mth.nextDouble(RandomSource.create(), -8.0, 8.0), y, z + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                ),
                                MobSpawnType.MOB_SUMMONED
                            );
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.EVOLITE_MAW
                            .get()
                            .spawn(
                                _level,
                                BlockPos.containing(
                                    x + Mth.nextDouble(RandomSource.create(), -8.0, 8.0), y, z + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                ),
                                MobSpawnType.MOB_SUMMONED
                            );
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.EVOLITE_MAW
                            .get()
                            .spawn(
                                _level,
                                BlockPos.containing(
                                    x + Mth.nextDouble(RandomSource.create(), -8.0, 8.0), y, z + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                ),
                                MobSpawnType.MOB_SUMMONED
                            );
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("magic") == 1.0 && entity instanceof EvolutionerEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(EvolutionerEntity.DATA_magic, false);
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                && (
                    (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player _plr && _plr.getAbilities().instabuild
                        || !(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).isAlive()
                )
                && entity instanceof Mob) {
                try {
                    ((Mob)entity).setTarget(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                && (
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                            ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                            : -1.0F
                    )
                    > 0.0F
                && (
                        (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                            ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                            : -1.0F
                    )
                    <= 4.0F
                && entity.isAlive()
                && entity.onGround()
                && !((EvolutionerEntity)entity).animationprocedure.equals("cast")
                && !((EvolutionerEntity)entity).animationprocedure.equals("spell")) {
                entity.push(-0.1 * entity.getLookAngle().x, -0.1, -0.1 * entity.getLookAngle().z);
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                && (
                    (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof Player _plr && _plr.getAbilities().instabuild
                        || !(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).isAlive()
                )
                && entity instanceof Mob) {
                try {
                    ((Mob)entity).setTarget(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
