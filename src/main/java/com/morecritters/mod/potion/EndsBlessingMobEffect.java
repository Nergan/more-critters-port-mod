package com.morecritters.mod.potion;

import com.morecritters.mod.procedures.EndsBlessingEffectStartedappliedProcedure;
import com.morecritters.mod.procedures.EndsBlessingOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

public class EndsBlessingMobEffect extends MobEffect {
    public EndsBlessingMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -3502103);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        EndsBlessingEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        EndsBlessingOnEffectActiveTickProcedure.execute(entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
