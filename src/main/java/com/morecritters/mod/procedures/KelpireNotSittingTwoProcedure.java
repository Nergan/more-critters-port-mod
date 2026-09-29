package com.morecritters.mod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;

public class KelpireNotSittingTwoProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false);
    }
}
