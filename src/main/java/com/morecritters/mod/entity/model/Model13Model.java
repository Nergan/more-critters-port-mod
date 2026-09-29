package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.Model13Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Model13Model extends GeoModel<Model13Entity> {
    public ResourceLocation getAnimationResource(Model13Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/iropod_atlas_model.animation.json");
    }

    public ResourceLocation getModelResource(Model13Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/iropod_atlas_model.geo.json");
    }

    public ResourceLocation getTextureResource(Model13Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
