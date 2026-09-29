package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.NightshroomEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class AsdsadadProcedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)
                && !(entity instanceof NightshroomEntity _datEntL2 && _datEntL2.getEntityData().get(NightshroomEntity.DATA_sit));
    }
}
