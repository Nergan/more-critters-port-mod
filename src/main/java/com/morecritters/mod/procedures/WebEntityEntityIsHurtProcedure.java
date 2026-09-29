package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.WebEntityEntity;
import net.minecraft.world.entity.Entity;

public class WebEntityEntityIsHurtProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof WebEntityEntity) {
                ((WebEntityEntity)entity).setAnimation("hurt");
            }
        }
    }
}
