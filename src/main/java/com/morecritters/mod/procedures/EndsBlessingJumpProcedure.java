package com.morecritters.mod.procedures;

import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class EndsBlessingJumpProcedure {
    @SubscribeEvent
    public static void onEntityJump(LivingJumpEvent event) {
        execute(event, event.getEntity());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MoreCrittersModMobEffects.ENDS_BLESSING)) {
                entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 1.0, entity.getDeltaMovement().z()));
            }
        }
    }
}
