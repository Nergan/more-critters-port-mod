package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BubbleEntityEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BubbleEntityModel extends GeoModel<BubbleEntityEntity> {
    public ResourceLocation getAnimationResource(BubbleEntityEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bubble_entity.animation.json");
    }

    public ResourceLocation getModelResource(BubbleEntityEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bubble_entity.geo.json");
    }

    public ResourceLocation getTextureResource(BubbleEntityEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
