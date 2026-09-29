package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.GravediggerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GravediggerModel extends GeoModel<GravediggerEntity> {
    public ResourceLocation getAnimationResource(GravediggerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/gravedigger.animation.json");
    }

    public ResourceLocation getModelResource(GravediggerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/gravedigger.geo.json");
    }

    public ResourceLocation getTextureResource(GravediggerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
