package com.morecritters.mod.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class EvoliteMawOnEntityTickUpdateProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!entity.onGround()) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
                }

                entity.setDeltaMovement(new Vec3(0.0, -2.0, 0.0));
            } else if (entity instanceof LivingEntity _entity) {
                _entity.removeAllEffects();
            }

            if (entity.isInWall() && !entity.level().isClientSide()) {
                entity.discard();
            }

            entity.getPersistentData().putDouble("despawning", entity.getPersistentData().getDouble("despawning") - 1.0);
            if (entity.getPersistentData().getDouble("despawning") == -1.0 && !entity.level().isClientSide()) {
                entity.discard();
            }
        }
    }
}
