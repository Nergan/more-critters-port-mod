package com.morecritters.mod.block.model;

import com.morecritters.mod.block.display.ConfettiPopperDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ConfettiPopperDisplayModel extends GeoModel<ConfettiPopperDisplayItem> {
    public ResourceLocation getAnimationResource(ConfettiPopperDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/confetti_popper.animation.json");
    }

    public ResourceLocation getModelResource(ConfettiPopperDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/confetti_popper.geo.json");
    }

    public ResourceLocation getTextureResource(ConfettiPopperDisplayItem entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/confetti_popper.png");
    }
}
