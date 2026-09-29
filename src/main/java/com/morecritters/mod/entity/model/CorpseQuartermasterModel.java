package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CorpseQuartermasterModel extends GeoModel<CorpseQuartermasterEntity> {
    public ResourceLocation getAnimationResource(CorpseQuartermasterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/corpse_quartermaster.animation.json");
    }

    public ResourceLocation getModelResource(CorpseQuartermasterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/corpse_quartermaster.geo.json");
    }

    public ResourceLocation getTextureResource(CorpseQuartermasterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CorpseQuartermasterEntity animatable, long instanceId, AnimationState<CorpseQuartermasterEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_root");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
