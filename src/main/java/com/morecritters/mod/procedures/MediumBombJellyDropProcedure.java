package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map.Entry;
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
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MediumBombJellyDropProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
            == Level.NETHER) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockState _bs = Blocks.AIR.defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                if (_property != null && _bs.getValue(_property) != null) {
                    try {
                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                    } catch (Exception var17) {
                    }
                }
            }

            world.setBlock(_bp, _bs, 3);
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.extinguish_fire")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.extinguish_fire")),
                        SoundSource.PLAYERS,
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
                                CommandSource.NULL,
                                new Vec3(x + 0.5, y + 0.5, z + 0.5),
                                Vec2.ZERO,
                                _level,
                                4,
                                "",
                                Component.literal(""),
                                _level.getServer(),
                                null
                            )
                            .withSuppressedOutput(),
                        "/particle minecraft:large_smoke ~ ~ ~ 0.1 0.2 0.1 0 15 force"
                    );
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL,
                                new Vec3(x + 0.5, y + 0.5, z + 0.5),
                                Vec2.ZERO,
                                _level,
                                4,
                                "",
                                Component.literal(""),
                                _level.getServer(),
                                null
                            )
                            .withSuppressedOutput(),
                        "/summon more_critters:bomb_jelly_medium ~ ~ ~ {PersistenceRequired:1b,}"
                    );
            }
        } else {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockState _bs = Blocks.WATER.defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                if (_property != null && _bs.getValue(_property) != null) {
                    try {
                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                    } catch (Exception var16) {
                    }
                }
            }

            world.setBlock(_bp, _bs, 3);
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL,
                                new Vec3(x + 0.5, y + 0.5, z + 0.5),
                                Vec2.ZERO,
                                _level,
                                4,
                                "",
                                Component.literal(""),
                                _level.getServer(),
                                null
                            )
                            .withSuppressedOutput(),
                        "/summon more_critters:bomb_jelly_medium ~ ~ ~ {PersistenceRequired:1b,}"
                    );
            }
        }
    }
}
