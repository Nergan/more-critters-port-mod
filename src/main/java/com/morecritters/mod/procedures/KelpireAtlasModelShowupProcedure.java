package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model15Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class KelpireAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model15Entity(MoreCrittersModEntities.MODEL_15.get(), _level) : null;
    }
}
