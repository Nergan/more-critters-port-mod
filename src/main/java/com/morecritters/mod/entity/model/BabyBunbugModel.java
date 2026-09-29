package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BabyBunbugEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BabyBunbugModel extends GeoModel<BabyBunbugEntity> {
    public ResourceLocation getAnimationResource(BabyBunbugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/bunbug_baby.animation.json");
    }

    public ResourceLocation getModelResource(BabyBunbugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/bunbug_baby.geo.json");
    }

    public ResourceLocation getTextureResource(BabyBunbugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
