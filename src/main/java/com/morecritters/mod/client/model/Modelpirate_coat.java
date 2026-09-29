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

public class Modelpirate_coat<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("more_critters", "modelpirate_coat"), "main");
    public final ModelPart body;
    public final ModelPart r_arm;
    public final ModelPart l_arm;

    public Modelpirate_coat(ModelPart root) {
        this.body = root.getChild("body");
        this.r_arm = root.getChild("r_arm");
        this.l_arm = root.getChild("l_arm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild(
            "body",
            CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -0.5F, -2.5F, 9.0F, 18.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offset(0.0F, 0.0F, 0.0F)
        );
        PartDefinition r_arm = partdefinition.addOrReplaceChild(
            "r_arm",
            CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -2.25F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
            PartPose.offset(-5.5F, 2.0F, 0.0F)
        );
        PartDefinition l_arm = partdefinition.addOrReplaceChild(
            "l_arm",
            CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.0F, -2.25F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false),
            PartPose.offset(5.5F, 2.0F, 0.0F)
        );
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(
        PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color
    ) {
        this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.r_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.l_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
