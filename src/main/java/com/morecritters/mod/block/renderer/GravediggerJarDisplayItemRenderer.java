package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.display.GravediggerJarDisplayItem;
import com.morecritters.mod.block.model.GravediggerJarDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GravediggerJarDisplayItemRenderer extends GeoItemRenderer<GravediggerJarDisplayItem> {
    public GravediggerJarDisplayItemRenderer() {
        super(new GravediggerJarDisplayModel());
    }

    public RenderType getRenderType(GravediggerJarDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
