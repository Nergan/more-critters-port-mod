package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.SnowflakeSpiderEntity;
import net.minecraft.world.entity.Entity;

public class FrostbiteOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!(entity instanceof SnowflakeSpiderEntity)) {
                entity.setTicksFrozen(200);
            }
        }
    }
}
