package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.BabyArmossilloEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BabyArmossilloModel extends GeoModel<BabyArmossilloEntity> {
    public ResourceLocation getAnimationResource(BabyArmossilloEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/baby_armossillo.animation.json");
    }

    public ResourceLocation getModelResource(BabyArmossilloEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/baby_armossillo.geo.json");
    }

    public ResourceLocation getTextureResource(BabyArmossilloEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(BabyArmossilloEntity animatable, long instanceId, AnimationState<BabyArmossilloEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
