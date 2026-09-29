package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.AncientCustodianEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AncientCustodianModel extends GeoModel<AncientCustodianEntity> {
    public ResourceLocation getAnimationResource(AncientCustodianEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/ancient_custodian.animation.json");
    }

    public ResourceLocation getModelResource(AncientCustodianEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/ancient_custodian.geo.json");
    }

    public ResourceLocation getTextureResource(AncientCustodianEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
