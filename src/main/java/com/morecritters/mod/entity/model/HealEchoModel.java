package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.HealEchoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HealEchoModel extends GeoModel<HealEchoEntity> {
    public ResourceLocation getAnimationResource(HealEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/heal_echo.animation.json");
    }

    public ResourceLocation getModelResource(HealEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/heal_echo.geo.json");
    }

    public ResourceLocation getTextureResource(HealEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
