package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.Model17Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Model17Model extends GeoModel<Model17Entity> {
    public ResourceLocation getAnimationResource(Model17Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/shadelet.animation.json");
    }

    public ResourceLocation getModelResource(Model17Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/shadelet.geo.json");
    }

    public ResourceLocation getTextureResource(Model17Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
