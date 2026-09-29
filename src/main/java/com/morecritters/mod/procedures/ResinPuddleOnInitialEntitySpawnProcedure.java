package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.ResinPuddleEntity;
import net.minecraft.world.entity.Entity;

public class ResinPuddleOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("animation", 5.0);
            if (entity instanceof ResinPuddleEntity) {
                ((ResinPuddleEntity)entity).setAnimation("1");
            }
        }
    }
}
