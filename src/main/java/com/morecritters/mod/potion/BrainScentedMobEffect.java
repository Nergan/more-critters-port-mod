package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.BrainScentedOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BrainScentedMobEffect extends MobEffect {
    public BrainScentedMobEffect() {
        super(MobEffectCategory.HARMFUL, -5465);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        BrainScentedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
