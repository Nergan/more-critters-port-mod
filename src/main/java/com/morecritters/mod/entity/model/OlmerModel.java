package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.OlmerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OlmerModel extends GeoModel<OlmerEntity> {
    public ResourceLocation getAnimationResource(OlmerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/olmer.animation.json");
    }

    public ResourceLocation getModelResource(OlmerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/olmer.geo.json");
    }

    public ResourceLocation getTextureResource(OlmerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
