package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.WanderingCollectorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WanderingCollectorModel extends GeoModel<WanderingCollectorEntity> {
    public ResourceLocation getAnimationResource(WanderingCollectorEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/wandering_collector.animation.json");
    }

    public ResourceLocation getModelResource(WanderingCollectorEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/wandering_collector.geo.json");
    }

    public ResourceLocation getTextureResource(WanderingCollectorEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(WanderingCollectorEntity animatable, long instanceId, AnimationState<WanderingCollectorEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
