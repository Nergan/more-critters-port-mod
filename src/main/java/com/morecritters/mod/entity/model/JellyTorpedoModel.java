package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.JellyTorpedoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class JellyTorpedoModel extends GeoModel<JellyTorpedoEntity> {
    public ResourceLocation getAnimationResource(JellyTorpedoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/jelly_torpedo.animation.json");
    }

    public ResourceLocation getModelResource(JellyTorpedoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/jelly_torpedo.geo.json");
    }

    public ResourceLocation getTextureResource(JellyTorpedoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(JellyTorpedoEntity animatable, long instanceId, AnimationState<JellyTorpedoEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
