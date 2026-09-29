package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model10Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class MightshroomAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model10Entity(MoreCrittersModEntities.MODEL_10.get(), _level) : null;
    }
}
