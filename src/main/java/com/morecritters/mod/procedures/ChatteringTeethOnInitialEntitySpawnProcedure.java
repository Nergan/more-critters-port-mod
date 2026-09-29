package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.ChatteringTeethEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ChatteringTeethOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            MoreCritters.queueServerWork(5, () -> {
                if (entity instanceof ChatteringTeethEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(ChatteringTeethEntity.DATA_set, true);
                }
            });
        }
    }
}
