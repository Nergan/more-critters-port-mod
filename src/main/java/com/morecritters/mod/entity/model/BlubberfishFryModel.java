package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BlubberfishFryEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlubberfishFryModel extends GeoModel<BlubberfishFryEntity> {
    public ResourceLocation getAnimationResource(BlubberfishFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/blubberfish_fry.animation.json");
    }

    public ResourceLocation getModelResource(BlubberfishFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/blubberfish_fry.geo.json");
    }

    public ResourceLocation getTextureResource(BlubberfishFryEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
