package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import net.minecraft.world.entity.Entity;

public class AncientSkeletonExhibitSolidBoundingBoxConditionProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity instanceof AncientSkeletonExhibitEntity;
    }
}
