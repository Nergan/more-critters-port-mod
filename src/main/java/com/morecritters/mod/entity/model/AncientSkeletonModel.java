package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.AncientSkeletonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AncientSkeletonModel extends GeoModel<AncientSkeletonEntity> {
    public ResourceLocation getAnimationResource(AncientSkeletonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/ancien_skeleton.animation.json");
    }

    public ResourceLocation getModelResource(AncientSkeletonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/ancien_skeleton.geo.json");
    }

    public ResourceLocation getTextureResource(AncientSkeletonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
