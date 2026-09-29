package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ElectrocutedOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        double rate2 = 0.0;
        rate = Mth.nextInt(RandomSource.create(), 1, 10);
        rate2 = Mth.nextInt(RandomSource.create(), 1, 30);
        if (rate == 1.0 && world instanceof ServerLevel _level) {
            _level.sendParticles(
                MoreCrittersModParticleTypes.ZAP.get(), x, y + 1.0, z, (int)Mth.nextDouble(RandomSource.create(), 4.0, 5.0), 0.5, 0.5, 0.5, 0.0
            );
        }

        if (rate2 == 1.0 && world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(
                    (Player)null,
                    BlockPos.containing(x, y, z),
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.electric_hum")),
                    SoundSource.AMBIENT,
                    3.0F,
                    1.0F
                );
            } else {
                _level.playLocalSound(
                    x,
                    y,
                    z,
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:ambient.electric_hum")),
                    SoundSource.AMBIENT,
                    3.0F,
                    1.0F,
                    false
                );
            }
        }
    }
}
