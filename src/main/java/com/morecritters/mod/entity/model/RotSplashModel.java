package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.RotSplashEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RotSplashModel extends GeoModel<RotSplashEntity> {
    public ResourceLocation getAnimationResource(RotSplashEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/rot_splash.animation.json");
    }

    public ResourceLocation getModelResource(RotSplashEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/rot_splash.geo.json");
    }

    public ResourceLocation getTextureResource(RotSplashEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
