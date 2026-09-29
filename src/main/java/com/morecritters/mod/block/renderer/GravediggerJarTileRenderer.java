package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.entity.GravediggerJarTileEntity;
import com.morecritters.mod.block.model.GravediggerJarBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GravediggerJarTileRenderer extends GeoBlockRenderer<GravediggerJarTileEntity> {
    public GravediggerJarTileRenderer() {
        super(new GravediggerJarBlockModel());
    }

    public RenderType getRenderType(GravediggerJarTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
