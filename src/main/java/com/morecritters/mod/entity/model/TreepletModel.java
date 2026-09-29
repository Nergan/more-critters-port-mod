package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.TreepletEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TreepletModel extends GeoModel<TreepletEntity> {
    public ResourceLocation getAnimationResource(TreepletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/treeplet.animation.json");
    }

    public ResourceLocation getModelResource(TreepletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/treeplet.geo.json");
    }

    public ResourceLocation getTextureResource(TreepletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
