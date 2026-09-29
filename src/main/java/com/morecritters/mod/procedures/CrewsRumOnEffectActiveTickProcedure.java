package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.entity.CorpseTankEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CrewsRumOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity) {
                _entity.removeEffect(MoreCrittersModMobEffects.CREWS_RUM);
            }

            if (!(entity instanceof CorpseCaptainEntity)
                && !(entity instanceof CorpseMateEntity)
                && !(entity instanceof CorpseLookoutEntity)
                && !(entity instanceof CorpseParrotEntity)
                && !(entity instanceof CorpseTankEntity)
                && !(entity instanceof CorpseQuartermasterEntity)) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1, false, true));
                }
            } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1, false, true));
            }
        }
    }
}
