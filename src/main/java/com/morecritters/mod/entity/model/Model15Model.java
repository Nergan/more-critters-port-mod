package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.Model15Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class Model15Model extends GeoModel<Model15Entity> {
    public ResourceLocation getAnimationResource(Model15Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/kelpire.animation.json");
    }

    public ResourceLocation getModelResource(Model15Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/kelpire.geo.json");
    }

    public ResourceLocation getTextureResource(Model15Entity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(Model15Entity animatable, long instanceId, AnimationState<Model15Entity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
