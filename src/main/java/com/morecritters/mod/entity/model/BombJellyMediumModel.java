package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BombJellyMediumEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BombJellyMediumModel extends GeoModel<BombJellyMediumEntity> {
    public ResourceLocation getAnimationResource(BombJellyMediumEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bomb_jelly_medium.animation.json");
    }

    public ResourceLocation getModelResource(BombJellyMediumEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bomb_jelly_medium.geo.json");
    }

    public ResourceLocation getTextureResource(BombJellyMediumEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
