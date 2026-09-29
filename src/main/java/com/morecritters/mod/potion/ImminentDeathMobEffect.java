package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.ImminentDeathOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ImminentDeathMobEffect extends MobEffect {
    public ImminentDeathMobEffect() {
        super(MobEffectCategory.HARMFUL, -15199480);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        ImminentDeathOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
