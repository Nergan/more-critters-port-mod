package com.morecritters.mod.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class RotCoveredMobEffect extends MobEffect {
    public RotCoveredMobEffect() {
        super(MobEffectCategory.NEUTRAL, -15790578);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
