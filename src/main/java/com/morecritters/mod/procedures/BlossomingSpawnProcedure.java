package com.morecritters.mod.procedures;

import net.minecraft.tags.EntityTypeTags;
import javax.annotation.Nullable;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class BlossomingSpawnProcedure {
    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (entity instanceof Monster
                && (
                    entity instanceof LivingEntity _livEnt1 && _livEnt1.getType().is(EntityTypeTags.UNDEAD)
                        || entity instanceof LivingEntity _livEnt2 && _livEnt2.getType().is(EntityTypeTags.ARTHROPOD)
                )
                && !(entity instanceof Creeper)
                && (
                    world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("badlands"))
                        || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("eroded_badlands"))
                        || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("wooded_badlands"))
                        || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("savanna"))
                        || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("savanna_plateau"))
                        || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_savanna"))
                        || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("desert"))
                )) {
                rate = Mth.nextInt(RandomSource.create(), 1, (int)ServerConfig.CONFIG.creeblossomInfection.get().doubleValue());
                if (rate == 1.0 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.BLOSSOMING, 2147483647, 0, false, false));
                }
            }
        }
    }
}
