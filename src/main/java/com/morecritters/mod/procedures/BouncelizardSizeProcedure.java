package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class BouncelizardSizeProcedure {
    public static double execute(Entity entity) {
        if (!(entity instanceof LivingEntity living)) {
            return 1.0;
        }

        double size = entity.getPersistentData().getDouble("size");
        if (size > 0.0) {
            return size;
        }

        return living.isBaby() ? 0.3 : 1.0;
    }
}
