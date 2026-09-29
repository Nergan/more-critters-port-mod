package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.IroballEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class IroballModel extends GeoModel<IroballEntity> {
    public ResourceLocation getAnimationResource(IroballEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/iroball.animation.json");
    }

    public ResourceLocation getModelResource(IroballEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/iroball.geo.json");
    }

    public ResourceLocation getTextureResource(IroballEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(IroballEntity animatable, long instanceId, AnimationState<IroballEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
