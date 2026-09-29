package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.EvolutionerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EvolutionerModel extends GeoModel<EvolutionerEntity> {
    public ResourceLocation getAnimationResource(EvolutionerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/evolutioner.animation.json");
    }

    public ResourceLocation getModelResource(EvolutionerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/evolutioner.geo.json");
    }

    public ResourceLocation getTextureResource(EvolutionerEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(EvolutionerEntity animatable, long instanceId, AnimationState<EvolutionerEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
