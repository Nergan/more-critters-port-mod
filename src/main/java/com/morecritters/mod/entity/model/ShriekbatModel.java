package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ShriekbatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShriekbatModel extends GeoModel<ShriekbatEntity> {
    public ResourceLocation getAnimationResource(ShriekbatEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/shriekbat.animation.json");
    }

    public ResourceLocation getModelResource(ShriekbatEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/shriekbat.geo.json");
    }

    public ResourceLocation getTextureResource(ShriekbatEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
