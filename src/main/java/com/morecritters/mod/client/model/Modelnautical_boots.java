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

public class Modelnautical_boots<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("more_critters", "modelnautical_boots"), "main");
    public final ModelPart l_leg;
    public final ModelPart r_leg;

    public Modelnautical_boots(ModelPart root) {
        this.l_leg = root.getChild("l_leg");
        this.r_leg = root.getChild("r_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition l_leg = partdefinition.addOrReplaceChild(
            "l_leg",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.0F, 5.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F))
                .texOffs(0, 11)
                .addBox(0.0F, 6.0F, 2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(2.0F, 12.0F, 0.0F)
        );
        PartDefinition r_leg = partdefinition.addOrReplaceChild(
            "r_leg",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .mirror()
                .addBox(-2.0F, 5.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F))
                .mirror(false)
                .texOffs(0, 11)
                .mirror()
                .addBox(0.0F, 6.0F, 2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(-2.0F, 12.0F, 0.0F)
        );
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(
        PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color
    ) {
        this.l_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        this.r_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
