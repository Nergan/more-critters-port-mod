package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.BlossomingOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BlossomingMobEffect extends MobEffect {
    public BlossomingMobEffect() {
        super(MobEffectCategory.HARMFUL, -8808142);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        BlossomingOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
