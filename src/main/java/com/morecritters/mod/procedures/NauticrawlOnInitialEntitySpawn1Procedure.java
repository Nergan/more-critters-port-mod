package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.NauticrawlEntity;
import com.morecritters.mod.entity.ZombieNauticrawlEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class NauticrawlOnInitialEntitySpawn1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double coral = 0.0;
            entity.getPersistentData().putDouble("attack", Mth.nextInt(RandomSource.create(), 100, 200));
            entity.getPersistentData().putDouble("swim", 20.0);
            entity.getPersistentData().putDouble("air", 200.0);
            entity.getPersistentData().putDouble("down", 100.0);
            rate = Mth.nextInt(RandomSource.create(), 1, 20);
            if (entity instanceof NauticrawlEntity && rate == 1.0) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.ZOMBIE_NAUTICRAWL
                        .get()
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            }

            coral = Mth.nextInt(RandomSource.create(), 1, 10);
            if (coral == 1.0 && entity instanceof ZombieNauticrawlEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(ZombieNauticrawlEntity.DATA_coral, true);
            }
        }
    }
}
