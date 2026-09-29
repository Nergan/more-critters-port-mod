package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.SoulRumProjectileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SoulRumProjectileWhileProjectileFlyingTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if ((
                world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.WATER
                    || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.WATER
                    || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.BUBBLE_COLUMN
            )
            && !world.getEntitiesOfClass(SoulRumProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                .stream()
                .sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z))
                .findFirst()
                .orElse(null)
                .level()
                .isClientSide()) {
            world.getEntitiesOfClass(SoulRumProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true).stream().sorted((new Object() {
                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                }
            }).compareDistOf(x, y, z)).findFirst().orElse(null).discard();
        }
    }
}
