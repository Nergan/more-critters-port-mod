package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import net.minecraft.world.entity.Entity;

public class AncientSkeletonExhibitOnEntityTickUpdateProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0) == 0) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose1");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 1) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose2");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 2) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose3");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 3) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose4");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 4) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose5");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 5) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose6");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 6) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose7");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 7) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose8");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                == 8) {
                if (entity instanceof AncientSkeletonExhibitEntity) {
                    ((AncientSkeletonExhibitEntity)entity).setAnimation("pose9");
                }
            } else if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                    == 9
                && entity instanceof AncientSkeletonExhibitEntity) {
                ((AncientSkeletonExhibitEntity)entity).setAnimation("pose10");
            }
        }
    }
}
