package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.MightshroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MightshroomModel extends GeoModel<MightshroomEntity> {
    public ResourceLocation getAnimationResource(MightshroomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/mightshroom.animation.json");
    }

    public ResourceLocation getModelResource(MightshroomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/mightshroom.geo.json");
    }

    public ResourceLocation getTextureResource(MightshroomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(MightshroomEntity animatable, long instanceId, AnimationState<MightshroomEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("neck_main");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
