package com.morecritters.mod.entity.model;

import com.morecritters.mod.entity.PinkMonsterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PinkMonsterModel extends GeoModel<PinkMonsterEntity> {
    public ResourceLocation getAnimationResource(PinkMonsterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "animations/pink_monster.animation.json");
    }

    public ResourceLocation getModelResource(PinkMonsterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "geo/pink_monster.geo.json");
    }

    public ResourceLocation getTextureResource(PinkMonsterEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("more_critters", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(PinkMonsterEntity animatable, long instanceId, AnimationState<PinkMonsterEntity> animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292F);
            head.setRotY(entityData.netHeadYaw() * 0.017453292F);
        }
    }
}
