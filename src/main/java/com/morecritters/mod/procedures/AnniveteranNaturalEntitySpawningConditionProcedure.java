package com.morecritters.mod.procedures;

import java.util.Calendar;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;

public class AnniveteranNaturalEntitySpawningConditionProcedure {
    public static boolean execute(LevelAccessor world) {
        return (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                == Level.OVERWORLD
            && Calendar.getInstance().get(2) == 7
            && (Calendar.getInstance().get(5) == 7 || Calendar.getInstance().get(5) == 8 || Calendar.getInstance().get(5) == 9);
    }
}
