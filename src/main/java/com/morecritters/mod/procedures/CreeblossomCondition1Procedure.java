package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class CreeblossomCondition1Procedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity.getPersistentData().getDouble("recruit") == 0.0;
    }
}
