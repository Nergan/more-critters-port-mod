package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class ElectrocutedHurtProcedure {
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
            if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MoreCrittersModMobEffects.ELECTROCUTED)) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_transfer")),
                            SoundSource.PLAYERS,
                            3.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.electric_transfer")),
                            SoundSource.PLAYERS,
                            3.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(
                        new MobEffectInstance(
                            MoreCrittersModMobEffects.ELECTROCUTED,
                            sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.ELECTROCUTED)
                                ? _livEnt.getEffect(MoreCrittersModMobEffects.ELECTROCUTED).getDuration()
                                : 0,
                            sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.ELECTROCUTED)
                                ? _livEnt.getEffect(MoreCrittersModMobEffects.ELECTROCUTED).getAmplifier()
                                : 0,
                            false,
                            false
                        )
                    );
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.ELECTROCUTED);
                }

                entity.hurt(
                    new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                    (float)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)
                );
            }
        }
    }
}
