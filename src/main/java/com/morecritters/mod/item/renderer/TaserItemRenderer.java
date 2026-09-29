package com.morecritters.mod.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashSet;
import java.util.Set;
import com.morecritters.mod.item.TaserItem;
import com.morecritters.mod.item.model.TaserItemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TaserItemRenderer extends GeoItemRenderer<TaserItem> {
    private static final float SCALE_RECIPROCAL = 0.0625F;
    protected boolean renderArms = false;
    protected MultiBufferSource currentBuffer;
    protected RenderType renderType;
    public ItemDisplayContext transformType;
    protected TaserItem animatable;
    private final Set<String> hiddenBones = new HashSet<>();
    private final Set<String> suppressedBones = new HashSet<>();

    public TaserItemRenderer() {
        super(new TaserItemModel());
    }

    public RenderType getRenderType(TaserItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void renderByItem(
        ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int p_239207_6_
    ) {
        this.transformType = transformType;
        super.renderByItem(stack, transformType, matrixStack, bufferIn, combinedLightIn, p_239207_6_);
    }

    public void actuallyRender(
        PoseStack matrixStackIn,
        TaserItem animatable,
        BakedGeoModel model,
        RenderType type,
        MultiBufferSource renderTypeBuffer,
        VertexConsumer vertexBuilder,
        boolean isRenderer,
        float partialTicks,
        int packedLightIn,
        int packedOverlayIn,
        int colour
    ) {
        this.currentBuffer = renderTypeBuffer;
        this.renderType = type;
        this.animatable = animatable;
        super.actuallyRender(matrixStackIn, animatable, model, type, renderTypeBuffer, vertexBuilder, isRenderer, partialTicks, packedLightIn, packedOverlayIn, colour);
        if (this.renderArms) {
            this.renderArms = false;
        }
    }

    public ResourceLocation getTextureLocation(TaserItem instance) {
        return super.getTextureLocation(instance);
    }
}
