package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.FlargEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup13Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new FlargEntity(MoreCrittersModEntities.FLARG.get(), _level) : null;
    }
}
