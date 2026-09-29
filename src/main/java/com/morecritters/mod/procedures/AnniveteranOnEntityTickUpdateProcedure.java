package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AnniveteranEntity;
import net.minecraft.world.entity.Entity;

public class AnniveteranOnEntityTickUpdateProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if ((entity instanceof AnniveteranEntity _datEntI ? _datEntI.getEntityData().get(AnniveteranEntity.DATA_variant) : 0) == 0) {
                if (entity instanceof AnniveteranEntity animatable) {
                    animatable.setTexture("anniveteran");
                }
            } else if ((entity instanceof AnniveteranEntity _datEntI ? _datEntI.getEntityData().get(AnniveteranEntity.DATA_variant) : 0) == 1) {
                if (entity instanceof AnniveteranEntity animatable) {
                    animatable.setTexture("anniveteran1");
                }
            } else if ((entity instanceof AnniveteranEntity _datEntI ? _datEntI.getEntityData().get(AnniveteranEntity.DATA_variant) : 0) == 2) {
                if (entity instanceof AnniveteranEntity animatable) {
                    animatable.setTexture("anniveteran2");
                }
            } else if ((entity instanceof AnniveteranEntity _datEntI ? _datEntI.getEntityData().get(AnniveteranEntity.DATA_variant) : 0) == 3
                && entity instanceof AnniveteranEntity animatable) {
                animatable.setTexture("anniveteran3");
            }
        }
    }
}
