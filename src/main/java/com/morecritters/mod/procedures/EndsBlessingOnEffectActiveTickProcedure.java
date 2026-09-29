package com.morecritters.mod.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EndsBlessingOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!entity.onGround() && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 0, false, false));
            }
        }
    }
}
