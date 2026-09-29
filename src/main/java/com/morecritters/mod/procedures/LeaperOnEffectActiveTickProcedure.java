package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AvoiderEntity;
import net.minecraft.world.entity.Entity;

public class LeaperOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof AvoiderEntity) {
                ((AvoiderEntity)entity).setAnimation("jump_start");
            }
        }
    }
}
