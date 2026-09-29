package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.TesterShriekEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TesterShriekModel extends GeoModel<TesterShriekEntity> {
    public ResourceLocation getAnimationResource(TesterShriekEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/tester_shriek.animation.json");
    }

    public ResourceLocation getModelResource(TesterShriekEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/tester_shriek.geo.json");
    }

    public ResourceLocation getTextureResource(TesterShriekEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
