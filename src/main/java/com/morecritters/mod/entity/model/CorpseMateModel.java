package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CorpseMateEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CorpseMateModel extends GeoModel<CorpseMateEntity> {
    public ResourceLocation getAnimationResource(CorpseMateEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/corpse_mate.animation.json");
    }

    public ResourceLocation getModelResource(CorpseMateEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/corpse_mate.geo.json");
    }

    public ResourceLocation getTextureResource(CorpseMateEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CorpseMateEntity animatable, long instanceId, AnimationState<CorpseMateEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
