package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BlackIropodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlackIropodModel extends GeoModel<BlackIropodEntity> {
    public ResourceLocation getAnimationResource(BlackIropodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/iropod_black.animation.json");
    }

    public ResourceLocation getModelResource(BlackIropodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/iropod_black.geo.json");
    }

    public ResourceLocation getTextureResource(BlackIropodEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
