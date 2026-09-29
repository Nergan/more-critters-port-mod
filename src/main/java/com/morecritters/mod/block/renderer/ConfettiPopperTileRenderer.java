package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.entity.ConfettiPopperTileEntity;
import com.morecritters.mod.block.model.ConfettiPopperBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ConfettiPopperTileRenderer extends GeoBlockRenderer<ConfettiPopperTileEntity> {
    public ConfettiPopperTileRenderer() {
        super(new ConfettiPopperBlockModel());
    }

    public RenderType getRenderType(ConfettiPopperTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
