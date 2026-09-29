package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.LightflyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LightflyModel extends GeoModel<LightflyEntity> {
    public ResourceLocation getAnimationResource(LightflyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/lightfly.animation.json");
    }

    public ResourceLocation getModelResource(LightflyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/lightfly.geo.json");
    }

    public ResourceLocation getTextureResource(LightflyEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(LightflyEntity animatable, long instanceId, AnimationState<LightflyEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
