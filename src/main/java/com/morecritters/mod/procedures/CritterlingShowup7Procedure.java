package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.RollballEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CritterlingShowup7Procedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new RollballEntity(MoreCrittersModEntities.ROLLBALL.get(), _level) : null;
    }
}
