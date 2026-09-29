package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.DominicEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DominicModel extends GeoModel<DominicEntity> {
    public ResourceLocation getAnimationResource(DominicEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/dominic.animation.json");
    }

    public ResourceLocation getModelResource(DominicEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/dominic.geo.json");
    }

    public ResourceLocation getTextureResource(DominicEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
