package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.WarptrapEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class WarptrapOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.setShiftKeyDown(false);
            if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("crimson_forest"))) {
                if (entity instanceof WarptrapEntity animatable) {
                    animatable.setTexture("warptrap_crimson");
                }

                entity.getPersistentData().putBoolean("crimson", true);
            } else {
                if (entity instanceof WarptrapEntity animatable) {
                    animatable.setTexture("warptrap");
                }

                entity.getPersistentData().putBoolean("crimson", false);
            }
        }
    }
}
