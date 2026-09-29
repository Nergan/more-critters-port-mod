package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.Model1Entity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BouncelizardAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new Model1Entity(MoreCrittersModEntities.MODEL_1.get(), _level) : null;
    }
}
