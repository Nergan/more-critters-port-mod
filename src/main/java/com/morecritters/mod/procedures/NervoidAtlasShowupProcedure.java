package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model19Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class NervoidAtlasShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model19Entity(MoreCrittersModEntities.MODEL_19.get(), _level) : null;
    }
}
