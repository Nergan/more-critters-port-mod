package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CritterAtlasModelEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CritterAtlasModelModel extends GeoModel<CritterAtlasModelEntity> {
    public ResourceLocation getAnimationResource(CritterAtlasModelEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/critter_atlas.animation.json");
    }

    public ResourceLocation getModelResource(CritterAtlasModelEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/critter_atlas.geo.json");
    }

    public ResourceLocation getTextureResource(CritterAtlasModelEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
