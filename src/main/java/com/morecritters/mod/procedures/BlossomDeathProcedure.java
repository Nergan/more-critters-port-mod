package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class BlossomDeathProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(
                event,
                event.getEntity().level(),
                event.getEntity().getX(),
                event.getEntity().getY(),
                event.getEntity().getZ(),
                event.getEntity(),
                event.getSource().getEntity()
            );
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            double rate = 0.0;
            if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MoreCrittersModMobEffects.BLOSSOMING)) {
                if (sourceentity instanceof ServerPlayer _player) {
                    AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:kill_infected_mob"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(MoreCrittersModParticleTypes.BLOSSOM_EXPLOSION.get(), x, y, z, 7, 1.0, 1.0, 1.0, 0.0);
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.blossoming_explosion")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.blossoming_explosion")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CREEBLOSSOM
                        .get()
                        .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.2, 0.1);
                    }
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CREEBLOSSOM
                        .get()
                        .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.2, -0.1);
                    }
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CREEBLOSSOM
                        .get()
                        .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.1, 0.2, 0.0);
                    }
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CREEBLOSSOM
                        .get()
                        .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(-0.1, 0.2, 0.0);
                    }
                }
            }
        }
    }
}
