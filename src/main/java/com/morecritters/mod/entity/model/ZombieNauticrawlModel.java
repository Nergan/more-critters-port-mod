package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ZombieNauticrawlEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZombieNauticrawlModel extends GeoModel<ZombieNauticrawlEntity> {
    public ResourceLocation getAnimationResource(ZombieNauticrawlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/nauticrawl_zombie.animation.json");
    }

    public ResourceLocation getModelResource(ZombieNauticrawlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/nauticrawl_zombie.geo.json");
    }

    public ResourceLocation getTextureResource(ZombieNauticrawlEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
