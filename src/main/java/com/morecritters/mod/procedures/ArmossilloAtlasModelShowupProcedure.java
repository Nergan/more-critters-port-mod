package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.ArmossilloEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ArmossilloAtlasModelShowupProcedure {
    public static Entity execute(LevelAccessor world) {
        return world instanceof Level _level ? new ArmossilloEntity(MoreCrittersModEntities.ARMOSSILLO.get(), _level) : null;
    }
}
