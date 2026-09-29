package com.morecritters.mod.block.model;

import com.morecritters.mod.block.entity.ConfettiPopperTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ConfettiPopperBlockModel extends GeoModel<ConfettiPopperTileEntity> {
    public ResourceLocation getAnimationResource(ConfettiPopperTileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/confetti_popper.animation.json");
    }

    public ResourceLocation getModelResource(ConfettiPopperTileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/confetti_popper.geo.json");
    }

    public ResourceLocation getTextureResource(ConfettiPopperTileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/confetti_popper.png");
    }
}
