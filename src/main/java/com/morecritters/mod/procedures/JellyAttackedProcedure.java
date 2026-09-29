package com.morecritters.mod.procedures;

import javax.annotation.Nullable;
import com.morecritters.mod.entity.BombJellyLargeEntity;
import com.morecritters.mod.entity.BombJellyMediumEntity;
import com.morecritters.mod.entity.BombJellySmallEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class JellyAttackedProcedure {
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
            if (entity instanceof BombJellySmallEntity
                && !entity.isInWaterOrBubble()
                && !entity.isInWaterOrBubble()
                && !((BombJellySmallEntity)entity).animationprocedure.equals("fall")) {
                entity.lookAt(Anchor.EYES, new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()));
            }

            if (entity instanceof BombJellyMediumEntity
                && !entity.isInWaterOrBubble()
                && !entity.isInWaterOrBubble()
                && !((BombJellyMediumEntity)entity).animationprocedure.equals("fall")) {
                entity.lookAt(Anchor.EYES, new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()));
            }

            if (entity instanceof BombJellyLargeEntity
                && !entity.isInWaterOrBubble()
                && !entity.isInWaterOrBubble()
                && !((BombJellyLargeEntity)entity).animationprocedure.equals("fall")) {
                entity.lookAt(Anchor.EYES, new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()));
            }
        }
    }
}
