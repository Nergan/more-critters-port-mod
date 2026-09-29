package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorpseLookoutAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new CorpseLookoutEntity(MoreCrittersModEntities.CORPSE_LOOKOUT.get(), _level) : null;
    }
}
