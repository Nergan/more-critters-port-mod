package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.GillmunchEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GillmunchModel extends GeoModel<GillmunchEntity> {
    public ResourceLocation getAnimationResource(GillmunchEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/gillmunch.animation.json");
    }

    public ResourceLocation getModelResource(GillmunchEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/gillmunch.geo.json");
    }

    public ResourceLocation getTextureResource(GillmunchEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
