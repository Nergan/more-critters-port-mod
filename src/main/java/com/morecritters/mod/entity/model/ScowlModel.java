package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ScowlEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScowlModel extends GeoModel<ScowlEntity> {
    public ResourceLocation getAnimationResource(ScowlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/scowl.animation.json");
    }

    public ResourceLocation getModelResource(ScowlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/scowl.geo.json");
    }

    public ResourceLocation getTextureResource(ScowlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
