package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.KelpireEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class KelpireModel extends GeoModel<KelpireEntity> {
    public ResourceLocation getAnimationResource(KelpireEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/kelpire.animation.json");
    }

    public ResourceLocation getModelResource(KelpireEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/kelpire.geo.json");
    }

    public ResourceLocation getTextureResource(KelpireEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(KelpireEntity animatable, long instanceId, AnimationState<KelpireEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
