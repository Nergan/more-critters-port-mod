package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.NervoidEntity;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class NervoidOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            if (entity.getPersistentData().getDouble("attack") == 1.0) {
                entity.getPersistentData().putDouble("attack", 100.0);
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                    && entity instanceof LivingEntity _liveEnt
                    && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                    && _liveEnt.hasLineOfSight(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)) {
                    if (entity instanceof NervoidEntity) {
                        ((NervoidEntity)entity).setAnimation("attack_start");
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nervoid.rush_ready")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nervoid.rush_ready")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    MoreCritters.queueServerWork(
                        12,
                        () -> {
                            if (entity instanceof NervoidEntity) {
                                ((NervoidEntity)entity).setAnimation("attack_rush");
                            }

                            if (world instanceof Level _levelx) {
                                if (!_levelx.isClientSide()) {
                                    _levelx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nervoid.rush_start")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nervoid.rush_start")),
                                        SoundSource.HOSTILE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            MoreCritters.queueServerWork(40, () -> {
                                if (entity instanceof NervoidEntity) {
                                    ((NervoidEntity)entity).setAnimation("empty");
                                }
                            });
                        }
                    );
                }
            }

            if (((NervoidEntity)entity).animationprocedure.equals("attack_start")) {
                entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            }

            if (((NervoidEntity)entity).animationprocedure.equals("attack_rush")) {
                entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.4, entity.getLookAngle().y * 0.4, entity.getLookAngle().z * 0.4));
            }

            if ((entity instanceof NervoidEntity animatable ? animatable.getTexture() : "null").equals("nervoid_wet")) {
                rate = Mth.nextInt(RandomSource.create(), 1, 3);
                if (rate == 1.0 && world instanceof ServerLevel _level) {
                    _level.sendParticles(MoreCrittersModParticleTypes.SPINAL_FLUID.get(), x, y + 1.0, z, 1, 0.5, 0.5, 0.5, 0.0);
                }
            }
        }
    }
}
