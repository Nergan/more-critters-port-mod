package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CorpseLookoutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CorpseLookoutModel extends GeoModel<CorpseLookoutEntity> {
    public ResourceLocation getAnimationResource(CorpseLookoutEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/coprse_lookout.animation.json");
    }

    public ResourceLocation getModelResource(CorpseLookoutEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/coprse_lookout.geo.json");
    }

    public ResourceLocation getTextureResource(CorpseLookoutEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CorpseLookoutEntity animatable, long instanceId, AnimationState<CorpseLookoutEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_r");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
