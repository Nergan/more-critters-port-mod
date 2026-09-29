package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CarrybugEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CarrybugModel extends GeoModel<CarrybugEntity> {
    public ResourceLocation getAnimationResource(CarrybugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/carrybug.animation.json");
    }

    public ResourceLocation getModelResource(CarrybugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/carrybug.geo.json");
    }

    public ResourceLocation getTextureResource(CarrybugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CarrybugEntity animatable, long instanceId, AnimationState<CarrybugEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
