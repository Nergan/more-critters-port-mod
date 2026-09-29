package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ResinPuddleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ResinPuddleModel extends GeoModel<ResinPuddleEntity> {
    public ResourceLocation getAnimationResource(ResinPuddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/resin_puddle.animation.json");
    }

    public ResourceLocation getModelResource(ResinPuddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/resin_puddle.geo.json");
    }

    public ResourceLocation getTextureResource(ResinPuddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
