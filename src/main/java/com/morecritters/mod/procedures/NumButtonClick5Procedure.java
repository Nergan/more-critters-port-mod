package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class NumButtonClick5Procedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("num", 4.0);
        }
    }
}
