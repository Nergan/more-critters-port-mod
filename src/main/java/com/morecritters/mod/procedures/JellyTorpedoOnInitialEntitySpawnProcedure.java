package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class JellyTorpedoOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putBoolean("explode", false);
            MoreCritters.queueServerWork(5, () -> entity.getPersistentData().putBoolean("explode", true));
        }
    }
}
