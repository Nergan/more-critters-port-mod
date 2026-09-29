package com.morecritters.mod.procedures;

import net.minecraft.world.level.LevelAccessor;

public class StincarpNaturalEntitySpawningConditionProcedure {
    public static boolean execute(LevelAccessor world) {
        return world.getLevelData().isThundering();
    }
}
