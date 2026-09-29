package com.morecritters.mod.procedures;

import javax.annotation.Nullable;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.SnowflakeSpiderEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class SnowflakeSpiderAttackProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(Entity entity, Entity sourceentity) {
        execute(null, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (sourceentity instanceof SnowflakeSpiderEntity
                && ServerConfig.CONFIG.frostbite.get()
                && entity instanceof LivingEntity _entity
                && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.FROSTBITE, 200, 0, false, true));
            }
        }
    }
}
