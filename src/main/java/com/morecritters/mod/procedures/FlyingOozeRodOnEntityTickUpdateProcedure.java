package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FlyingOozeRodOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) {
            return;
        }

        entity.setNoGravity(true);
        CompoundTag data = entity.getPersistentData();
        if (data.contains("vx")) {
            double vx = data.getDouble("vx");
            double vy = data.getDouble("vy") - 0.015;
            double vz = data.getDouble("vz");
            data.putDouble("vy", vy);
            entity.setDeltaMovement(vx, vy, vz);
        }

        if (entity.level().isClientSide()) {
            return;
        }

        int life = data.getInt("life") + 1;
        data.putInt("life", life);
        if (life > 40) {
            entity.discard();
            return;
        }

        Vec3 motion = entity.getDeltaMovement();
        Vec3 start = new Vec3(x, y, z);
        int steps = Math.max(1, (int)Math.ceil(motion.length()));
        for (int step = 0; step <= steps; step++) {
            Vec3 sample = start.add(motion.scale(step / (double)steps));
            BlockPos pos = BlockPos.containing(sample);
            BlockState state = world.getBlockState(pos);
            if (state.isAir()) {
                world.setBlock(pos, MoreCrittersModBlocks.GLOW.get().defaultBlockState(), 3);
            } else if (!state.is(MoreCrittersModBlocks.GLOW.get()) && state.blocksMotion()) {
                entity.discard();
                return;
            }
        }
    }
}
