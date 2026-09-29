package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BombJellyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BombJellyModel extends GeoModel<BombJellyEntity> {
    public ResourceLocation getAnimationResource(BombJellyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bomb_jelly_medium.animation.json");
    }

    public ResourceLocation getModelResource(BombJellyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bomb_jelly_medium.geo.json");
    }

    public ResourceLocation getTextureResource(BombJellyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
