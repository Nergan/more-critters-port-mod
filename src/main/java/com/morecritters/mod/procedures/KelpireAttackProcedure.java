package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.KelpireEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class KelpireAttackProcedure {
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
            if (sourceentity instanceof KelpireEntity && sourceentity instanceof TamableAnimal _tamEnt && _tamEnt.isTame() && sourceentity.isInWaterOrBubble()) {
                MoreCritters.queueServerWork(
                    20,
                    () -> {
                        if (sourceentity instanceof KelpireEntity) {
                            ((KelpireEntity)sourceentity).setAnimation("burp");
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.kelpire.burp")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.kelpire.burp")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        sourceentity.setDeltaMovement(
                            new Vec3(sourceentity.getLookAngle().x * -0.6, sourceentity.getLookAngle().y * -0.6, sourceentity.getLookAngle().z * -0.6)
                        );
                        MoreCritters.queueServerWork(
                            1,
                            () -> {
                                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 5.0, 10.0); index0++) {
                                    if (world instanceof ServerLevel _levelxxx) {
                                        _levelxxx.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()),
                                                        Vec2.ZERO,
                                                        _levelxxx,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _levelxxx.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle more_critters:blood_bubble_particle ~ ~ ~ 0.3 0.3 0.3 0.02 1 force"
                                            );
                                    }
                                }

                                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) > 10.0F) {
                                    for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 2.0, 4.0); index1++) {
                                        if (world instanceof ServerLevel _levelxx) {
                                            Entity entityToSpawn = MoreCrittersModEntities.BUBBLE_ENTITY
                                                .get()
                                                .spawn(
                                                    _levelxx,
                                                    BlockPos.containing(sourceentity.getX(), sourceentity.getY() + 0.2, sourceentity.getZ()),
                                                    MobSpawnType.MOB_SUMMONED
                                                );
                                            if (entityToSpawn != null) {
                                                entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                            }
                                        }
                                    }
                                } else if (world instanceof ServerLevel _levelx) {
                                    Entity entityToSpawn = MoreCrittersModEntities.BUBBLE_ENTITY
                                        .get()
                                        .spawn(
                                            _levelx,
                                            BlockPos.containing(sourceentity.getX(), sourceentity.getY() + 0.2, sourceentity.getZ()),
                                            MobSpawnType.MOB_SUMMONED
                                        );
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                    }
                                }
                            }
                        );
                    }
                );
            }
        }
    }
}
