package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SlablizardEggBlockAddedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
                _blockEntity.getPersistentData().putDouble("timer", Mth.nextDouble(RandomSource.create(), 23000.0, 25000.0));
            }

            if (world instanceof Level _level) {
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
        }
    }
}
