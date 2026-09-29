package com.morecritters.mod.procedures;

import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class PotBlossombushOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_BLOSSOMBUSH.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModBlocks.BLOSSOMBUSH.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = Blocks.FLOWER_POT.defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var19) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_ELECTRIC_BLOSSOMBUSH.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModBlocks.ELECTRIC_BLOSSOMBUSH.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = Blocks.FLOWER_POT.defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var18) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_VITA.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModBlocks.VITA_SHROOM.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = Blocks.FLOWER_POT.defaultBlockState();
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
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.POT_MORI.get()
                && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                if (entity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModBlocks.MORI_SHROOM.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockState _bs = Blocks.FLOWER_POT.defaultBlockState();
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
            }
        }
    }
}
