package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class AsdassadProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity.getPersistentData().getDouble("run") > 0.0;
    }
}
