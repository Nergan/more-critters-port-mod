package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.FrostbiteOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

public class FrostbiteMobEffect extends MobEffect {
    public FrostbiteMobEffect() {
        super(MobEffectCategory.HARMFUL, -13580549);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        FrostbiteOnEffectActiveTickProcedure.execute(entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
