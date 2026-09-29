package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.StincarpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StincarpModel extends GeoModel<StincarpEntity> {
    public ResourceLocation getAnimationResource(StincarpEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/stingcarp.animation.json");
    }

    public ResourceLocation getModelResource(StincarpEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/stingcarp.geo.json");
    }

    public ResourceLocation getTextureResource(StincarpEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
