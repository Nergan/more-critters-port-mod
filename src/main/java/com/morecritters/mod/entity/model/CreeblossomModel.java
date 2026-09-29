package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CreeblossomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CreeblossomModel extends GeoModel<CreeblossomEntity> {
    public ResourceLocation getAnimationResource(CreeblossomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/creeblossom.animation.json");
    }

    public ResourceLocation getModelResource(CreeblossomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/creeblossom.geo.json");
    }

    public ResourceLocation getTextureResource(CreeblossomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CreeblossomEntity animatable, long instanceId, AnimationState<CreeblossomEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
