package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class EchoSizeProcedure {
    public static double execute(Entity entity) {
        return entity == null ? 0.0 : entity.getPersistentData().getDouble("size");
    }
}
