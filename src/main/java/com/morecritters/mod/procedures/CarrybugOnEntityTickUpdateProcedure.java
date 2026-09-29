package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.CarrybugEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CarrybugOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double healchance = 0.0;
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
                healchance = Mth.nextInt(RandomSource.create(), 1, 500);
                if (healchance == 1.0 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, true));
                }
            }

            if (entity.isVehicle()
                && !(
                    entity.getFirstPassenger() instanceof ServerPlayer _plr6
                        && _plr6.level() instanceof ServerLevel
                        && _plr6.getAdvancements()
                            .getOrStartProgress(_plr6.server.getAdvancements().get(ResourceLocation.parse("more_critters:gain_access_to_carrybug")))
                            .isDone()
                )) {
                MoreCritters.queueServerWork(1, () -> {
                    entity.getFirstPassenger().stopRiding();
                    MoreCritters.queueServerWork(1, () -> {
                        if (entity instanceof CarrybugEntity) {
                            ((CarrybugEntity)entity).setAnimation("kick1");
                        }
                    });
                });
                if (entity.getFirstPassenger() instanceof Player _player && !_player.level().isClientSide()) {
                    _player.displayClientMessage(Component.literal("Trade with the Wandering Collector more in order to ride the Carrybug"), true);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.carrybug.kick")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.carrybug.kick")),
                            SoundSource.NEUTRAL,
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
