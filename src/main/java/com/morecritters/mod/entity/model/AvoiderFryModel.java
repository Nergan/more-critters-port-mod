package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.AvoiderFryEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AvoiderFryModel extends GeoModel<AvoiderFryEntity> {
    public ResourceLocation getAnimationResource(AvoiderFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/avoider_fry.animation.json");
    }

    public ResourceLocation getModelResource(AvoiderFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/avoider_fry.geo.json");
    }

    public ResourceLocation getTextureResource(AvoiderFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
