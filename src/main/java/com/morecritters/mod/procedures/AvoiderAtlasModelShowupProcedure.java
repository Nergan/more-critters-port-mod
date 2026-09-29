package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AvoiderEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AvoiderAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new AvoiderEntity(MoreCrittersModEntities.AVOIDER.get(), _level) : null;
    }
}
