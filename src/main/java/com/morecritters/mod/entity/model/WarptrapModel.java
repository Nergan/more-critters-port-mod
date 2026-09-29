package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.WarptrapEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WarptrapModel extends GeoModel<WarptrapEntity> {
    public ResourceLocation getAnimationResource(WarptrapEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/warptrap.animation.json");
    }

    public ResourceLocation getModelResource(WarptrapEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/warptrap.geo.json");
    }

    public ResourceLocation getTextureResource(WarptrapEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(WarptrapEntity animatable, long instanceId, AnimationState<WarptrapEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
