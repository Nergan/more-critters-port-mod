package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SnowflakeSpiderEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;

        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 3.0); index0++) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.FREEZING_STRING.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }

        rate = Mth.nextInt(RandomSource.create(), 1, 3);
        if (rate == 1.0 && world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.SACKOF_FREEZING.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
        }
    }
}
