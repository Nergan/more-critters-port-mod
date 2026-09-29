package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.RamchuEntity;
import net.minecraft.world.entity.Entity;

public class RamchuAttackConditionProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : ((RamchuEntity)entity).animationprocedure.equals("ram");
    }
}
