package com.morecritters.mod.block.renderer;

import com.morecritters.mod.block.entity.TatteredJollyRogerTileEntity;
import com.morecritters.mod.block.model.TatteredJollyRogerBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TatteredJollyRogerTileRenderer extends GeoBlockRenderer<TatteredJollyRogerTileEntity> {
    public TatteredJollyRogerTileRenderer() {
        super(new TatteredJollyRogerBlockModel());
    }

    public RenderType getRenderType(TatteredJollyRogerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
