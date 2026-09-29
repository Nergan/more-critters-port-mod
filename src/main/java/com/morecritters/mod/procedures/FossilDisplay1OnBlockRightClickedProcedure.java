package com.morecritters.mod.procedures;

import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
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

public class FossilDisplay1OnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_1.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_1.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var32) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_2.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_2.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var31) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_3.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_3.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var30) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_4.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_4.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var29) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_5.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_5.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var28) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_6.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_6.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var27) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_7.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_7.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var26) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_8.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_8.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var25) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_9.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_9.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var24) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_10.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_10.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var23) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_11.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_FOSSIL_1.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var22) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_12.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_FOSSIL_2.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_13.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_FOSSIL_3.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var20) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_14.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_1.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_15.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_2.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_16.get()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_3.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.FOSSIL_DISPLAY_17.get()
                && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                if (entity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_4.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }

                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY.get().defaultBlockState();
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
