package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CustodianEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CustodianModel extends GeoModel<CustodianEntity> {
    public ResourceLocation getAnimationResource(CustodianEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/custodian.animation.json");
    }

    public ResourceLocation getModelResource(CustodianEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/custodian.geo.json");
    }

    public ResourceLocation getTextureResource(CustodianEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
