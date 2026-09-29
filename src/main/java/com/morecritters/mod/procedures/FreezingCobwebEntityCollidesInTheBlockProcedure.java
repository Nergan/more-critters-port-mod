package com.morecritters.mod.procedures;

import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.SnowflakeSpiderEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class FreezingCobwebEntityCollidesInTheBlockProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            if (!(entity instanceof SnowflakeSpiderEntity)) {
                if (!(entity instanceof Spider)
                    && !(entity instanceof CaveSpider)
                    && !(entity instanceof SnowflakeSpiderEntity)
                    && ServerConfig.CONFIG.cobwebFreeze.get()) {
                    entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                }

                if (entity.getTicksFrozen() <= 200) {
                    entity.setTicksFrozen((int)(entity.getTicksFrozen() + Mth.nextDouble(RandomSource.create(), 2.0, 6.0)));
                }
            }
        }
    }
}
