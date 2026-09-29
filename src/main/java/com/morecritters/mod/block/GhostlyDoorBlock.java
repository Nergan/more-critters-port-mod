package com.morecritters.mod.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GhostlyDoorBlock extends DoorBlock {
    public GhostlyDoorBlock() {
        super(BlockSetType.OAK, Properties.of()
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS)
                .sound(SoundType.WOOD)
                .strength(2.0F, 3.0F)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));
    }
}
