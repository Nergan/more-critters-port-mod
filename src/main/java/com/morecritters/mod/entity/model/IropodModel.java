package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.IropodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IropodModel extends GeoModel<IropodEntity> {
    public ResourceLocation getAnimationResource(IropodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/iropod.animation.json");
    }

    public ResourceLocation getModelResource(IropodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/iropod.geo.json");
    }

    public ResourceLocation getTextureResource(IropodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
