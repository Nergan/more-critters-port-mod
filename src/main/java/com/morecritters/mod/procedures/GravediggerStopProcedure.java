package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.GravediggerEntity;
import net.minecraft.world.entity.Entity;

public class GravediggerStopProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !((GravediggerEntity)entity).animationprocedure.equals("dig_down");
    }
}
