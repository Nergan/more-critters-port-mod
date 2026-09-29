package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BalloonRatEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class StagnationOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!(entity instanceof BalloonRatEntity) && entity.getPersistentData().getDouble("health") != 0.0) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) > entity.getPersistentData().getDouble("health")) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.setHealth((float)entity.getPersistentData().getDouble("health"));
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) < entity.getPersistentData().getDouble("health")) {
                    entity.getPersistentData().putDouble("health", entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0);
                }
            }
        }
    }
}
