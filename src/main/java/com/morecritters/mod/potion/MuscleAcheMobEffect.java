package com.morecritters.mod.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class MuscleAcheMobEffect extends MobEffect {
    public MuscleAcheMobEffect() {
        super(MobEffectCategory.HARMFUL, -5225165);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
