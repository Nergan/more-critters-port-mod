package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CorpseParrotAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new CorpseParrotEntity(MoreCrittersModEntities.CORPSE_PARROT.get(), _level) : null;
    }
}
