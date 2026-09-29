package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SlablizardEggOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
        if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
                _blockEntity.getPersistentData().putDouble("timer", (new Object() {
                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                    }
                }).getValue(world, BlockPos.containing(x, y, z), "timer") - 1.0);
            }

            if (world instanceof Level _level) {
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
        }

        if ((new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
            }
        }).getValue(world, BlockPos.containing(x, y, z), "timer") < 0.0) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.turtle.egg_hatch")),
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.turtle.egg_hatch")), SoundSource.BLOCKS, 1.0F, 1.0F, false
                    );
                }
            }

            if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1)
                == 0) {
                world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState()));
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:bouncelizard ~0.5 ~0.5 ~0.5 {Age:-24000, Datafromegg:true}"
                        );
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1
                )
                == 2) {
                world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState()));

                for (int index0 = 0; index0 < 2; index0++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:bouncelizard ~0.5 ~0.5 ~0.5 {Age:-24000, Datafromegg:true}"
                            );
                    }
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
                        ? blockstate.getValue(_getip13)
                        : -1
                )
                == 3) {
                world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState()));

                for (int index1 = 0; index1 < 3; index1++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:bouncelizard ~0.5 ~0.5 ~0.5 {Age:-24000, Datafromegg:true}"
                            );
                    }
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17
                        ? blockstate.getValue(_getip17)
                        : -1
                )
                == 4) {
                world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState()));

                for (int index2 = 0; index2 < 4; index2++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:bouncelizard ~0.5 ~0.5 ~0.5 {Age:-24000, Datafromegg:true}"
                            );
                    }
                }
            }

            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockState _bs = Blocks.AIR.defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                if (_property != null && _bs.getValue(_property) != null) {
                    try {
                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                    } catch (Exception var15) {
                    }
                }
            }

            world.setBlock(_bp, _bs, 3);
        }
    }
}
