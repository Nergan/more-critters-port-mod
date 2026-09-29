package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AnniveteranEntity;
import net.minecraft.world.entity.Entity;

public class AnniveteranEntityIsHurtProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof AnniveteranEntity) {
                ((AnniveteranEntity)entity).setAnimation("empty");
            }

            if (entity instanceof AnniveteranEntity) {
                ((AnniveteranEntity)entity).setAnimation("hurt");
            }
        }
    }
}
