package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.HallucinaziumEffectStartedappliedProcedure;
import com.morecritters.mod.procedures.HallucinaziumOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class HallucinaziumMobEffect extends MobEffect {
    public HallucinaziumMobEffect() {
        super(MobEffectCategory.HARMFUL, -29702);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        HallucinaziumEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        HallucinaziumOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
