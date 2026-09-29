package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BombJellyLargeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BombJellyLargeModel extends GeoModel<BombJellyLargeEntity> {
    public ResourceLocation getAnimationResource(BombJellyLargeEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bomb_jelly_large.animation.json");
    }

    public ResourceLocation getModelResource(BombJellyLargeEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bomb_jelly_large.geo.json");
    }

    public ResourceLocation getTextureResource(BombJellyLargeEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
