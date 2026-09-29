package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorpseMateAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new CorpseMateEntity(MoreCrittersModEntities.CORPSE_MATE.get(), _level) : null;
    }
}
