package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.DominicEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup11Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new DominicEntity(MoreCrittersModEntities.DOMINIC.get(), _level) : null;
    }
}
