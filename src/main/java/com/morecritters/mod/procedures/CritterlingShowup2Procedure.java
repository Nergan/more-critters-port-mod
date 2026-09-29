package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.PlainswyrmEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup2Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new PlainswyrmEntity(MoreCrittersModEntities.PLAINSWYRM.get(), _level) : null;
    }
}
