package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class ConditionShimmerwingProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null) {
            return false;
        }

        double shimmer = 0.0;
        return !(entity.getPersistentData().getDouble("teleport") > 1.0);
    }
}
