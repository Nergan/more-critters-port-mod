package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.EchoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EchoModel extends GeoModel<EchoEntity> {
    public ResourceLocation getAnimationResource(EchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/tester_shriek.animation.json");
    }

    public ResourceLocation getModelResource(EchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/tester_shriek.geo.json");
    }

    public ResourceLocation getTextureResource(EchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
