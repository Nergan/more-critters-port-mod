package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.FungalZombieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FungalZombieModel extends GeoModel<FungalZombieEntity> {
    public ResourceLocation getAnimationResource(FungalZombieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/fungal_zombie.animation.json");
    }

    public ResourceLocation getModelResource(FungalZombieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/fungal_zombie.geo.json");
    }

    public ResourceLocation getTextureResource(FungalZombieEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(FungalZombieEntity animatable, long instanceId, AnimationState<FungalZombieEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
