package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class BlackIropodSpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            entity.getPersistentData().putDouble("shed", 12000.0);
        }
    }
}
