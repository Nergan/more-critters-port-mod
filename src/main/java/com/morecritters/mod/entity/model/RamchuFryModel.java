package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.RamchuFryEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RamchuFryModel extends GeoModel<RamchuFryEntity> {
    public ResourceLocation getAnimationResource(RamchuFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/ramchu_fry.animation.json");
    }

    public ResourceLocation getModelResource(RamchuFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/ramchu_fry.geo.json");
    }

    public ResourceLocation getTextureResource(RamchuFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
