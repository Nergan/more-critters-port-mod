package com.morecritters.mod.block;

import com.morecritters.mod.procedures.DeepslateFossilBreakProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FluidState;

public class DeepslateFossilBlockBlock extends Block {
    public DeepslateFossilBlockBlock() {
        super(Properties.of().sound(SoundType.DEEPSLATE).strength(3.0F, 6.0F).requiresCorrectToolForDrops());
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
        boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
        DeepslateFossilBreakProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
        return retval;
    }
}
