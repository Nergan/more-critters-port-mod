package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.CombustionOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CombustionMobEffect extends MobEffect {
    public CombustionMobEffect() {
        super(MobEffectCategory.HARMFUL, -2414809);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        CombustionOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
