package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AncientSkeletonExhibitModel extends GeoModel<AncientSkeletonExhibitEntity> {
    public ResourceLocation getAnimationResource(AncientSkeletonExhibitEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/ancien_skeleton_exhibit.animation.json");
    }

    public ResourceLocation getModelResource(AncientSkeletonExhibitEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/ancien_skeleton_exhibit.geo.json");
    }

    public ResourceLocation getTextureResource(AncientSkeletonExhibitEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
