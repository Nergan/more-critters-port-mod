package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorpseQuartermasterAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new CorpseQuartermasterEntity(MoreCrittersModEntities.CORPSE_QUARTERMASTER.get(), _level) : null;
    }
}
