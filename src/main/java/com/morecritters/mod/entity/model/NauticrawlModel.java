package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.NauticrawlEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NauticrawlModel extends GeoModel<NauticrawlEntity> {
    public ResourceLocation getAnimationResource(NauticrawlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/nauticrawl.animation.json");
    }

    public ResourceLocation getModelResource(NauticrawlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/nauticrawl.geo.json");
    }

    public ResourceLocation getTextureResource(NauticrawlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
