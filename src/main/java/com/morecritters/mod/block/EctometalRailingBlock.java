package com.morecritters.mod.block;

import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class EctometalRailingBlock extends IronBarsBlock {
    public EctometalRailingBlock() {
        super(
            Properties.of()
                .sound(SoundType.NETHERITE_BLOCK)
                .strength(10.0F, 1200.0F)
                .requiresCorrectToolForDrops()
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false)
        );
    }
}
