package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.AnniveteranEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnniveteranModel extends GeoModel<AnniveteranEntity> {
    public ResourceLocation getAnimationResource(AnniveteranEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/anniveteran.animation.json");
    }

    public ResourceLocation getModelResource(AnniveteranEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/anniveteran.geo.json");
    }

    public ResourceLocation getTextureResource(AnniveteranEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
