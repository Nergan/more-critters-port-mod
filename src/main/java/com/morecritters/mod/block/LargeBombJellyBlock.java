package com.morecritters.mod.block;

import com.morecritters.mod.init.MoreCrittersModFluids;
import com.morecritters.mod.procedures.LargeBombJellyDropProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class LargeBombJellyBlock extends LiquidBlock {
    public LargeBombJellyBlock() {
        super(MoreCrittersModFluids.LARGE_BOMB_JELLY.get(),
            Properties.of()
                .mapColor(MapColor.WATER)
                .strength(100.0F)
                .noCollission()
                .noLootTable()
                .liquid()
                .pushReaction(PushReaction.DESTROY)
                .sound(SoundType.EMPTY)
                .replaceable()
        );
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        LargeBombJellyDropProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }
}
