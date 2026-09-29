package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CorpseCrewOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (!entity.level().isClientSide()) {
                entity.discard();
            }

            for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0); index0++) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CORPSE_MATE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            }

            for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 2.0); index1++) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CORPSE_QUARTERMASTER
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

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_TANK.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot((float)Math.random());
                    entityToSpawn.setYBodyRot((float)Math.random());
                    entityToSpawn.setYHeadRot((float)Math.random());
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_CAPTAIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot((float)Math.random());
                    entityToSpawn.setYBodyRot((float)Math.random());
                    entityToSpawn.setYHeadRot((float)Math.random());
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_PARROT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot((float)Math.random());
                    entityToSpawn.setYBodyRot((float)Math.random());
                    entityToSpawn.setYHeadRot((float)Math.random());
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }

            rate = Mth.nextInt(RandomSource.create(), 1, 3);
            if (rate == 1.0 && world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CORPSE_LOOKOUT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot((float)Math.random());
                    entityToSpawn.setYBodyRot((float)Math.random());
                    entityToSpawn.setYHeadRot((float)Math.random());
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof LivingEntity) {
                    entityiterator.push(Mth.nextDouble(RandomSource.create(), -0.1, 0.1), 0.0, Mth.nextDouble(RandomSource.create(), -0.1, 0.1));
                }
            }
        }
    }
}
