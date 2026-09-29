package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ChatteringTeethEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ChatteringTeethModel extends GeoModel<ChatteringTeethEntity> {
    public ResourceLocation getAnimationResource(ChatteringTeethEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/chattering_teeth.animation.json");
    }

    public ResourceLocation getModelResource(ChatteringTeethEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/chattering_teeth.geo.json");
    }

    public ResourceLocation getTextureResource(ChatteringTeethEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(ChatteringTeethEntity animatable, long instanceId, AnimationState<ChatteringTeethEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
