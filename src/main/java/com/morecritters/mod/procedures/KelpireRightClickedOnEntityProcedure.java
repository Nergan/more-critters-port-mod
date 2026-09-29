package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.KelpireEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;

public class KelpireRightClickedOnEntityProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == sourceentity) {
                if (entity instanceof KelpireEntity _datEntL3 && _datEntL3.getEntityData().get(KelpireEntity.DATA_sit)) {
                    if (entity instanceof KelpireEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(KelpireEntity.DATA_sit, false);
                    }

                    if (entity instanceof KelpireEntity) {
                        ((KelpireEntity)entity).setAnimation("sit_end");
                    }
                } else if (entity instanceof KelpireEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(KelpireEntity.DATA_sit, true);
                }
            }
        }
    }
}
