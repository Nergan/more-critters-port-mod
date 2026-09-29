package com.morecritters.mod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelnautical_helmet<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("more_critters", "modelnautical_helmet"), "main");
    public final ModelPart head;

    public Modelnautical_helmet(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild(
            "head",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-4.0F, -8.25F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F))
                .texOffs(1, 13)
                .addBox(-3.5F, -12.25F, -3.0F, 0.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13)
                .addBox(3.5F, -12.25F, -3.0F, 0.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13)
                .addBox(0.0F, -12.25F, -3.0F, 0.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0)
                .addBox(-4.0F, 0.5F, 4.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -1.0F, 0.0F)
        );
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(
        PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color
    ) {
        this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
