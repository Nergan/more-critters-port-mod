package com.morecritters.mod.block.model;

import com.morecritters.mod.block.display.GravediggerJarDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GravediggerJarDisplayModel extends GeoModel<GravediggerJarDisplayItem> {
    public ResourceLocation getAnimationResource(GravediggerJarDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/gravedigger_jar.animation.json");
    }

    public ResourceLocation getModelResource(GravediggerJarDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/gravedigger_jar.geo.json");
    }

    public ResourceLocation getTextureResource(GravediggerJarDisplayItem entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/gravedigger_jar.png");
    }
}
