package com.morecritters.mod.block;

import com.morecritters.mod.init.MoreCrittersModFluids;
import com.morecritters.mod.procedures.IropodDropProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class IropodBucketBlock extends LiquidBlock {
    public IropodBucketBlock() {
        super(MoreCrittersModFluids.IROPOD_BUCKET.get(),
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
        IropodDropProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }
}
