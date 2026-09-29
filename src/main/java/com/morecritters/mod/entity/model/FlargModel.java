package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.FlargEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FlargModel extends GeoModel<FlargEntity> {
    public ResourceLocation getAnimationResource(FlargEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/flarg.animation.json");
    }

    public ResourceLocation getModelResource(FlargEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/flarg.geo.json");
    }

    public ResourceLocation getTextureResource(FlargEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
