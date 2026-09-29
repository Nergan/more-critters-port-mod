package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CubefrogEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CubefrogModel extends GeoModel<CubefrogEntity> {
    public ResourceLocation getAnimationResource(CubefrogEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/cubefrog.animation.json");
    }

    public ResourceLocation getModelResource(CubefrogEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/cubefrog.geo.json");
    }

    public ResourceLocation getTextureResource(CubefrogEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
