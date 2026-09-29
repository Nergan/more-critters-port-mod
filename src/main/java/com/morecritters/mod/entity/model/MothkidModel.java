package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.MothkidEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MothkidModel extends GeoModel<MothkidEntity> {
    public ResourceLocation getAnimationResource(MothkidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/mothkid.animation.json");
    }

    public ResourceLocation getModelResource(MothkidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/mothkid.geo.json");
    }

    public ResourceLocation getTextureResource(MothkidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
