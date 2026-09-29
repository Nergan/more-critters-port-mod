package com.morecritters.mod.procedures;

import net.minecraft.tags.EntityTypeTags;
import java.util.Comparator;
import com.morecritters.mod.entity.ResinPuddleEntity;
import com.morecritters.mod.entity.TreepletEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ResinPuddleOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("animation", entity.getPersistentData().getDouble("animation") - 1.0);
            if (entity.getPersistentData().getDouble("animation") <= 0.0) {
                entity.getPersistentData().putDouble("animation", 5.0);
                if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle1")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle2");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle2")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle3");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle3")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle4");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle4")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle5");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle5")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle6");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle6")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle7");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle7")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle8");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle8")) {
                    if (entity instanceof ResinPuddleEntity animatable) {
                        animatable.setTexture("resin_puddle9");
                    }
                } else if ((entity instanceof ResinPuddleEntity animatable ? animatable.getTexture() : "null").equals("resin_puddle9")
                    && !entity.level().isClientSide()) {
                    entity.discard();
                }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (!(entityiterator instanceof ResinPuddleEntity)) {
                    if (entityiterator instanceof TreepletEntity) {
                        entityiterator.push(0.2 * entityiterator.getLookAngle().x, 0.0, 0.2 * entityiterator.getLookAngle().z);
                    } else if (entity instanceof LivingEntity _livEnt27 && _livEnt27.getType().is(EntityTypeTags.UNDEAD)
                        || entity instanceof LivingEntity _livEnt28 && _livEnt28.getType().is(EntityTypeTags.ARTHROPOD)) {
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1, false, false));
                        }
                    } else if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 2, false, false));
                    }
                }
            }

            entity.setDeltaMovement(new Vec3(0.0, -2.0, 0.0));
        }
    }
}
