package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.LargeEchoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LargeEchoModel extends GeoModel<LargeEchoEntity> {
    public ResourceLocation getAnimationResource(LargeEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/tester_shriek.animation.json");
    }

    public ResourceLocation getModelResource(LargeEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/tester_shriek.geo.json");
    }

    public ResourceLocation getTextureResource(LargeEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
