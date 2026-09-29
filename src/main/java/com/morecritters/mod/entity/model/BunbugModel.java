package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BunbugEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BunbugModel extends GeoModel<BunbugEntity> {
    public ResourceLocation getAnimationResource(BunbugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bunbug.animation.json");
    }

    public ResourceLocation getModelResource(BunbugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bunbug.geo.json");
    }

    public ResourceLocation getTextureResource(BunbugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
