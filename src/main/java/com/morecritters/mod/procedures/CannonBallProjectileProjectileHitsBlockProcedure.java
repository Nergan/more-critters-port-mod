package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.CannonBallProjectileEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CannonBallProjectileProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof Level _level && !_level.isClientSide()) {
            _level.explode(null, x, y, z, 4.0F, ExplosionInteraction.BLOCK);
        }

        if (!world.getEntitiesOfClass(CannonBallProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(CannonBallProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
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
            world.getEntitiesOfClass(CannonBallProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                .stream()
                .sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z))
                .findFirst()
                .orElse(null)
                .discard();
        }
    }
}
