package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.CritterEaterEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
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

public class CritterEaterOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("walk", entity.getPersistentData().getDouble("walk") - 1.0);
            if (entity.getPersistentData().getDouble("walk") == 1.0) {
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    entity.getPersistentData().putDouble("walk", Mth.nextInt(RandomSource.create(), 20, 40));
                    if ((entity instanceof CritterEaterEntity animatable ? animatable.getTexture() : "null").equals("critter_eater")
                        && entity instanceof CritterEaterEntity animatable) {
                        animatable.setTexture("critter_eater_open");
                    }
                } else {
                    entity.getPersistentData().putDouble("walk", Mth.nextInt(RandomSource.create(), 60, 250));
                    if ((entity instanceof CritterEaterEntity animatable ? animatable.getTexture() : "null").equals("critter_eater_open")
                        && entity instanceof CritterEaterEntity animatable) {
                        animatable.setTexture("critter_eater");
                    }
                }

                if (entity instanceof CritterEaterEntity) {
                    ((CritterEaterEntity)entity).setAnimation("walk1");
                }

                MoreCritters.queueServerWork(
                    10,
                    () -> {
                        entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 1.2, entity.getLookAngle().y * 1.2, entity.getLookAngle().z * 1.2));
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.critter_eater.move")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.critter_eater.move")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (entity instanceof CritterEaterEntity) {
                            ((CritterEaterEntity)entity).setAnimation("walk2");
                        }
                    }
                );
            }
        }
    }
}
