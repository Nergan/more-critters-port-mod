package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BalloonRatEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        rate = Mth.nextInt(RandomSource.create(), 1, 5);
        if (rate == 1.0) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.TOXIN_BLADDER_STAGNATION.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        } else if (rate == 2.0) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.TOXIN_BLADDER_MUSCLE_ACHE.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        } else if (rate == 3.0) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.TOXIN_BLADDER_BRITTLENESS.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        } else if (rate == 4.0) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.TOXIN_BLADDER_HALLUCINAZIUM.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        } else if (rate == 5.0 && world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.TOXIN_BLADDER_ASPHYXIATION.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
        }
    }
}
