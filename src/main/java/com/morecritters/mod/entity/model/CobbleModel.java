package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CobbleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CobbleModel extends GeoModel<CobbleEntity> {
    public ResourceLocation getAnimationResource(CobbleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/cobble.animation.json");
    }

    public ResourceLocation getModelResource(CobbleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/cobble.geo.json");
    }

    public ResourceLocation getTextureResource(CobbleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CobbleEntity animatable, long instanceId, AnimationState<CobbleEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
