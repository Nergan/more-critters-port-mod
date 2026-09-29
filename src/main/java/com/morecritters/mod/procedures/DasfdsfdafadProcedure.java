package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BalloonRatEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class DasfdsfdafadProcedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : !(entity instanceof BalloonRatEntity _datEntL0 && _datEntL0.getEntityData().get(BalloonRatEntity.DATA_sit))
                && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity);
    }
}
