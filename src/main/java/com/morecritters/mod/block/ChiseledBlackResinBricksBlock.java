package com.morecritters.mod.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.neoforge.common.util.DeferredSoundType;

public class ChiseledBlackResinBricksBlock extends Block {
    public ChiseledBlackResinBricksBlock() {
        super(
            Properties.of()
                .sound(
                    new DeferredSoundType(
                        1.0F,
                        1.0F,
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.black_resin_bricks.break")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.black_resin_bricks.footsteps")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.black_resin_bricks.place")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.black_resin_bricks.breaking")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.black_resin_bricks.fall"))
                    )
                )
                .strength(1.5F, 6.0F)
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}
