package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.OpalcrabEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpalcrabModel extends GeoModel<OpalcrabEntity> {
    public ResourceLocation getAnimationResource(OpalcrabEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/opalcrab.animation.json");
    }

    public ResourceLocation getModelResource(OpalcrabEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/opalcrab.geo.json");
    }

    public ResourceLocation getTextureResource(OpalcrabEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
