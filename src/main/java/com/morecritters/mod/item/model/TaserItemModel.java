package com.morecritters.mod.item.model;

import com.morecritters.mod.item.TaserItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TaserItemModel extends GeoModel<TaserItem> {
    public ResourceLocation getAnimationResource(TaserItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/taser.animation.json");
    }

    public ResourceLocation getModelResource(TaserItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/taser.geo.json");
    }

    public ResourceLocation getTextureResource(TaserItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/item/taser.png");
    }
}
