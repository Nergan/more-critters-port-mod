package com.morecritters.mod.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class IropodHelmetHelmetTickEventProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity.isShiftKeyDown() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1, 0, false, true));
            }

            if (entity.isInWaterRainOrBubble() && entity.onGround() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1, 2, false, true));
            }
        }
    }
}
