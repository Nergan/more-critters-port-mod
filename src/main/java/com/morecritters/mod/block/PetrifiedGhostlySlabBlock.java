package com.morecritters.mod.block;

import com.morecritters.mod.procedures.GhostlyPlanksEntityWalksOnTheBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PetrifiedGhostlySlabBlock extends SlabBlock {
    public PetrifiedGhostlySlabBlock() {
        super(Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.STONE).strength(2.0F, 3.0F).dynamicShape());
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
        super.stepOn(world, pos, blockstate, entity);
        GhostlyPlanksEntityWalksOnTheBlockProcedure.execute(entity);
    }
}
