package com.morecritters.mod.block.model;

import com.morecritters.mod.block.display.TatteredJollyRogerDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TatteredJollyRogerDisplayModel extends GeoModel<TatteredJollyRogerDisplayItem> {
    public ResourceLocation getAnimationResource(TatteredJollyRogerDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/tattered_jolly_roger.animation.json");
    }

    public ResourceLocation getModelResource(TatteredJollyRogerDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/tattered_jolly_roger.geo.json");
    }

    public ResourceLocation getTextureResource(TatteredJollyRogerDisplayItem entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/tattered_jolly_rodger_large.png");
    }
}
