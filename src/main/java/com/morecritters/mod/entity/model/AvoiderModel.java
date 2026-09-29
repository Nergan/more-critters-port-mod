package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.AvoiderEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AvoiderModel extends GeoModel<AvoiderEntity> {
    public ResourceLocation getAnimationResource(AvoiderEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/avoider.animation.json");
    }

    public ResourceLocation getModelResource(AvoiderEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/avoider.geo.json");
    }

    public ResourceLocation getTextureResource(AvoiderEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
