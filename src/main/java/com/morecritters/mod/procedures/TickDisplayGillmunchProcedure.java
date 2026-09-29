package com.morecritters.mod.procedures;

import com.morecritters.mod.network.MoreCrittersModVariables;
import net.minecraft.world.entity.Entity;

public class TickDisplayGillmunchProcedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : entity.getData(MoreCrittersModVariables.PLAYER_VARIABLES).HadGillmunch;
    }
}
