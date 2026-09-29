package com.morecritters.mod.procedures;

import net.neoforged.bus.api.ICancellableEvent;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.entity.ResinPuddleEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.SlashEffectEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class ZoglinHurtsEffectEntityProcedure {
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
            double rate = 0.0;
            if (entity instanceof AncientSkeletonEntity
                || entity instanceof EchoEntity
                || entity instanceof HealEchoEntity
                || entity instanceof LargeEchoEntity
                || entity instanceof MoriRootsEntity
                || entity instanceof ShockCubeEntity
                || entity instanceof ShockCubeSmallEntity
                || entity instanceof WebEntityEntity
                || entity instanceof ResinPuddleEntity
                || entity instanceof SlashEffectEntity
                || entity instanceof AncientSkeletonExhibitEntity) {
                if (event instanceof ICancellableEvent _cancellable) {
                    _cancellable.setCanceled(true);
                }
            }
        }
    }
}
