package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.RamchuEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RamchuModel extends GeoModel<RamchuEntity> {
    public ResourceLocation getAnimationResource(RamchuEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/ramchu.animation.json");
    }

    public ResourceLocation getModelResource(RamchuEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/ramchu.geo.json");
    }

    public ResourceLocation getTextureResource(RamchuEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(RamchuEntity animatable, long instanceId, AnimationState<RamchuEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
