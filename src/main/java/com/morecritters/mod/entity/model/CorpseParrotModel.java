package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.CorpseParrotEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CorpseParrotModel extends GeoModel<CorpseParrotEntity> {
    public ResourceLocation getAnimationResource(CorpseParrotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/corpse_parrot.animation.json");
    }

    public ResourceLocation getModelResource(CorpseParrotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/corpse_parrot.geo.json");
    }

    public ResourceLocation getTextureResource(CorpseParrotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(CorpseParrotEntity animatable, long instanceId, AnimationState<CorpseParrotEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head_rotate");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
