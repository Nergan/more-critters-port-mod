package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseMateEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class CorpseMateOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double rate2 = 0.0;
            if (entity instanceof CorpseMateEntity _datEntSetI) {
                _datEntSetI.getEntityData().set(CorpseMateEntity.DATA_variant, Mth.nextInt(RandomSource.create(), 0, 4));
            }

            entity.getPersistentData().putDouble("speech", Mth.nextDouble(RandomSource.create(), 200.0, 600.0));
        }
    }
}
