package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.NightshroomEntity;
import net.minecraft.world.entity.Entity;

public class IfNotSittingProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof NightshroomEntity _datEntL0 && _datEntL0.getEntityData().get(NightshroomEntity.DATA_sit));
    }
}
