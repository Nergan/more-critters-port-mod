package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.display.ShipWheelDisplayItem;
import com.morecritters.mod.block.model.ShipWheelDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ShipWheelDisplayItemRenderer extends GeoItemRenderer<ShipWheelDisplayItem> {
    public ShipWheelDisplayItemRenderer() {
        super(new ShipWheelDisplayModel());
    }

    public RenderType getRenderType(ShipWheelDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
