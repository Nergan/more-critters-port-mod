package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;

public class VitaPlaceProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return world.getBlockState(BlockPos.containing(x, y - 1.0, z)).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
            && world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != MoreCrittersModBlocks.POT_VITA.get()
            && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != MoreCrittersModBlocks.POT_VITA.get()
            && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != MoreCrittersModBlocks.POT_VITA.get()
            && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != MoreCrittersModBlocks.POT_VITA.get();
    }
}
