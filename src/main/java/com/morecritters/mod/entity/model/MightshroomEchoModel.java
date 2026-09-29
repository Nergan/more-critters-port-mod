package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.MightshroomEchoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MightshroomEchoModel extends GeoModel<MightshroomEchoEntity> {
    public ResourceLocation getAnimationResource(MightshroomEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/mightshroom_echo.animation.json");
    }

    public ResourceLocation getModelResource(MightshroomEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/mightshroom_echo.geo.json");
    }

    public ResourceLocation getTextureResource(MightshroomEchoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
