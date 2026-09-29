package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model9Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ShimmerwingAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model9Entity(MoreCrittersModEntities.MODEL_9.get(), _level) : null;
    }
}
