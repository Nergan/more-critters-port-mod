package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CorpseCrewEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CorpseCrewModel extends GeoModel<CorpseCrewEntity> {
    public ResourceLocation getAnimationResource(CorpseCrewEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/corpse_mate.animation.json");
    }

    public ResourceLocation getModelResource(CorpseCrewEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/corpse_mate.geo.json");
    }

    public ResourceLocation getTextureResource(CorpseCrewEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
