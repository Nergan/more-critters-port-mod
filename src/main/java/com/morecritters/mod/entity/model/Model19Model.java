package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.Model19Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Model19Model extends GeoModel<Model19Entity> {
    public ResourceLocation getAnimationResource(Model19Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/nervoid_atlas_model.animation.json");
    }

    public ResourceLocation getModelResource(Model19Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/nervoid_atlas_model.geo.json");
    }

    public ResourceLocation getTextureResource(Model19Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
