package com.morecritters.mod.block.model;

import com.morecritters.mod.block.entity.GravediggerJarTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GravediggerJarBlockModel extends GeoModel<GravediggerJarTileEntity> {
    public ResourceLocation getAnimationResource(GravediggerJarTileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/gravedigger_jar.animation.json");
    }

    public ResourceLocation getModelResource(GravediggerJarTileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/gravedigger_jar.geo.json");
    }

    public ResourceLocation getTextureResource(GravediggerJarTileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/gravedigger_jar.png");
    }
}
