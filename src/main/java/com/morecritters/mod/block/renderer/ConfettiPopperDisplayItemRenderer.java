package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.display.ConfettiPopperDisplayItem;
import com.morecritters.mod.block.model.ConfettiPopperDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ConfettiPopperDisplayItemRenderer extends GeoItemRenderer<ConfettiPopperDisplayItem> {
    public ConfettiPopperDisplayItemRenderer() {
        super(new ConfettiPopperDisplayModel());
    }

    public RenderType getRenderType(ConfettiPopperDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
