package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ExpyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ExpyModel extends GeoModel<ExpyEntity> {
    public ResourceLocation getAnimationResource(ExpyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/expy.animation.json");
    }

    public ResourceLocation getModelResource(ExpyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/expy.geo.json");
    }

    public ResourceLocation getTextureResource(ExpyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
