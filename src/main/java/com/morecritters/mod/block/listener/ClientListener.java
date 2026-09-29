package com.morecritters.mod.block.listener;

import com.morecritters.mod.block.renderer.ConfettiPopperTileRenderer;
import com.morecritters.mod.block.renderer.GravediggerJarTileRenderer;
import com.morecritters.mod.block.renderer.ShipWheelTileRenderer;
import com.morecritters.mod.block.renderer.TatteredJollyRogerTileRenderer;
import com.morecritters.mod.init.MoreCrittersModBlockEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = "more_critters", bus = Bus.MOD, value = Dist.CLIENT)
public class ClientListener {
    @SubscribeEvent
    public static void registerRenderers(RegisterRenderers event) {
        event.registerBlockEntityRenderer(MoreCrittersModBlockEntities.TATTERED_JOLLY_ROGER.get(), context -> new TatteredJollyRogerTileRenderer());
        event.registerBlockEntityRenderer(MoreCrittersModBlockEntities.SHIP_WHEEL.get(), context -> new ShipWheelTileRenderer());
        event.registerBlockEntityRenderer(MoreCrittersModBlockEntities.CONFETTI_POPPER.get(), context -> new ConfettiPopperTileRenderer());
        event.registerBlockEntityRenderer(MoreCrittersModBlockEntities.GRAVEDIGGER_JAR.get(), context -> new GravediggerJarTileRenderer());
    }
}
