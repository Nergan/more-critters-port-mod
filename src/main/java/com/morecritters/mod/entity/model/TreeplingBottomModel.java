package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.TreeplingBottomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TreeplingBottomModel extends GeoModel<TreeplingBottomEntity> {
    public ResourceLocation getAnimationResource(TreeplingBottomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/treepling_bottom.animation.json");
    }

    public ResourceLocation getModelResource(TreeplingBottomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/treepling_bottom.geo.json");
    }

    public ResourceLocation getTextureResource(TreeplingBottomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
