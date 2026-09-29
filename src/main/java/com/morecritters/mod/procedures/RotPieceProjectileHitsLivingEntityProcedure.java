package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class RotPieceProjectileHitsLivingEntityProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.ROT_COVERED, 60, 0, false, false));
            }
        }
    }
}
