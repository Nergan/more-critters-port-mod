package com.morecritters.mod.procedures;

import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class BounceberryBushEmptyOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos _bp = BlockPos.containing(x, y, z);
        BlockState _bs = MoreCrittersModBlocks.BOUNCEBERRY_BUSH.get().defaultBlockState();
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
    }
}
