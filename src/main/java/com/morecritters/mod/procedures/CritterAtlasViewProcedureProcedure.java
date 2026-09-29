package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CritterAtlasModelEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterAtlasViewProcedureProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new CritterAtlasModelEntity(MoreCrittersModEntities.CRITTER_ATLAS_MODEL.get(), _level) : null;
    }
}
