package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CorpseTankSpawnDollRightClickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, ItemStack itemstack) {
        if (direction != null) {
            itemstack.shrink(1);
            if (direction == Direction.UP) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y + 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.DOWN) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.NORTH) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z - 1.0), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.SOUTH) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z + 1.0), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.WEST) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK
                        .get()
                        .spawn(_level, BlockPos.containing(x - 1.0, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.EAST && world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK
                    .get()
                    .spawn(_level, BlockPos.containing(x + 1.5, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot((float)Math.random());
                    entityToSpawn.setYBodyRot((float)Math.random());
                    entityToSpawn.setYHeadRot((float)Math.random());
                    entityToSpawn.setXRot((float)Math.random());
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }
        }
    }
}
