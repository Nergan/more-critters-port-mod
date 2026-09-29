package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.MoriRootsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MoriRootsModel extends GeoModel<MoriRootsEntity> {
    public ResourceLocation getAnimationResource(MoriRootsEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/mori_roots.animation.json");
    }

    public ResourceLocation getModelResource(MoriRootsEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/mori_roots.geo.json");
    }

    public ResourceLocation getTextureResource(MoriRootsEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
