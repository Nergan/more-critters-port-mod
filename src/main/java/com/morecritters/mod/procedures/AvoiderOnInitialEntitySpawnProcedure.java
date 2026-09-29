package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.AvoiderEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AvoiderOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("leap", Mth.nextInt(RandomSource.create(), 150, 300));
            entity.getPersistentData().putDouble("air", 200.0);
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            MoreCritters.queueServerWork(1, () -> {
                if (entity instanceof AvoiderEntity) {
                    ((AvoiderEntity)entity).setAnimation("run_end");
                }
            });
        }
    }
}
