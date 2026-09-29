package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BlubberfishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlubberfishModel extends GeoModel<BlubberfishEntity> {
    public ResourceLocation getAnimationResource(BlubberfishEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/blubberfish.animation.json");
    }

    public ResourceLocation getModelResource(BlubberfishEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/blubberfish.geo.json");
    }

    public ResourceLocation getTextureResource(BlubberfishEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
