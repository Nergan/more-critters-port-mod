package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.DungerEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup3Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new DungerEntity(MoreCrittersModEntities.DUNGER.get(), _level) : null;
    }
}
