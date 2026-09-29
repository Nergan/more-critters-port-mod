package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BouncelizardEntity;
import net.minecraft.world.entity.Entity;

public class NotSneakingProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof BouncelizardEntity _datEntL0 && _datEntL0.getEntityData().get(BouncelizardEntity.DATA_sleeping));
    }
}
