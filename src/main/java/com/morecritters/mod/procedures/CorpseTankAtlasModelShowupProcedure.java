package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseTankEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorpseTankAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new CorpseTankEntity(MoreCrittersModEntities.CORPSE_TANK.get(), _level) : null;
    }
}
