package com.morecritters.mod.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ShriekResistanceMobEffect extends MobEffect {
    public ShriekResistanceMobEffect() {
        super(MobEffectCategory.NEUTRAL, -6998189);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
