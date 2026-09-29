package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.display.TatteredJollyRogerDisplayItem;
import com.morecritters.mod.block.model.TatteredJollyRogerDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TatteredJollyRogerDisplayItemRenderer extends GeoItemRenderer<TatteredJollyRogerDisplayItem> {
    public TatteredJollyRogerDisplayItemRenderer() {
        super(new TatteredJollyRogerDisplayModel());
    }

    public RenderType getRenderType(TatteredJollyRogerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
