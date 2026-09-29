package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model13Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class IropodAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model13Entity(MoreCrittersModEntities.MODEL_13.get(), _level) : null;
    }
}
