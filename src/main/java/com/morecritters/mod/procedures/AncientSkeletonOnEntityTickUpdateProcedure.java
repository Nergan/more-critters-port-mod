package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AncientSkeletonEntity;
import net.minecraft.world.entity.Entity;

public class AncientSkeletonOnEntityTickUpdateProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if ((entity instanceof AncientSkeletonEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonEntity.DATA_shroomed) : 0) == 0) {
                if (entity instanceof AncientSkeletonEntity animatable) {
                    animatable.setTexture("ancient_skeleton");
                }
            } else if ((entity instanceof AncientSkeletonEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonEntity.DATA_shroomed) : 0) == 1) {
                if (entity instanceof AncientSkeletonEntity animatable) {
                    animatable.setTexture("ancient_skeleton_mori");
                }
            } else if ((entity instanceof AncientSkeletonEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonEntity.DATA_shroomed) : 0) == 2
                && entity instanceof AncientSkeletonEntity animatable) {
                animatable.setTexture("ancient_skeleton_vita");
            }
        }
    }
}
