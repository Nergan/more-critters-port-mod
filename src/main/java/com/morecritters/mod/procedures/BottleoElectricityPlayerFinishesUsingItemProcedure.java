package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BottleoElectricityPlayerFinishesUsingItemProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.electric_bottle.drink")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.electric_bottle.drink")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F,
                        false
                    );
                }
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.ELECTROCUTED, 2000, 0, false, false));
            }
        }
    }
}
