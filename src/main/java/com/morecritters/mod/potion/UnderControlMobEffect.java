package com.morecritters.mod.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;
import java.util.Set;
import com.morecritters.mod.procedures.UnderControlEffectExpiresProcedure;
import com.morecritters.mod.procedures.UnderControlOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class UnderControlMobEffect extends MobEffect implements EffectRemovedCallback {
    public UnderControlMobEffect() {
        super(MobEffectCategory.HARMFUL, -2065926);
    }

    @Override
    public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
        cures.add(EffectCures.PROTECTED_BY_TOTEM);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        UnderControlOnEffectActiveTickProcedure.execute(entity);
        return true;
    }

    @Override
    public void onEffectRemoved(LivingEntity entity, int amplifier) {
        UnderControlEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
