package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.StalkEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StalkModel extends GeoModel<StalkEntity> {
    public ResourceLocation getAnimationResource(StalkEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/stalk.animation.json");
    }

    public ResourceLocation getModelResource(StalkEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/stalk.geo.json");
    }

    public ResourceLocation getTextureResource(StalkEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
