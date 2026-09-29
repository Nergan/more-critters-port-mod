package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.NauticrawlEntity;
import net.minecraft.world.entity.Entity;

public class DafasfsafdsafProcedure {
    public static boolean execute(Entity entity) {
        return entity == null ? false : !(entity instanceof NauticrawlEntity _datEntL0 && _datEntL0.getEntityData().get(NauticrawlEntity.DATA_sleeping));
    }
}
