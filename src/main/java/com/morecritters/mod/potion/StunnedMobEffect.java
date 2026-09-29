package com.morecritters.mod.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;
import java.util.Set;
import java.util.function.Consumer;
import com.morecritters.mod.procedures.StunnedEffectStartedappliedProcedure;
import com.morecritters.mod.procedures.StunnedOnEffectActiveTickProcedure;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;

public class StunnedMobEffect extends MobEffect {
    public StunnedMobEffect() {
        super(MobEffectCategory.NEUTRAL, -9216);
    }

    @Override
    public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
        cures.add(EffectCures.PROTECTED_BY_TOTEM);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        StunnedEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        StunnedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
        consumer.accept(
            new IClientMobEffectExtensions() {
                @Override
                public boolean isVisibleInInventory(MobEffectInstance effect) {
                    return false;
                }

                @Override
                public boolean renderInventoryText(
                    MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset
                ) {
                    return false;
                }

                @Override
                public boolean isVisibleInGui(MobEffectInstance effect) {
                    return false;
                }
            }
        );
    }
}
