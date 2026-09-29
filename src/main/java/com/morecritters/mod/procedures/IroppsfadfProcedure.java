package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.IropodEntity;
import net.minecraft.world.entity.Entity;

public class IroppsfadfProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !((IropodEntity)entity).animationprocedure.equals("lock");
    }
}
