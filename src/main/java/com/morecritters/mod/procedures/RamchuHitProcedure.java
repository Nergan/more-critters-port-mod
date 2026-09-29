package com.morecritters.mod.procedures;

import javax.annotation.Nullable;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.RamchuEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class RamchuHitProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity sourceentity) {
        execute(null, world, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
        if (sourceentity != null) {
            if (sourceentity instanceof RamchuEntity) {
                sourceentity.setDeltaMovement(new Vec3(-0.4 * sourceentity.getLookAngle().x, 0.0, -0.4 * sourceentity.getLookAngle().z));
                if (sourceentity instanceof RamchuEntity) {
                    ((RamchuEntity)sourceentity).setAnimation("empty");
                }

                MoreCritters.queueServerWork(
                    1,
                    () -> MoreCritters.queueServerWork(
                        1,
                        () -> MoreCritters.queueServerWork(1, () -> MoreCritters.queueServerWork(1, () -> MoreCritters.queueServerWork(1, () -> {})))
                    )
                );
            }
        }
    }
}
