package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.TreeplingMiddleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TreeplingMiddleModel extends GeoModel<TreeplingMiddleEntity> {
    public ResourceLocation getAnimationResource(TreeplingMiddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/treepling_middle.animation.json");
    }

    public ResourceLocation getModelResource(TreeplingMiddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/treepling_middle.geo.json");
    }

    public ResourceLocation getTextureResource(TreeplingMiddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
