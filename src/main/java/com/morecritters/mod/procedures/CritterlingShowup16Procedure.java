package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.FresnoidEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup16Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new FresnoidEntity(MoreCrittersModEntities.FRESNOID.get(), _level) : null;
    }
}
