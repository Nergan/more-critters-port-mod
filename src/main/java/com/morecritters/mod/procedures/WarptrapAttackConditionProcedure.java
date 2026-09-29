package com.morecritters.mod.procedures;

import com.morecritters.mod.config.ServerConfig;

public class WarptrapAttackConditionProcedure {
    public static boolean execute() {
        return ServerConfig.CONFIG.warptrapAttack.get();
    }
}
