package com.morecritters.mod.block.model;

import com.morecritters.mod.block.display.ShipWheelDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShipWheelDisplayModel extends GeoModel<ShipWheelDisplayItem> {
    public ResourceLocation getAnimationResource(ShipWheelDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/ship_wheel.animation.json");
    }

    public ResourceLocation getModelResource(ShipWheelDisplayItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/ship_wheel.geo.json");
    }

    public ResourceLocation getTextureResource(ShipWheelDisplayItem entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/ship_wheel.png");
    }
}
