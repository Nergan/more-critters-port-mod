package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;

public class Parrotafa2Procedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !entity.onGround();
    }
}
