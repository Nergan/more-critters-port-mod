package com.morecritters.mod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GlowingOozeBlockBlock extends FallingBlock {
    public static final MapCodec<GlowingOozeBlockBlock> CODEC = simpleCodec(properties -> new GlowingOozeBlockBlock());

    @Override
    public MapCodec<GlowingOozeBlockBlock> codec() {
        return CODEC;
    }

    public GlowingOozeBlockBlock() {
        super(
            Properties.of()
                .sound(SoundType.SLIME_BLOCK)
                .strength(0.5F)
                .lightLevel(s -> 5)
                .hasPostProcess((bs, br, bp) -> true)
                .emissiveRendering((bs, br, bp) -> true)
        );
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}
