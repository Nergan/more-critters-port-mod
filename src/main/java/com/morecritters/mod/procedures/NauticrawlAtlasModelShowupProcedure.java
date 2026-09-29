package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model16Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class NauticrawlAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model16Entity(MoreCrittersModEntities.MODEL_16.get(), _level) : null;
    }
}
