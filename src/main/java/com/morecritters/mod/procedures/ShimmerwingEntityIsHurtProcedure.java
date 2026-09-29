package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.ShimmerwingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class ShimmerwingEntityIsHurtProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity.onGround()) {
                if (entity instanceof ShimmerwingEntity) {
                    ((ShimmerwingEntity)entity).setAnimation("land");
                }

                entity.setDeltaMovement(new Vec3(0.0, 0.2, 0.0));
            }
        }
    }
}
