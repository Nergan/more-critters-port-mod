package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.MangotriceEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MangotriceModel extends GeoModel<MangotriceEntity> {
    public ResourceLocation getAnimationResource(MangotriceEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/mangotrice.animation.json");
    }

    public ResourceLocation getModelResource(MangotriceEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/mangotrice.geo.json");
    }

    public ResourceLocation getTextureResource(MangotriceEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
