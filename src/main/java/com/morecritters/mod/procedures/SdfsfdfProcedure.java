package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SdfsfdfProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_BLOSSOMBUSH.get()) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModBlocks.BLOSSOMBUSH.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_ELECTRIC_BLOSSOMBUSH.get()) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModBlocks.ELECTRIC_BLOSSOMBUSH.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_VITA.get()) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModBlocks.VITA_SHROOM.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_MORI.get() && world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModBlocks.MORI_SHROOM.get()));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
        }
    }
}
