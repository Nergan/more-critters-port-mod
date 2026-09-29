package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.TamedCorpseParrotEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TamedCorpseParrotModel extends GeoModel<TamedCorpseParrotEntity> {
    public ResourceLocation getAnimationResource(TamedCorpseParrotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/corpse_parrot_tamed.animation.json");
    }

    public ResourceLocation getModelResource(TamedCorpseParrotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/corpse_parrot_tamed.geo.json");
    }

    public ResourceLocation getTextureResource(TamedCorpseParrotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(TamedCorpseParrotEntity animatable, long instanceId, AnimationState<TamedCorpseParrotEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_rotate");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
