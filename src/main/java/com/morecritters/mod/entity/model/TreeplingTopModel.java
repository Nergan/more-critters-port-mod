package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.TreeplingTopEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TreeplingTopModel extends GeoModel<TreeplingTopEntity> {
    public ResourceLocation getAnimationResource(TreeplingTopEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/treepling_top.animation.json");
    }

    public ResourceLocation getModelResource(TreeplingTopEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/treepling_top.geo.json");
    }

    public ResourceLocation getTextureResource(TreeplingTopEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
