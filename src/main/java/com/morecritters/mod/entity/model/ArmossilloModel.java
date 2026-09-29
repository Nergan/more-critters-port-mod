package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ArmossilloEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ArmossilloModel extends GeoModel<ArmossilloEntity> {
    public ResourceLocation getAnimationResource(ArmossilloEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/armossillo.animation.json");
    }

    public ResourceLocation getModelResource(ArmossilloEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/armossillo.geo.json");
    }

    public ResourceLocation getTextureResource(ArmossilloEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(ArmossilloEntity animatable, long instanceId, AnimationState<ArmossilloEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
