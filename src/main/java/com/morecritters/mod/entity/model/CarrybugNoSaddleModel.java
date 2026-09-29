package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CarrybugNoSaddleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CarrybugNoSaddleModel extends GeoModel<CarrybugNoSaddleEntity> {
    public ResourceLocation getAnimationResource(CarrybugNoSaddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/carrybug.animation.json");
    }

    public ResourceLocation getModelResource(CarrybugNoSaddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/carrybug.geo.json");
    }

    public ResourceLocation getTextureResource(CarrybugNoSaddleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CarrybugNoSaddleEntity animatable, long instanceId, AnimationState<CarrybugNoSaddleEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head2");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
