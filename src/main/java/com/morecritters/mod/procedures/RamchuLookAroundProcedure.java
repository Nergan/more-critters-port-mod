package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.RamchuEntity;
import net.minecraft.world.entity.Entity;

public class RamchuLookAroundProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof RamchuEntity _datEntL0 && _datEntL0.getEntityData().get(RamchuEntity.DATA_ramming));
    }
}
