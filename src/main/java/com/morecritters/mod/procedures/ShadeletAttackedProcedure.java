package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class ShadeletAttackedProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            entity.setDeltaMovement(new Vec3(sourceentity.getLookAngle().x * 1.0, sourceentity.getLookAngle().y * 1.0, sourceentity.getLookAngle().z * 1.0));
        }
    }
}
