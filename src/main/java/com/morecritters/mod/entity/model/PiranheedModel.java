package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.PiranheedEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PiranheedModel extends GeoModel<PiranheedEntity> {
    public ResourceLocation getAnimationResource(PiranheedEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/piranheed.animation.json");
    }

    public ResourceLocation getModelResource(PiranheedEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/piranheed.geo.json");
    }

    public ResourceLocation getTextureResource(PiranheedEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
