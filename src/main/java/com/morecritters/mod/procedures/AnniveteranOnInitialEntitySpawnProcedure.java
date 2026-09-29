package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AnniveteranEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class AnniveteranOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof AnniveteranEntity _datEntSetI) {
                _datEntSetI.getEntityData().set(AnniveteranEntity.DATA_variant, Mth.nextInt(RandomSource.create(), 0, 3));
            }
        }
    }
}
