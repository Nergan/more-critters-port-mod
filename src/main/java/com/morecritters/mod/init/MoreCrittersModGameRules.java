package com.morecritters.mod.init;

import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.GameRules.Category;
import net.minecraft.world.level.GameRules.Key;

public class MoreCrittersModGameRules {
    public static Key<BooleanValue> GAMBLEMODE;

    public static void register() {
        GAMBLEMODE = GameRules.register("gamblemode", Category.MOBS, BooleanValue.create(false));
    }
}
