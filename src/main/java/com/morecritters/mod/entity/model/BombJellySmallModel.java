package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BombJellySmallEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BombJellySmallModel extends GeoModel<BombJellySmallEntity> {
    public ResourceLocation getAnimationResource(BombJellySmallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bomb_jelly.animation.json");
    }

    public ResourceLocation getModelResource(BombJellySmallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bomb_jelly.geo.json");
    }

    public ResourceLocation getTextureResource(BombJellySmallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
