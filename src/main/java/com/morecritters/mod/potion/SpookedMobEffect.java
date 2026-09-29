package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.SpookedEffectStartedappliedProcedure;
import com.morecritters.mod.procedures.SpookedOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SpookedMobEffect extends MobEffect {
    public SpookedMobEffect() {
        super(MobEffectCategory.HARMFUL, -7484710);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        SpookedEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        SpookedOnEffectActiveTickProcedure.execute();
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
