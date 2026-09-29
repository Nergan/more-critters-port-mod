package com.morecritters.mod.block;

import com.morecritters.mod.init.MoreCrittersModFluids;
import com.morecritters.mod.procedures.BlubberfishDropProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class BlubberfishBucketBlock extends LiquidBlock {
    public BlubberfishBucketBlock() {
        super(MoreCrittersModFluids.BLUBBERFISH_BUCKET.get(),
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
        BlubberfishDropProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }
}
