package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BalloonRatEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BalloonRatModel extends GeoModel<BalloonRatEntity> {
    public ResourceLocation getAnimationResource(BalloonRatEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/balloon_rat.animation.json");
    }

    public ResourceLocation getModelResource(BalloonRatEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/balloon_rat.geo.json");
    }

    public ResourceLocation getTextureResource(BalloonRatEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(BalloonRatEntity animatable, long instanceId, AnimationState<BalloonRatEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
