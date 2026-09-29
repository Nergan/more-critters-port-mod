package com.morecritters.mod.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class OiledUpMobEffect extends MobEffect {
    public OiledUpMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -2638721);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
