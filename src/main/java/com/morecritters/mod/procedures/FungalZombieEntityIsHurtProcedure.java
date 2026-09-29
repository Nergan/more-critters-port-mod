package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.FungalZombieEntity;
import net.minecraft.world.entity.Entity;

public class FungalZombieEntityIsHurtProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof FungalZombieEntity) {
                ((FungalZombieEntity)entity).setAnimation("hurt");
            }
        }
    }
}
