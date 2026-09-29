package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.ScowlEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup6Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new ScowlEntity(MoreCrittersModEntities.SCOWL.get(), _level) : null;
    }
}
