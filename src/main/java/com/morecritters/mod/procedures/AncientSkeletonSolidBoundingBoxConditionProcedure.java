package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AncientSkeletonEntity;
import net.minecraft.world.entity.Entity;

public class AncientSkeletonSolidBoundingBoxConditionProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity instanceof AncientSkeletonEntity;
    }
}
