package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.TamedCorpseParrotEntity;
import net.minecraft.world.entity.Entity;

public class ParrotNotSittingSimpleProcedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : !(entity instanceof TamedCorpseParrotEntity _datEntL0 && _datEntL0.getEntityData().get(TamedCorpseParrotEntity.DATA_sit));
    }
}
