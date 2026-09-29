package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class CorpseShowup2Procedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity.getPersistentData().getDouble("num") == 1.0;
    }
}
