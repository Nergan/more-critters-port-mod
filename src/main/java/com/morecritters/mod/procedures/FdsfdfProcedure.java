package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.TreepletEntity;
import net.minecraft.world.entity.Entity;

public class FdsfdfProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !((TreepletEntity)entity).animationprocedure.equals("spin");
    }
}
