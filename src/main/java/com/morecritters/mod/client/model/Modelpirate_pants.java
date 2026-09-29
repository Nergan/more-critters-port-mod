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

public class Modelpirate_pants<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("more_critters", "modelpirate_pants"), "main");
    public final ModelPart body;
    public final ModelPart r_leg;
    public final ModelPart l_leg;

    public Modelpirate_pants(ModelPart root) {
        this.body = root.getChild("body");
        this.r_leg = root.getChild("r_leg");
        this.l_leg = root.getChild("l_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild(
            "body",
            CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.3F)),
            PartPose.offset(0.0F, 10.0F, 0.0F)
        );
        PartDefinition r_leg = partdefinition.addOrReplaceChild(
            "r_leg",
            CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)),
            PartPose.offset(-2.0F, 12.0F, 0.0F)
        );
        PartDefinition l_leg = partdefinition.addOrReplaceChild(
            "l_leg",
            CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)).mirror(false),
            PartPose.offset(2.0F, 12.0F, 0.0F)
        );
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(
        PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color
    ) {
        this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.r_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.l_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
