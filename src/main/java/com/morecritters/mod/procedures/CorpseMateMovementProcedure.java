package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseMateEntity;
import net.minecraft.world.entity.Entity;

public class CorpseMateMovementProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !((CorpseMateEntity)entity).animationprocedure.equals("attack");
    }
}
