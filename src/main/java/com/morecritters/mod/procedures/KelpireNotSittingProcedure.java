package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.KelpireEntity;
import net.minecraft.world.entity.Entity;

public class KelpireNotSittingProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof KelpireEntity _datEntL0 && _datEntL0.getEntityData().get(KelpireEntity.DATA_sit));
    }
}
