package com.morecritters.mod.block.model;

import com.morecritters.mod.block.entity.TatteredJollyRogerTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TatteredJollyRogerBlockModel extends GeoModel<TatteredJollyRogerTileEntity> {
    public ResourceLocation getAnimationResource(TatteredJollyRogerTileEntity animatable) {
        int blockstate = animatable.blockstateNew;
        return blockstate == 1
            ? ResourceLocation.fromNamespaceAndPath("more_critters", "animations/tattered_jolly_roger_2.animation.json")
            : ResourceLocation.fromNamespaceAndPath("more_critters", "animations/tattered_jolly_roger.animation.json");
    }

    public ResourceLocation getModelResource(TatteredJollyRogerTileEntity animatable) {
        int blockstate = animatable.blockstateNew;
        return blockstate == 1
            ? ResourceLocation.fromNamespaceAndPath("more_critters", "geo/tattered_jolly_roger_2.geo.json")
            : ResourceLocation.fromNamespaceAndPath("more_critters", "geo/tattered_jolly_roger.geo.json");
    }

    public ResourceLocation getTextureResource(TatteredJollyRogerTileEntity animatable) {
        int blockstate = animatable.blockstateNew;
        return blockstate == 1
            ? ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/tattered_jolly_rodger_large.png")
            : ResourceLocation.fromNamespaceAndPath("more_critters", "textures/block/tattered_jolly_rodger_large.png");
    }
}
