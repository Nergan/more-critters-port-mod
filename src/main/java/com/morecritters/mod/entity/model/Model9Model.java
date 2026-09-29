package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.Model9Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class Model9Model extends GeoModel<Model9Entity> {
    public ResourceLocation getAnimationResource(Model9Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/shimmerwing_atlas_model.animation.json");
    }

    public ResourceLocation getModelResource(Model9Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/shimmerwing_atlas_model.geo.json");
    }

    public ResourceLocation getTextureResource(Model9Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(Model9Entity animatable, long instanceId, AnimationState<Model9Entity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
