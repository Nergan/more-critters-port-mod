package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.CritterEaterEntity;
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
public class CritterEaterAttackProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(
                event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity()
            );
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        execute(null, world, x, y, z, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity != null) {
            if (sourceentity instanceof CritterEaterEntity) {
                if (sourceentity instanceof CritterEaterEntity animatable) {
                    animatable.setTexture("critter_eater");
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.critter_eater.attack")),
                            SoundSource.HOSTILE,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.critter_eater.attack")),
                            SoundSource.HOSTILE,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }
        }
    }
}
