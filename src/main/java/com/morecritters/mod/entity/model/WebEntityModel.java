package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.WebEntityEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WebEntityModel extends GeoModel<WebEntityEntity> {
    public ResourceLocation getAnimationResource(WebEntityEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/web_entity.animation.json");
    }

    public ResourceLocation getModelResource(WebEntityEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/web_entity.geo.json");
    }

    public ResourceLocation getTextureResource(WebEntityEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
