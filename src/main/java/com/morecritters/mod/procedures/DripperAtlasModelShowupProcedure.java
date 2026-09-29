package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.DripperEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class DripperAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new DripperEntity(MoreCrittersModEntities.DRIPPER.get(), _level) : null;
    }
}
