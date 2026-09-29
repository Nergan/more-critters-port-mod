package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.BlackIropodEntity;
import com.morecritters.mod.entity.IropodEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class IropodAttackedProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof IropodEntity) {
                if (entity.isInWaterOrBubble()) {
                    entity.getPersistentData().putBoolean("attack", true);
                    if (!((IropodEntity)entity).animationprocedure.equals("lock")) {
                        MoreCritters.queueServerWork(
                            5,
                            () -> {
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.lock")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.lock")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }
                            }
                        );
                    }

                    if (entity instanceof IropodEntity) {
                        ((IropodEntity)entity).setAnimation("lock");
                    }

                    entity.getPersistentData().putDouble("hidetimer", 100.0);
                }
            } else if (entity instanceof BlackIropodEntity && entity.isInWaterOrBubble()) {
                entity.getPersistentData().putBoolean("attack", true);
                if (entity instanceof BlackIropodEntity) {
                    ((BlackIropodEntity)entity).setAnimation("lock");
                }

                if (!((BlackIropodEntity)entity).animationprocedure.equals("lock")) {
                    MoreCritters.queueServerWork(
                        5,
                        () -> {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.lock")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.lock")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        }
                    );
                }

                entity.getPersistentData().putDouble("hidetimer", 100.0);
            }
        }
    }
}
