package com.morecritters.mod.item.model;

import com.morecritters.mod.item.TazegunItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TazegunItemModel extends GeoModel<TazegunItem> {
    public ResourceLocation getAnimationResource(TazegunItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/tazegun.animation.json");
    }

    public ResourceLocation getModelResource(TazegunItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/tazegun.geo.json");
    }

    public ResourceLocation getTextureResource(TazegunItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/item/tazegun.png");
    }
}
