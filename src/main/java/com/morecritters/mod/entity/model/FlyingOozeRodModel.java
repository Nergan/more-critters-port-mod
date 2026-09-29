package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.FlyingOozeRodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FlyingOozeRodModel extends GeoModel<FlyingOozeRodEntity> {
    public ResourceLocation getAnimationResource(FlyingOozeRodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/ooze_rod.animation.json");
    }

    public ResourceLocation getModelResource(FlyingOozeRodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/ooze_rod.geo.json");
    }

    public ResourceLocation getTextureResource(FlyingOozeRodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
