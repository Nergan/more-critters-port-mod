package com.morecritters.mod.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.CreeblossomEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CreeblossomOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double particle = 0.0;
            entity.getPersistentData().putDouble("life", entity.getPersistentData().getDouble("life") - 1.0);
            if (entity.getPersistentData().getDouble("life") == 0.0) {
                entity.getPersistentData().putDouble("life", 400.0);
                MoreCritters.queueServerWork(
                    20,
                    () -> {
                        if ((entity instanceof CreeblossomEntity animatablexxxx ? animatablexxxx.getTexture() : "null").equals("creeblossom_electric")) {
                            if (world instanceof Level _levelxxxxxx) {
                                if (!_levelxxxxxx.isClientSide()) {
                                    _levelxxxxxx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.primed")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelxxxxxx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.primed")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        } else if (world instanceof Level _levelxxxx) {
                            if (!_levelxxxx.isClientSide()) {
                                _levelxxxx.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.creeblossom.primed")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _levelxxxx.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.creeblossom.primed")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (!(entity instanceof CreeblossomEntity animatablexx ? animatablexx.getTexture() : "null").equals("creeblossom")
                            && !(entity instanceof CreeblossomEntity animatablex ? animatablex.getTexture() : "null").equals("creeblossom_friendly")) {
                            if ((entity instanceof CreeblossomEntity animatablexxx ? animatablexxx.getTexture() : "null").equals("creeblossom_electric")) {
                                if (world instanceof Level _levelxx) {
                                    if (!_levelxx.isClientSide()) {
                                        _levelxx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.explode")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelxx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.explode")),
                                            SoundSource.HOSTILE,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (world instanceof Level _levelx && !_levelx.isClientSide()) {
                                    _levelx.explode(null, entity.getX(), entity.getY(), entity.getZ(), 0.0F, ExplosionInteraction.NONE);
                                }
                            }
                        } else {
                            if (world instanceof Level _levelxxxxx && !_levelxxxxx.isClientSide()) {
                                _levelxxxxx.explode(null, entity.getX(), entity.getY(), entity.getZ(), 1.5F, ExplosionInteraction.NONE);
                            }

                            if (world instanceof ServerLevel _levelxxx) {
                                _levelxxx.sendParticles(
                                    MoreCrittersModParticleTypes.BLOSSOM_EXPLOSION.get(), entity.getX(), entity.getY(), entity.getZ(), 1, 0.0, 0.0, 0.0, 0.0
                                );
                            }
                        }

                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }
                    }
                );
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                }

                if (entity instanceof CreeblossomEntity) {
                    ((CreeblossomEntity)entity).setAnimation("blow");
                }
            }

            MoreCritters.queueServerWork(
                1,
                () -> {
                    if (entity.getPersistentData().getDouble("blow") <= 0.0) {
                        if ((entity instanceof CreeblossomEntity animatablexxxxxxx ? animatablexxxxxxx.getTexture() : "null").equals("creeblossom_electric")) {
                            if (world instanceof Level _levelxxxxx) {
                                if (!_levelxxxxx.isClientSide()) {
                                    _levelxxxxx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.primed")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelxxxxx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.primed")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        } else if (world instanceof Level _levelxx) {
                            if (!_levelxx.isClientSide()) {
                                _levelxx.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.creeblossom.primed")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _levelxx.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.creeblossom.primed")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (!(entity instanceof CreeblossomEntity animatablexxxxx ? animatablexxxxx.getTexture() : "null").equals("creeblossom")
                            && !(entity instanceof CreeblossomEntity animatablexxx ? animatablexxx.getTexture() : "null").equals("creeblossom_friendly")) {
                            if ((entity instanceof CreeblossomEntity animatablexxxxxx ? animatablexxxxxx.getTexture() : "null").equals("creeblossom_electric")) {
                                MoreCritters.queueServerWork(
                                    20,
                                    () -> {
                                        if (world instanceof Level _levelxxxxxxxxx && !_levelxxxxxxxxx.isClientSide()) {
                                            _levelxxxxxxxxx.explode(null, entity.getX(), entity.getY(), entity.getZ(), 0.0F, ExplosionInteraction.NONE);
                                        }

                                        if (world instanceof ServerLevel _levelxxxxxxxx) {
                                            _levelxxxxxxxx.sendParticles(
                                                MoreCrittersModParticleTypes.ZAP.get(), entity.getX(), entity.getY(), entity.getZ(), 5, 0.03, 0.03, 0.03, 0.0
                                            );
                                        }

                                        if (world instanceof Level _levelxxxxxxx) {
                                            if (!_levelxxxxxxx.isClientSide()) {
                                                _levelxxxxxxx.playSound(
                                                    (Player)null,
                                                    BlockPos.containing(x, y, z),
                                                    BuiltInRegistries.SOUND_EVENT
                                                        .get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.explode")),
                                                    SoundSource.HOSTILE,
                                                    1.0F,
                                                    1.0F
                                                );
                                            } else {
                                                _levelxxxxxxx.playLocalSound(
                                                    x,
                                                    y,
                                                    z,
                                                    BuiltInRegistries.SOUND_EVENT
                                                        .get(ResourceLocation.parse("more_critters:entity.electric_creeblossom.explode")),
                                                    SoundSource.HOSTILE,
                                                    1.0F,
                                                    1.0F,
                                                    false
                                                );
                                            }
                                        }

                                        if (world instanceof ServerLevel _levelxxxxxx) {
                                            Entity entityToSpawnx = MoreCrittersModEntities.SHOCK_CUBE_SMALL
                                                .get()
                                                .spawn(_levelxxxxxx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                            if (entityToSpawnx != null) {
                                                entityToSpawnx.setDeltaMovement(0.0, 0.0, 0.0);
                                            }
                                        }

                                        if (!entity.level().isClientSide()) {
                                            entity.discard();
                                        }
                                    }
                                );
                            }
                        } else {
                            if (world instanceof Level _levelxxxx) {
                                if (!_levelxxxx.isClientSide()) {
                                    _levelxxxx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.creeblossom.primed")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelxxxx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.creeblossom.primed")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            MoreCritters.queueServerWork(
                                20,
                                () -> {
                                    if (world instanceof Level _levelxxxxxxx && !_levelxxxxxxx.isClientSide()) {
                                        _levelxxxxxxx.explode(null, entity.getX(), entity.getY(), entity.getZ(), 1.5F, ExplosionInteraction.NONE);
                                    }

                                    if (world instanceof ServerLevel _levelxxxxxx) {
                                        _levelxxxxxx.sendParticles(
                                            MoreCrittersModParticleTypes.BLOSSOM_EXPLOSION.get(),
                                            entity.getX(),
                                            entity.getY(),
                                            entity.getZ(),
                                            1,
                                            0.0,
                                            0.0,
                                            0.0,
                                            0.0
                                        );
                                    }

                                    if (!entity.level().isClientSide()) {
                                        entity.discard();
                                    }
                                }
                            );
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                        }

                        if (entity instanceof CreeblossomEntity) {
                            ((CreeblossomEntity)entity).setAnimation("blow");
                        }

                        entity.getPersistentData().putDouble("blow", 1000.0);
                    }

                    if (((CreeblossomEntity)entity).animationprocedure.equals("blow")) {
                        if ((entity instanceof CreeblossomEntity animatablexxxx ? animatablexxxx.getTexture() : "null").equals("creeblossom")
                            || (entity instanceof CreeblossomEntity animatablexx ? animatablexx.getTexture() : "null").equals("creeblossom_friendly")) {
                            for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 10.0, 15.0); index0++) {
                                if (world instanceof ServerLevel _levelxxx) {
                                    _levelxxx.getServer()
                                        .getCommands()
                                        .performPrefixedCommand(
                                            new CommandSourceStack(
                                                    CommandSource.NULL,
                                                    new Vec3(x, y, z),
                                                    Vec2.ZERO,
                                                    _levelxxx,
                                                    4,
                                                    "",
                                                    Component.literal(""),
                                                    _levelxxx.getServer(),
                                                    null
                                                )
                                                .withSuppressedOutput(),
                                            "/particle minecraft:dust{color:[0.1,0.1,0.1],scale:1.5} ~ ~0.5 ~ 0.2 0.4 0.2 1 1 force"
                                        );
                                }
                            }
                        } else if ((entity instanceof CreeblossomEntity animatablex ? animatablex.getTexture() : "null").equals("creeblossom_electric")) {
                            for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 10.0, 15.0); index1++) {
                                if (world instanceof ServerLevel _levelx) {
                                    _levelx.sendParticles(MoreCrittersModParticleTypes.ZAP.get(), x, y, z, 1, 0.5, 0.5, 0.5, 0.0);
                                }
                            }
                        }
                    }
                }
            );
            if (entity instanceof LivingEntity _livEnt69 && _livEnt69.isBaby()) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CREEBLOSSOM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setXRot(entity.getXRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            }

            if ((entity instanceof CreeblossomEntity animatable ? animatable.getTexture() : "null").equals("creeblossom_electric")) {
                particle = Mth.nextInt(RandomSource.create(), 1, 30);
                if (particle == 1.0 && world instanceof ServerLevel _level) {
                    _level.sendParticles(MoreCrittersModParticleTypes.ZAP.get(), x, y, z, 2, 0.5, 0.5, 0.5, 0.0);
                }
            }
        }
    }
}
