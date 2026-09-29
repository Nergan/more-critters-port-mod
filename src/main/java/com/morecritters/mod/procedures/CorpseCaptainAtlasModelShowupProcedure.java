package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorpseCaptainAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new CorpseCaptainEntity(MoreCrittersModEntities.CORPSE_CAPTAIN.get(), _level) : null;
    }
}
