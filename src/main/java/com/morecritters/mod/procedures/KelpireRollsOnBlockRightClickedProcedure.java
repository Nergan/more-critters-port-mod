package com.morecritters.mod.procedures;

import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class KelpireRollsOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity != null) {
            if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1)
                == 0) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.KELPIRE_ROLL_PIECE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }

                int _value = 2;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1
                )
                == 2) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.KELPIRE_ROLL_PIECE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }

                int _value = 3;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1
                )
                == 3) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.KELPIRE_ROLL_PIECE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }

                int _value = 4;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
                        ? blockstate.getValue(_getip13)
                        : -1
                )
                == 4) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.KELPIRE_ROLL_PIECE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }

                int _value = 5;
                BlockPos _pos = BlockPos.containing(x, y, z);
                BlockState _bs = world.getBlockState(_pos);
                if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp
                    && _integerProp.getPossibleValues().contains(_value)) {
                    world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
                }
            } else if ((
                    blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17
                        ? blockstate.getValue(_getip17)
                        : -1
                )
                == 5) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.KELPIRE_ROLL_PIECE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }

                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockState _bs = Blocks.AIR.defaultBlockState();
                BlockState _bso = world.getBlockState(_bp);
                for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                    if (_property != null && _bs.getValue(_property) != null) {
                        try {
                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                        } catch (Exception var21) {
                        }
                    }
                }

                world.setBlock(_bp, _bs, 3);
            }
        }
    }
}
