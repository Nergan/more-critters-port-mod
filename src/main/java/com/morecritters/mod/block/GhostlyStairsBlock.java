package com.morecritters.mod.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GhostlyStairsBlock extends StairBlock {
    public GhostlyStairsBlock() {
        super(Blocks.AIR.defaultBlockState(),
            Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2.0F, 3.0F).dynamicShape()
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
}
