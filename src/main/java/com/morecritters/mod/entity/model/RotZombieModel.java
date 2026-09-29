package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.RotZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RotZombieModel extends GeoModel<RotZombieEntity> {
    public ResourceLocation getAnimationResource(RotZombieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/rot_zombie.animation.json");
    }

    public ResourceLocation getModelResource(RotZombieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/rot_zombie.geo.json");
    }

    public ResourceLocation getTextureResource(RotZombieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(RotZombieEntity animatable, long instanceId, AnimationState<RotZombieEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_r");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
