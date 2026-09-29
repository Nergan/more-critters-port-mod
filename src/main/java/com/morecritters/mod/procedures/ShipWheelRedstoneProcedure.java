package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ShipWheelRedstoneProcedure {
    public static double execute(LevelAccessor world, double x, double y, double z) {
        return (new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
            }
        }).getValue(world, BlockPos.containing(x, y, z), "level");
    }
}
