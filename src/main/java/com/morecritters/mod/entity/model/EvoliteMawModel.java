package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.EvoliteMawEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EvoliteMawModel extends GeoModel<EvoliteMawEntity> {
    public ResourceLocation getAnimationResource(EvoliteMawEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/evolite_maw.animation.json");
    }

    public ResourceLocation getModelResource(EvoliteMawEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/evolite_maw.geo.json");
    }

    public ResourceLocation getTextureResource(EvoliteMawEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
