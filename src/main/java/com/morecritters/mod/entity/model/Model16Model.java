package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.Model16Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Model16Model extends GeoModel<Model16Entity> {
    public ResourceLocation getAnimationResource(Model16Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/nauticrawl_atlas_model.animation.json");
    }

    public ResourceLocation getModelResource(Model16Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/nauticrawl_atlas_model.geo.json");
    }

    public ResourceLocation getTextureResource(Model16Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }
}
