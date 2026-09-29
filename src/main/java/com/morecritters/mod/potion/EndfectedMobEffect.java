package com.morecritters.mod.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class EndfectedMobEffect extends MobEffect {
    public EndfectedMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -4685313);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
