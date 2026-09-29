package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.SmallHealEchoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmallHealEchoModel extends GeoModel<SmallHealEchoEntity> {
    public ResourceLocation getAnimationResource(SmallHealEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/heal_echo.animation.json");
    }

    public ResourceLocation getModelResource(SmallHealEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/heal_echo.geo.json");
    }

    public ResourceLocation getTextureResource(SmallHealEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
