package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.BombJellyEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BombJellyAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new BombJellyEntity(MoreCrittersModEntities.BOMB_JELLY.get(), _level) : null;
    }
}
