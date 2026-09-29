package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class HallucinaziumOverlayDisplayOverlayIngameProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MoreCrittersModMobEffects.HALLUCINAZIUM);
    }
}
