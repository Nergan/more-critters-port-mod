package com.morecritters.mod.block;

import com.morecritters.mod.procedures.GhostlyPlanksEntityWalksOnTheBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PetrifiedGhostlyStairsBlock extends StairBlock {
    public PetrifiedGhostlyStairsBlock() {
        super(Blocks.AIR.defaultBlockState(),
            Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.STONE).strength(2.0F, 3.0F).dynamicShape()
        );
    }

    @Override
    public float getExplosionResistance() {
        return 3.0F;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return false;
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
        super.stepOn(world, pos, blockstate, entity);
        GhostlyPlanksEntityWalksOnTheBlockProcedure.execute(entity);
    }
}
