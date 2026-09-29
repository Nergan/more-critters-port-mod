package com.morecritters.mod.init;

import com.morecritters.mod.client.model.Modelarmor_layer_1;
import com.morecritters.mod.client.model.Modelelectric_bullet;
import com.morecritters.mod.client.model.Modeliropod_helmet;
import com.morecritters.mod.client.model.Modelnautical_boots;
import com.morecritters.mod.client.model.Modelnautical_helmet;
import com.morecritters.mod.client.model.Modelparty_hat;
import com.morecritters.mod.client.model.Modelpirate_boots;
import com.morecritters.mod.client.model.Modelpirate_coat;
import com.morecritters.mod.client.model.Modelpirate_pants;
import com.morecritters.mod.client.model.Modelrot_piece;
import com.morecritters.mod.client.model.Modelsplinter;
import com.morecritters.mod.client.model.Modeltricorne;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class MoreCrittersModModels {
    @SubscribeEvent
    public static void registerLayerDefinitions(RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Modelnautical_boots.LAYER_LOCATION, Modelnautical_boots::createBodyLayer);
        event.registerLayerDefinition(Modelsplinter.LAYER_LOCATION, Modelsplinter::createBodyLayer);
        event.registerLayerDefinition(Modelelectric_bullet.LAYER_LOCATION, Modelelectric_bullet::createBodyLayer);
        event.registerLayerDefinition(Modelpirate_boots.LAYER_LOCATION, Modelpirate_boots::createBodyLayer);
        event.registerLayerDefinition(Modelnautical_helmet.LAYER_LOCATION, Modelnautical_helmet::createBodyLayer);
        event.registerLayerDefinition(Modelpirate_pants.LAYER_LOCATION, Modelpirate_pants::createBodyLayer);
        event.registerLayerDefinition(Modeliropod_helmet.LAYER_LOCATION, Modeliropod_helmet::createBodyLayer);
        event.registerLayerDefinition(Modelpirate_coat.LAYER_LOCATION, Modelpirate_coat::createBodyLayer);
        event.registerLayerDefinition(Modelrot_piece.LAYER_LOCATION, Modelrot_piece::createBodyLayer);
        event.registerLayerDefinition(Modelparty_hat.LAYER_LOCATION, Modelparty_hat::createBodyLayer);
        event.registerLayerDefinition(Modeltricorne.LAYER_LOCATION, Modeltricorne::createBodyLayer);
        event.registerLayerDefinition(Modelarmor_layer_1.LAYER_LOCATION, Modelarmor_layer_1::createBodyLayer);
    }
}
