package com.morecritters.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.morecritters.mod.entity.SnowflakeSpiderEntity;
import com.morecritters.mod.entity.layer.SnowflakeSpiderLayer;
import com.morecritters.mod.entity.model.SnowflakeSpiderModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SnowflakeSpiderRenderer extends GeoEntityRenderer<SnowflakeSpiderEntity> {
    public SnowflakeSpiderRenderer(Context renderManager) {
        super(renderManager, new SnowflakeSpiderModel());
        this.shadowRadius = 0.5F;
        this.addRenderLayer(new SnowflakeSpiderLayer(this));
    }

    public RenderType getRenderType(SnowflakeSpiderEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    public void preRender(
        PoseStack poseStack,
        SnowflakeSpiderEntity entity,
        BakedGeoModel model,
        MultiBufferSource bufferSource,
        VertexConsumer buffer,
        boolean isReRender,
        float partialTick,
        int packedLight,
        int packedOverlay,
        int colour
    ) {
        float scale = 1.0F;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}
