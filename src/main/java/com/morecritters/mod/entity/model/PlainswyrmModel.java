package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.PlainswyrmEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlainswyrmModel extends GeoModel<PlainswyrmEntity> {
    public ResourceLocation getAnimationResource(PlainswyrmEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/plainswyrm.animation.json");
    }

    public ResourceLocation getModelResource(PlainswyrmEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/plainswyrm.geo.json");
    }

    public ResourceLocation getTextureResource(PlainswyrmEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
