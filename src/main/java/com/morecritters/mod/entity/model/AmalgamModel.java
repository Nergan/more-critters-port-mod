package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.AmalgamEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AmalgamModel extends GeoModel<AmalgamEntity> {
    public ResourceLocation getAnimationResource(AmalgamEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/amalgam.animation.json");
    }

    public ResourceLocation getModelResource(AmalgamEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/amalgam.geo.json");
    }

    public ResourceLocation getTextureResource(AmalgamEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(AmalgamEntity animatable, long instanceId, AnimationState<AmalgamEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("heads");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
