package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.WarptrapEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class WarpyDigProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            MoreCritters.queueServerWork(25, () -> {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 30, false, false));
                }

                if (entity instanceof WarptrapEntity) {
                    ((WarptrapEntity)entity).setAnimation("dig");
                }
            });
        }
    }
}
