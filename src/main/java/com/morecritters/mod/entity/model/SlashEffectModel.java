package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.SlashEffectEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SlashEffectModel extends GeoModel<SlashEffectEntity> {
    public ResourceLocation getAnimationResource(SlashEffectEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/slash_effect.animation.json");
    }

    public ResourceLocation getModelResource(SlashEffectEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/slash_effect.geo.json");
    }

    public ResourceLocation getTextureResource(SlashEffectEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(SlashEffectEntity animatable, long instanceId, AnimationState<SlashEffectEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("root1");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
