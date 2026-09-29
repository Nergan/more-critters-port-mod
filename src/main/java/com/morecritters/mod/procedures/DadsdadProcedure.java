package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BlackIropodEntity;
import net.minecraft.world.entity.Entity;

public class DadsdadProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !((BlackIropodEntity)entity).animationprocedure.equals("lock");
    }
}
