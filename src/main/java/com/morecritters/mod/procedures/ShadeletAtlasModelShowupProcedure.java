package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model17Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ShadeletAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model17Entity(MoreCrittersModEntities.MODEL_17.get(), _level) : null;
    }
}
