package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.Model10Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class Model10Model extends GeoModel<Model10Entity> {
    public ResourceLocation getAnimationResource(Model10Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/mightshroom_atlas_model.animation.json");
    }

    public ResourceLocation getModelResource(Model10Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/mightshroom_atlas_model.geo.json");
    }

    public ResourceLocation getTextureResource(Model10Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(Model10Entity animatable, long instanceId, AnimationState<Model10Entity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
