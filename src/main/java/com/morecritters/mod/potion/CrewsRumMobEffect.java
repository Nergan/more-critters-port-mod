package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.CrewsRumOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CrewsRumMobEffect extends MobEffect {
    public CrewsRumMobEffect() {
        super(MobEffectCategory.HARMFUL, -1283302);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        CrewsRumOnEffectActiveTickProcedure.execute(entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
