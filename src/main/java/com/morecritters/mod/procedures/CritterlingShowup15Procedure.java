package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.MangotriceEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup15Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new MangotriceEntity(MoreCrittersModEntities.MANGOTRICE.get(), _level) : null;
    }
}
