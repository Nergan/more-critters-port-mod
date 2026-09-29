package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.BrittlenessOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BrittlenessMobEffect extends MobEffect {
    public BrittlenessMobEffect() {
        super(MobEffectCategory.HARMFUL, -10462905);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        BrittlenessOnEffectActiveTickProcedure.execute(entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
