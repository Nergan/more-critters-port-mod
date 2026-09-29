package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.KelpireEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BlubberfishEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity != null) {
            double rate = 0.0;
            if (!(sourceentity instanceof KelpireEntity)) {
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.RAW_BLUBBERFISH.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 2);
                if (1.0 == rate) {
                    for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 4.0); index0++) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModBlocks.BLUBBER.get()));
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    }
                }
            }
        }
    }
}
