package com.morecritters.mod.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class RumBottlePlayerFinishesUsingItemProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            rate = Mth.nextInt(RandomSource.create(), 1, 10);
            if (rate <= 7.0 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 0, false, true));
            }

            if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.CONFUSION)) {
                entity.hurt(
                    new DamageSource(
                        world.registryAccess()
                            .registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("more_critters:liver_failure")))
                    ),
                    (float)Mth.nextDouble(RandomSource.create(), 3.0, 7.0)
                );
            }
        }
    }
}
