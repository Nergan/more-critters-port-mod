package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CritterEaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CritterEaterModel extends GeoModel<CritterEaterEntity> {
    public ResourceLocation getAnimationResource(CritterEaterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/critter_eater.animation.json");
    }

    public ResourceLocation getModelResource(CritterEaterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/critter_eater.geo.json");
    }

    public ResourceLocation getTextureResource(CritterEaterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
