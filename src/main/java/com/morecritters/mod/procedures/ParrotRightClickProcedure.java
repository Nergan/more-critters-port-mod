package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.TamedCorpseParrotEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;

public class ParrotRightClickProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)) {
                if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == sourceentity) {
                    if (entity instanceof TamedCorpseParrotEntity _datEntL3 && _datEntL3.getEntityData().get(TamedCorpseParrotEntity.DATA_sit)) {
                        if (entity instanceof TamedCorpseParrotEntity _datEntSetL) {
                            _datEntSetL.getEntityData().set(TamedCorpseParrotEntity.DATA_sit, false);
                        }

                        if (entity instanceof TamedCorpseParrotEntity) {
                            ((TamedCorpseParrotEntity)entity).setAnimation("sitting_end");
                        }
                    } else if (entity instanceof TamedCorpseParrotEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(TamedCorpseParrotEntity.DATA_sit, true);
                    }
                }
            } else if (!(entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame())
                && entity instanceof TamableAnimal _toTame
                && sourceentity instanceof Player _owner) {
                _toTame.tame(_owner);
            }
        }
    }
}
