package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class AdfadProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity.isInWaterOrBubble();
    }
}
