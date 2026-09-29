package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.NervoidEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class NervoidModel extends GeoModel<NervoidEntity> {
    public ResourceLocation getAnimationResource(NervoidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/nervoid.animation.json");
    }

    public ResourceLocation getModelResource(NervoidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/nervoid.geo.json");
    }

    public ResourceLocation getTextureResource(NervoidEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(NervoidEntity animatable, long instanceId, AnimationState<NervoidEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("body");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
