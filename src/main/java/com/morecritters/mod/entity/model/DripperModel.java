package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.DripperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DripperModel extends GeoModel<DripperEntity> {
    public ResourceLocation getAnimationResource(DripperEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/dripper.animation.json");
    }

    public ResourceLocation getModelResource(DripperEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/dripper.geo.json");
    }

    public ResourceLocation getTextureResource(DripperEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
