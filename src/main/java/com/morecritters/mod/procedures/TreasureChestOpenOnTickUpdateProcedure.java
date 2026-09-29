package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class TreasureChestOpenOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
                _blockEntity.getPersistentData().putDouble("break", (new Object() {
                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                    }
                }).getValue(world, BlockPos.containing(x, y, z), "break") - 1.0);
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
        }).getValue(world, BlockPos.containing(x, y, z), "break") == 0.0) {
            if (!world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.destroy")),
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.destroy")),
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F,
                        false
                    );
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
                    } catch (Exception var14) {
                    }
                }
            }

            world.setBlock(_bp, _bs, 3);
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MoreCrittersModBlocks.TREASURE_CHEST.get().defaultBlockState()));
        }
    }
}
