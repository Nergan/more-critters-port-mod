package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class BabySlablizardOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("grow", 24000.0);
        }
    }
}
