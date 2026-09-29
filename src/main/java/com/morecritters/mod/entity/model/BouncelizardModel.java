package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BouncelizardEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BouncelizardModel extends GeoModel<BouncelizardEntity> {
    public ResourceLocation getAnimationResource(BouncelizardEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bouncelizard.animation.json");
    }

    public ResourceLocation getModelResource(BouncelizardEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bouncelizard.geo.json");
    }

    public ResourceLocation getTextureResource(BouncelizardEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
