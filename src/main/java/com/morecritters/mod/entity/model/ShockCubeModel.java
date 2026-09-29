package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ShockCubeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShockCubeModel extends GeoModel<ShockCubeEntity> {
    public ResourceLocation getAnimationResource(ShockCubeEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/shock_cube.animation.json");
    }

    public ResourceLocation getModelResource(ShockCubeEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/shock_cube.geo.json");
    }

    public ResourceLocation getTextureResource(ShockCubeEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
