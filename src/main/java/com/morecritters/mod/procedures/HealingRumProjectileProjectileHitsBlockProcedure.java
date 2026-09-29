package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HealingRumProjectileProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            _level.getServer()
                .getCommands()
                .performPrefixedCommand(
                    new CommandSourceStack(
                            CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                        )
                        .withSuppressedOutput(),
                    "/particle more_critters:heal_plus ~ ~1 ~ 0.5 0.5 0.5 0.01 6"
                );
        }

        if (world instanceof ServerLevel _level) {
            _level.getServer()
                .getCommands()
                .performPrefixedCommand(
                    new CommandSourceStack(
                            CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                        )
                        .withSuppressedOutput(),
                    "/particle minecraft:item{item:\"minecraft:glass_bottle\"} ~ ~1 ~ 0.2 0.2 0.2 0.01 4"
                );
        }

        if (!world.isClientSide() && world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(
                    (Player)null,
                    BlockPos.containing(x, y, z),
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.healing_rum.break")),
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F
                );
            } else {
                _level.playLocalSound(
                    x,
                    y,
                    z,
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.healing_rum.break")),
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F,
                    false
                );
            }
        }

        if (world instanceof ServerLevel _level) {
            _level.getServer()
                .getCommands()
                .performPrefixedCommand(
                    new CommandSourceStack(
                            CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                        )
                        .withSuppressedOutput(),
                    "/summon area_effect_cloud ~ ~1 ~ {Particle:{type:\"minecraft:entity_effect\",color:-1}, Radius:2.0f, Duration:60, RadiusPerTick:-0.033f, potion_contents:{potion:\"minecraft:regeneration\"}}"
                );
        }
    }
}
