package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.WarptrapEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class WarpTrapAttackProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
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
            if (sourceentity instanceof WarptrapEntity) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.warptrap.bite")),
                            SoundSource.HOSTILE,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.warptrap.bite")),
                            SoundSource.HOSTILE,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                entity.setDeltaMovement(new Vec3(0.0, 0.5, 0.0));
                Entity _ent = entity;
                _ent.teleportTo(sourceentity.getX(), sourceentity.getY() + 1.0, sourceentity.getZ());
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection.teleport(sourceentity.getX(), sourceentity.getY() + 1.0, sourceentity.getZ(), _ent.getYRot(), _ent.getXRot());
                }

                sourceentity.setShiftKeyDown(false);
                if (entity instanceof EnderMan) {
                    entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 20.0F);
                    _ent = entity;
                    _ent.teleportTo(sourceentity.getX(), sourceentity.getY() + 1.0, sourceentity.getZ());
                    if (_ent instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection.teleport(sourceentity.getX(), sourceentity.getY() + 1.0, sourceentity.getZ(), _ent.getYRot(), _ent.getXRot());
                    }
                }
            }
        }
    }
}
