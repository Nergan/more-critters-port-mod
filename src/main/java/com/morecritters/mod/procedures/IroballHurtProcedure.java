package com.morecritters.mod.procedures;

import net.neoforged.bus.api.ICancellableEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.IroballEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class IroballHurtProcedure {
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
                event.getSource().getEntity(),
                event.getAmount()
            );
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
        execute(null, world, x, y, z, entity, sourceentity, amount);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
        if (entity != null && sourceentity != null) {
            if (entity instanceof IroballEntity) {
                entity.lookAt(Anchor.EYES, new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()));
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iroball.hurt")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iroball.hurt")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                entity.setDeltaMovement(
                    new Vec3(
                        entity.getLookAngle().x * (amount * -1.0 / 2.0),
                        entity.getLookAngle().y * (amount * -1.0 / 2.0),
                        entity.getLookAngle().z * (amount * -1.0 / 2.0)
                    )
                );
                if (event instanceof ICancellableEvent _cancellable) {
                    _cancellable.setCanceled(true);
                }
            }
        }
    }
}
