package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class NumButtonClick4Procedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("num", 3.0);
        }
    }
}
