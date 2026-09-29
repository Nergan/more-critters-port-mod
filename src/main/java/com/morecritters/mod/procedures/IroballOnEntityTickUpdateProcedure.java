package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.IroballEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class IroballOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
                if (entity.onGround()) {
                    if (entity instanceof IroballEntity) {
                        ((IroballEntity)entity).setAnimation("walk");
                    }
                } else if (entity instanceof IroballEntity) {
                    ((IroballEntity)entity).setAnimation("fly");
                }
            } else if (entity instanceof IroballEntity) {
                ((IroballEntity)entity).setAnimation("idle");
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator != entity && !(entityiterator instanceof IroballEntity) && entityiterator instanceof LivingEntity) {
                    entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()));
                    entity.setDeltaMovement(
                        new Vec3(entityiterator.getLookAngle().x * 2.0, entityiterator.getLookAngle().y * 1.0, entityiterator.getLookAngle().z * 2.0)
                    );
                }
            }

            if (entity.onGround()) {
                entity.getPersistentData().putDouble("flying", 0.0);
            } else {
                entity.getPersistentData().putDouble("flying", entity.getPersistentData().getDouble("flying") + 1.0);
            }

            if (entity.getPersistentData().getDouble("flying") >= 2.0) {
                Vec3 _center2 = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center2, _center2).inflate(0.5), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center2)))
                    .toList()) {
                    if (entityiterator != entity && !(entityiterator instanceof IroballEntity) && entityiterator instanceof LivingEntity) {
                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iroball.hit")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iroball.hit")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (entity instanceof IroballEntity _datEntL27 && _datEntL27.getEntityData().get(IroballEntity.DATA_sturdy)) {
                            entityiterator.hurt(
                                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 20.0F
                            );
                        } else {
                            entityiterator.hurt(
                                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 10.0F
                            );
                        }
                    }
                }
            }

            if (entity instanceof IroballEntity _datEntL33 && _datEntL33.getEntityData().get(IroballEntity.DATA_sturdy)) {
                if (entity instanceof IroballEntity animatable) {
                    animatable.setTexture("sturdy_iroball");
                }
            } else if (entity instanceof IroballEntity animatable) {
                animatable.setTexture("iroball");
            }
        }
    }
}
