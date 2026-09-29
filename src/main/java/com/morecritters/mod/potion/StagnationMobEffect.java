package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.StagnationEffectStartedappliedProcedure;
import com.morecritters.mod.procedures.StagnationOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class StagnationMobEffect extends MobEffect {
    public StagnationMobEffect() {
        super(MobEffectCategory.HARMFUL, -10352118);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        StagnationEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        StagnationOnEffectActiveTickProcedure.execute(entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
