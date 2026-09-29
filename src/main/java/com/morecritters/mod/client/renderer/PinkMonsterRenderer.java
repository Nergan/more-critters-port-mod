package com.morecritters.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.morecritters.mod.entity.PinkMonsterEntity;
import com.morecritters.mod.entity.layer.PinkMonsterLayer;
import com.morecritters.mod.entity.model.PinkMonsterModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PinkMonsterRenderer extends GeoEntityRenderer<PinkMonsterEntity> {
    public PinkMonsterRenderer(Context renderManager) {
        super(renderManager, new PinkMonsterModel());
        this.shadowRadius = 0.0F;
        this.addRenderLayer(new PinkMonsterLayer(this));
    }

    public RenderType getRenderType(PinkMonsterEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    public void preRender(
        PoseStack poseStack,
        PinkMonsterEntity entity,
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
