package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ShockCubeSmallEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShockCubeSmallModel extends GeoModel<ShockCubeSmallEntity> {
    public ResourceLocation getAnimationResource(ShockCubeSmallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/shock_cube.animation.json");
    }

    public ResourceLocation getModelResource(ShockCubeSmallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/shock_cube.geo.json");
    }

    public ResourceLocation getTextureResource(ShockCubeSmallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
