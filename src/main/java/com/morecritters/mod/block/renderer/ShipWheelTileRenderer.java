package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.entity.ShipWheelTileEntity;
import com.morecritters.mod.block.model.ShipWheelBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ShipWheelTileRenderer extends GeoBlockRenderer<ShipWheelTileEntity> {
    public ShipWheelTileRenderer() {
        super(new ShipWheelBlockModel());
    }

    public RenderType getRenderType(ShipWheelTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
