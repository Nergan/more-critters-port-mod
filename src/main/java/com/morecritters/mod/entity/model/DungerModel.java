package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.DungerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DungerModel extends GeoModel<DungerEntity> {
    public ResourceLocation getAnimationResource(DungerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/dunger.animation.json");
    }

    public ResourceLocation getModelResource(DungerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/dunger.geo.json");
    }

    public ResourceLocation getTextureResource(DungerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
