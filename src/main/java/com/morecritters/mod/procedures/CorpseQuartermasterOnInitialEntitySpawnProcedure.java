package com.morecritters.mod.procedures;

import com.morecritters.mod.config.ServerConfig;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class CorpseQuartermasterOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("heal", ServerConfig.CONFIG.quartermasterCooldown.get());
            entity.getPersistentData().putDouble("speech", Mth.nextDouble(RandomSource.create(), 200.0, 600.0));
        }
    }
}
