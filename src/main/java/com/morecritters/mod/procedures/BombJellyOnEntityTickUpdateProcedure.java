package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class BombJellyOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            rate = Mth.nextInt(RandomSource.create(), 1, 3);
            if (rate == 1.0) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BOMB_JELLY_LARGE
                        .get()
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (rate == 2.0) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BOMB_JELLY_MEDIUM
                        .get()
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (rate == 3.0) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BOMB_JELLY_SMALL
                        .get()
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            }
        }
    }
}
