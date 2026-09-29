package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.ShriekbatEntity;
import net.minecraft.world.entity.Entity;

public class ShriekbatlookconditionProcedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : !((ShriekbatEntity)entity).animationprocedure.equals("idle_hang") && !((ShriekbatEntity)entity).animationprocedure.equals("idle_angry");
    }
}
