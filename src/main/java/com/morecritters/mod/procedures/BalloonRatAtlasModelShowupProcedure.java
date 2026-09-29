package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model7Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BalloonRatAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model7Entity(MoreCrittersModEntities.MODEL_7.get(), _level) : null;
    }
}
