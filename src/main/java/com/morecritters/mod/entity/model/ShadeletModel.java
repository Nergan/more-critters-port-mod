package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.ShadeletEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ShadeletModel extends GeoModel<ShadeletEntity> {
    public ResourceLocation getAnimationResource(ShadeletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/shadelet.animation.json");
    }

    public ResourceLocation getModelResource(ShadeletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/shadelet.geo.json");
    }

    public ResourceLocation getTextureResource(ShadeletEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(ShadeletEntity animatable, long instanceId, AnimationState<ShadeletEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
