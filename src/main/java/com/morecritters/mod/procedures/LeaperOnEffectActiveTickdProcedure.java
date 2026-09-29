package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AvoiderEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class LeaperOnEffectActiveTickdProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.isInWaterOrBubble()
                && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() != Blocks.AIR
                && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() != Blocks.WATER
                && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() != Blocks.WATER
                && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() != Blocks.BUBBLE_COLUMN) {
                if (entity instanceof AvoiderEntity) {
                    ((AvoiderEntity)entity).setAnimation("run_end");
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.LEAPER);
                }
            }
        }
    }
}
