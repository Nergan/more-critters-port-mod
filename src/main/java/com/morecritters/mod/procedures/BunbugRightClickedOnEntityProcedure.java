package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BunbugEntity;
import net.minecraft.world.entity.Entity;

public class BunbugRightClickedOnEntityProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof BunbugEntity) {
                ((BunbugEntity)entity).setAnimation("dig_down");
            }
        }
    }
}
