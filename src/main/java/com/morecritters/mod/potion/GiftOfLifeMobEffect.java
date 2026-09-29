package com.morecritters.mod.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;
import java.util.Set;
import com.morecritters.mod.procedures.GiftofliftickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class GiftOfLifeMobEffect extends MobEffect {
    public GiftOfLifeMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -2816);
    }

    @Override
    public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
        cures.add(EffectCures.PROTECTED_BY_TOTEM);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        GiftofliftickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
