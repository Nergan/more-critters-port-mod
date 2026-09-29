package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.SnowflakeSpiderEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class SnowflakeSpiderAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new SnowflakeSpiderEntity(MoreCrittersModEntities.SNOWFLAKE_SPIDER.get(), _level) : null;
    }
}
