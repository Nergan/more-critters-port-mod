package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.EvolightenedOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EvolightenedMobEffect extends MobEffect {
    public EvolightenedMobEffect() {
        super(MobEffectCategory.NEUTRAL, -5721382);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        EvolightenedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
