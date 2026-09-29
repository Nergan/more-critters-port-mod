package com.morecritters.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.layer.LargeEchoLayer;
import com.morecritters.mod.entity.model.LargeEchoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LargeEchoRenderer extends GeoEntityRenderer<LargeEchoEntity> {
    public LargeEchoRenderer(Context renderManager) {
        super(renderManager, new LargeEchoModel());
        this.shadowRadius = 0.0F;
        this.addRenderLayer(new LargeEchoLayer(this));
    }

    public RenderType getRenderType(LargeEchoEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    public void preRender(
        PoseStack poseStack,
        LargeEchoEntity entity,
        BakedGeoModel model,
        MultiBufferSource bufferSource,
        VertexConsumer buffer,
        boolean isReRender,
        float partialTick,
        int packedLight,
        int packedOverlay,
        int colour
    ) {
        float scale = 2.0F;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}
