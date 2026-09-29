package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class FrightshroomEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 6.0, 10.0); index0++) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.ANCIENT_BONE.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }

        for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 2.0, 4.0); index1++) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.FUNGAL_FLESH.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }

        for (int index2 = 0; index2 < (int)Mth.nextDouble(RandomSource.create(), 3.0, 7.0); index2++) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.REGENERATIVE_FLESH.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }

        for (int index3 = 0; index3 < (int)Mth.nextDouble(RandomSource.create(), 0.0, 4.0); index3++) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModBlocks.MORI_SHROOM.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }
    }
}
