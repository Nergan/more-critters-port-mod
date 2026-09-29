package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BunbugEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BunbugAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new BunbugEntity(MoreCrittersModEntities.BUNBUG.get(), _level) : null;
    }
}
