package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.CreeblossomEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class CreeblossomOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("blow", 3.0);
            entity.getPersistentData().putDouble("life", 400.0);
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.BLOSSOMBUSH.get()
                && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.CLOSED_BLOSSOMBUSH.get()
                && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.ELECTRIC_BLOSSOMBUSH.get()
                && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.CLOSED_ELECTRIC_BLOSSOMBUSH.get()) {
                entity.getPersistentData().putDouble("recruit", 0.0);
                if (entity instanceof CreeblossomEntity animatable) {
                    animatable.setTexture("creeblossom");
                }
            } else {
                entity.getPersistentData().putDouble("recruit", 1.0);
                if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.BLOSSOMBUSH.get()
                    && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.CLOSED_BLOSSOMBUSH.get()) {
                    if ((
                            world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ELECTRIC_BLOSSOMBUSH.get()
                                || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.CLOSED_ELECTRIC_BLOSSOMBUSH.get()
                        )
                        && entity instanceof CreeblossomEntity animatable) {
                        animatable.setTexture("creeblossom_electric");
                    }
                } else if (entity instanceof CreeblossomEntity animatable) {
                    animatable.setTexture("creeblossom_friendly");
                }
            }
        }
    }
}
