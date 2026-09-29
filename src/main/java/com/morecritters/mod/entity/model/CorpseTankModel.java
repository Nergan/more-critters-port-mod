package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CorpseTankEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CorpseTankModel extends GeoModel<CorpseTankEntity> {
    public ResourceLocation getAnimationResource(CorpseTankEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/corpse_tank.animation.json");
    }

    public ResourceLocation getModelResource(CorpseTankEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/corpse_tank.geo.json");
    }

    public ResourceLocation getTextureResource(CorpseTankEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CorpseTankEntity animatable, long instanceId, AnimationState<CorpseTankEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
