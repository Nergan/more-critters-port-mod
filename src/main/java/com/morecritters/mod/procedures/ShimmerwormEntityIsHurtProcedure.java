package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.ShimmerwormEntity;
import net.minecraft.world.entity.Entity;

public class ShimmerwormEntityIsHurtProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof ShimmerwormEntity) {
                ((ShimmerwormEntity)entity).setAnimation("hurt");
            }
        }
    }
}
