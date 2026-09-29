package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.ArmossilloEntity;
import net.minecraft.world.entity.Entity;

public class ArmossilloFollowProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof ArmossilloEntity _datEntL0 && _datEntL0.getEntityData().get(ArmossilloEntity.DATA_sitting));
    }
}
