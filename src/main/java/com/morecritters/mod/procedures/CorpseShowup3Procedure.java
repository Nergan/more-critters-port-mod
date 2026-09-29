package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class CorpseShowup3Procedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity.getPersistentData().getDouble("num") == 2.0;
    }
}
