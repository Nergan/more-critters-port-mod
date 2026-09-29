package com.morecritters.mod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;

public class GravediggerNaturalEntitySpawningConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                == Level.OVERWORLD
            && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("the_void"))
            && y <= 20.0
            && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
            && !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("alexscaves:alexs_caves_biomes")));
    }
}
