package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CustodianEntity;
import net.minecraft.world.entity.Entity;

public class CustodianClosedConditionProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof CustodianEntity _datEntL0 && _datEntL0.getEntityData().get(CustodianEntity.DATA_closed));
    }
}
