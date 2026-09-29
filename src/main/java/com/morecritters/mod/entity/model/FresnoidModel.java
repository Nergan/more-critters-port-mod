package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.FresnoidEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FresnoidModel extends GeoModel<FresnoidEntity> {
    public ResourceLocation getAnimationResource(FresnoidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/fresnoid.animation.json");
    }

    public ResourceLocation getModelResource(FresnoidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/fresnoid.geo.json");
    }

    public ResourceLocation getTextureResource(FresnoidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
