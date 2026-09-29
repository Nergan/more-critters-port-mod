package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.WanderingCollectorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class WanderingCollectorOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains"))) {
                if (entity instanceof WanderingCollectorEntity animatable) {
                    animatable.setTexture("wandering_collector_plains");
                }
            } else if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("savanna"))
                && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("savanna_plateau"))
                && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_savanna"))) {
                if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("desert"))) {
                    if (entity instanceof WanderingCollectorEntity animatable) {
                        animatable.setTexture("wandering_collector_desert");
                    }
                } else if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("badlands"))
                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("eroded_badlands"))
                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("wooded_badlands"))) {
                    if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("snowy_plains"))
                        && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("snowy_taiga"))) {
                        if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("swamp"))
                            && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("mangrove_swamp"))) {
                            if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("jungle"))
                                && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("bamboo_jungle"))
                                && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("sparse_jungle"))) {
                                if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("deep_ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("cold_ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("deep_cold_ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("frozen_ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("deep_frozen_ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("lukewarm_ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("deep_lukewarm_ocean"))
                                    && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("warm_ocean"))) {
                                    if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("taiga"))
                                        && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("old_growth_pine_taiga"))
                                        && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("old_growth_spruce_taiga"))) {
                                        if (!world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("dripstone_caves"))
                                            && !world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("lush_caves"))) {
                                            if (entity instanceof WanderingCollectorEntity animatable) {
                                                animatable.setTexture("wandering_collector_plains");
                                            }
                                        } else if (entity instanceof WanderingCollectorEntity animatable) {
                                            animatable.setTexture("wandering_collector_cave");
                                        }
                                    } else if (entity instanceof WanderingCollectorEntity animatable) {
                                        animatable.setTexture("wandering_collector_taiga");
                                    }
                                } else if (entity instanceof WanderingCollectorEntity animatable) {
                                    animatable.setTexture("wandering_collector_ocean");
                                }
                            } else if (entity instanceof WanderingCollectorEntity animatable) {
                                animatable.setTexture("wandering_collector_jungle");
                            }
                        } else if (entity instanceof WanderingCollectorEntity animatable) {
                            animatable.setTexture("wandering_collector_swamp");
                        }
                    } else if (entity instanceof WanderingCollectorEntity animatable) {
                        animatable.setTexture("wandering_collector_tundra");
                    }
                } else if (entity instanceof WanderingCollectorEntity animatable) {
                    animatable.setTexture("wandering_collector_badlands");
                }
            } else if (entity instanceof WanderingCollectorEntity animatable) {
                animatable.setTexture("wandering_collector_savanna");
            }
        }
    }
}
