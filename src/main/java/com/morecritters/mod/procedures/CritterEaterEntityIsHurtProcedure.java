package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CritterEaterEntity;
import net.minecraft.world.entity.Entity;

public class CritterEaterEntityIsHurtProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!((CritterEaterEntity)entity).animationprocedure.equals("walk1")
                && !((CritterEaterEntity)entity).animationprocedure.equals("walk2")
                && entity instanceof CritterEaterEntity) {
                ((CritterEaterEntity)entity).setAnimation("hurt");
            }
        }
    }
}
