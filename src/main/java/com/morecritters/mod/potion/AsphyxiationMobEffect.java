package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.AsphyxiationOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class AsphyxiationMobEffect extends MobEffect {
    public AsphyxiationMobEffect() {
        super(MobEffectCategory.HARMFUL, -8922625);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        AsphyxiationOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
