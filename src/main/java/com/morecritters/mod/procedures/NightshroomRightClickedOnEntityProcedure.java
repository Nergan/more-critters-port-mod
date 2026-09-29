package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.NightshroomEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;

public class NightshroomRightClickedOnEntityProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)) {
                if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.getOwner() : null) == sourceentity) {
                    if (entity instanceof NightshroomEntity _datEntL3 && _datEntL3.getEntityData().get(NightshroomEntity.DATA_sit)) {
                        if (entity instanceof NightshroomEntity _datEntSetL) {
                            _datEntSetL.getEntityData().set(NightshroomEntity.DATA_sit, false);
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 30, false, false));
                        }

                        if (entity instanceof NightshroomEntity) {
                            ((NightshroomEntity)entity).setAnimation("sit_rise");
                        }
                    } else if (entity instanceof NightshroomEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(NightshroomEntity.DATA_sit, true);
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
