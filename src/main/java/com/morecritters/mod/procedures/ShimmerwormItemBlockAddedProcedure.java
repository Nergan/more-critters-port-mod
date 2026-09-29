package com.morecritters.mod.procedures;

import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class ShimmerwormItemBlockAddedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos _bp = BlockPos.containing(x, y, z);
        BlockState _bs = Blocks.AIR.defaultBlockState();
        BlockState _bso = world.getBlockState(_bp);
        for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
            Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
            if (_property != null && _bs.getValue(_property) != null) {
                try {
                    _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                } catch (Exception var14) {
                }
            }
        }

        world.setBlock(_bp, _bs, 3);
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = MoreCrittersModEntities.SHIMMERWORM.get().spawn(_level, BlockPos.containing(x + 0.5, y, z + 0.5), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
                entityToSpawn.setYRot((float)Math.random());
                entityToSpawn.setYBodyRot((float)Math.random());
                entityToSpawn.setYHeadRot((float)Math.random());
                entityToSpawn.setXRot((float)Math.random());
                entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
            }
        }
    }
}
