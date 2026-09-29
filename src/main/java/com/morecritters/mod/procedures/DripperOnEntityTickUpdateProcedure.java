package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.DripperEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
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

public class DripperOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            entity.getPersistentData().putDouble("roll", entity.getPersistentData().getDouble("roll") - 1.0);
            if (entity.getPersistentData().getDouble("roll") == 1.0) {
                entity.getPersistentData().putDouble("roll", Mth.nextInt(RandomSource.create(), 60, 150));
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                    && 4.0F
                        < (
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) != null
                                ? entity.distanceTo(entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null)
                                : -1.0F
                        )) {
                    if (entity instanceof Mob _entity) {
                        _entity.getNavigation().stop();
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.dripper.jump")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.dripper.jump")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof Mob _entity) {
                        _entity.getNavigation()
                            .moveTo(
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY(),
                                (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ(),
                                1.0
                            );
                    }

                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 1.5, 0.8, entity.getLookAngle().z * 1.5));
                    if (entity instanceof DripperEntity) {
                        ((DripperEntity)entity).setAnimation("roll");
                    }
                }
            }

            if (((DripperEntity)entity).animationprocedure.equals("roll")) {
                if (entity.onGround() || entity.isInWaterOrBubble()) {
                    MoreCritters.queueServerWork(2, () -> {
                        if (entity instanceof DripperEntity) {
                            ((DripperEntity)entity).setAnimation("empty");
                        }
                    });
                }

                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    if (entity instanceof Mob _entity) {
                        _entity.getNavigation().stop();
                    }

                    entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY(),
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                        )
                    );
                }
            }

            if (!entity.getDisplayName().getString().equals("murmurtal!") && !entity.getDisplayName().getString().equals("Murmurtal!")) {
                if (entity instanceof DripperEntity animatable) {
                    animatable.setTexture("dripper");
                }
            } else if (entity instanceof DripperEntity animatable) {
                animatable.setTexture("dripper_murmurtal");
            }
        }
    }
}
