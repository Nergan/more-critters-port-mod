package com.morecritters.mod.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ColdstoneStairsBlock extends StairBlock {
    public ColdstoneStairsBlock() {
        super(Blocks.AIR.defaultBlockState(), Properties.of().sound(SoundType.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops());
    }

    @Override
    public float getExplosionResistance() {
        return 6.0F;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return false;
    }
}
