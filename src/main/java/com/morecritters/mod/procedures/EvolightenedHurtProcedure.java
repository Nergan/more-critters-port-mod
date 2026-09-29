package com.morecritters.mod.procedures;

import net.neoforged.bus.api.ICancellableEvent;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class EvolightenedHurtProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity());
        }
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MoreCrittersModMobEffects.EVOLIGHTENED)) {
                if (event instanceof ICancellableEvent _cancellable) {
                    _cancellable.setCanceled(true);
                }
            }
        }
    }
}
