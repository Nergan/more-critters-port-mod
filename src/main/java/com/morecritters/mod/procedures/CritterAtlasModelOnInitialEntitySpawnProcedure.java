package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class CritterAtlasModelOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!entity.level().isClientSide()) {
                entity.discard();
            }
        }
    }
}
