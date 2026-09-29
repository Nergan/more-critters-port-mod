package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class EvoTableProcedure1Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null) {
            return;
        }
        MoreCritters.queueServerWork(1, () -> {
            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.EVOLITE.get()) {
                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG.get()) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.INK_SAC).copy();
                        _setstack.setCount(1);
                        ((Slot) _slots.get(5)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.HONEYCOMB).copy();
                        _setstack.setCount(1);
                        ((Slot) _slots.get(6)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.INK_SAC) {
                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG_RARE.get()).copy();
                                _setstack.setCount(1);
                                ((Slot) _slots.get(1)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                            return;
                        }
                    }
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                        _setstack.setCount(1);
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else {
                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG_RARE.get()) {
                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.SLIME_BALL).copy();
                            _setstack.setCount(1);
                            ((Slot) _slots.get(5)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }
                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.QUARTZ).copy();
                            _setstack.setCount(1);
                            ((Slot) _slots.get(6)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }
                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.FERMENTED_SPIDER_EYE).copy();
                            _setstack.setCount(1);
                            ((Slot) _slots.get(7)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }
                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.SLIME_BALL) {
                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.QUARTZ) {
                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.FERMENTED_SPIDER_EYE) {
                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_CUBEFROG_EPIC.get()).copy();
                                        _setstack.setCount(1);
                                        ((Slot) _slots.get(1)).set(_setstack);
                                        _player.containerMenu.broadcastChanges();
                                    }
                                    return;
                                }
                            }
                        }
                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                            _setstack.setCount(1);
                            ((Slot) _slots.get(1)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }
                    } else {
                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.EXPLOSIVE_JELLY.get()).copy();
                                _setstack.setCount(1);
                                ((Slot) _slots.get(5)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.SPRINKLES.get()).copy();
                                _setstack.setCount(1);
                                ((Slot) _slots.get(6)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.EXPLOSIVE_JELLY.get()) {
                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.SPRINKLES.get()) {
                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM_RARE.get()).copy();
                                        _setstack.setCount(1);
                                        ((Slot) _slots.get(1)).set(_setstack);
                                        _player.containerMenu.broadcastChanges();
                                    }
                                    return;
                                }
                            }
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                _setstack.setCount(1);
                                ((Slot) _slots.get(1)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else {
                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM_RARE.get()) {
                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.SHARK_TOOTH.get()).copy();
                                    _setstack.setCount(1);
                                    ((Slot) _slots.get(5)).set(_setstack);
                                    _player.containerMenu.broadcastChanges();
                                }
                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                    ItemStack _setstack = new ItemStack(Items.CHORUS_FRUIT).copy();
                                    _setstack.setCount(1);
                                    ((Slot) _slots.get(6)).set(_setstack);
                                    _player.containerMenu.broadcastChanges();
                                }
                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                    ItemStack _setstack = new ItemStack(Items.BONE).copy();
                                    _setstack.setCount(1);
                                    ((Slot) _slots.get(7)).set(_setstack);
                                    _player.containerMenu.broadcastChanges();
                                }
                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.SHARK_TOOTH.get()) {
                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.CHORUS_FRUIT) {
                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.BONE) {
                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PLAINSWYRM_EPIC.get()).copy();
                                                _setstack.setCount(1);
                                                ((Slot) _slots.get(1)).set(_setstack);
                                                _player.containerMenu.broadcastChanges();
                                            }
                                            return;
                                        }
                                    }
                                }
                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                    _setstack.setCount(1);
                                    ((Slot) _slots.get(1)).set(_setstack);
                                    _player.containerMenu.broadcastChanges();
                                }
                            } else {
                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_DUNGER.get()) {
                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                        ItemStack _setstack = new ItemStack(Items.COPPER_INGOT).copy();
                                        _setstack.setCount(1);
                                        ((Slot) _slots.get(5)).set(_setstack);
                                        _player.containerMenu.broadcastChanges();
                                    }
                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                        ItemStack _setstack = new ItemStack(Items.BEETROOT).copy();
                                        _setstack.setCount(1);
                                        ((Slot) _slots.get(6)).set(_setstack);
                                        _player.containerMenu.broadcastChanges();
                                    }
                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.COPPER_INGOT) {
                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.BEETROOT) {
                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER_RARE.get()).copy();
                                                _setstack.setCount(1);
                                                ((Slot) _slots.get(1)).set(_setstack);
                                                _player.containerMenu.broadcastChanges();
                                            }
                                            return;
                                        }
                                    }
                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                        _setstack.setCount(1);
                                        ((Slot) _slots.get(1)).set(_setstack);
                                        _player.containerMenu.broadcastChanges();
                                    }
                                } else {
                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_DUNGER_RARE.get()) {
                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                            ItemStack _setstack = new ItemStack(Items.GLOW_INK_SAC).copy();
                                            _setstack.setCount(1);
                                            ((Slot) _slots.get(5)).set(_setstack);
                                            _player.containerMenu.broadcastChanges();
                                        }
                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                            ItemStack _setstack = new ItemStack(Items.PRISMARINE_CRYSTALS).copy();
                                            _setstack.setCount(1);
                                            ((Slot) _slots.get(6)).set(_setstack);
                                            _player.containerMenu.broadcastChanges();
                                        }
                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                            ItemStack _setstack = new ItemStack(Items.AMETHYST_SHARD).copy();
                                            _setstack.setCount(1);
                                            ((Slot) _slots.get(7)).set(_setstack);
                                            _player.containerMenu.broadcastChanges();
                                        }
                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.GLOW_INK_SAC) {
                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.PRISMARINE_CRYSTALS) {
                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.AMETHYST_SHARD) {
                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DUNGER_EPIC.get()).copy();
                                                        _setstack.setCount(1);
                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                        _player.containerMenu.broadcastChanges();
                                                    }
                                                    return;
                                                }
                                            }
                                        }
                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                            _setstack.setCount(1);
                                            ((Slot) _slots.get(1)).set(_setstack);
                                            _player.containerMenu.broadcastChanges();
                                        }
                                    } else {
                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_SNEK.get()) {
                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                                _setstack.setCount(1);
                                                ((Slot) _slots.get(5)).set(_setstack);
                                                _player.containerMenu.broadcastChanges();
                                            }
                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                ItemStack _setstack = new ItemStack(Items.REDSTONE).copy();
                                                _setstack.setCount(1);
                                                ((Slot) _slots.get(6)).set(_setstack);
                                                _player.containerMenu.broadcastChanges();
                                            }
                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.REDSTONE) {
                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK_RARE.get()).copy();
                                                        _setstack.setCount(1);
                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                        _player.containerMenu.broadcastChanges();
                                                    }
                                                    return;
                                                }
                                            }
                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                _setstack.setCount(1);
                                                ((Slot) _slots.get(1)).set(_setstack);
                                                _player.containerMenu.broadcastChanges();
                                            }
                                        } else {
                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_SNEK_RARE.get()) {
                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.END_DUST.get()).copy();
                                                    _setstack.setCount(1);
                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                    _player.containerMenu.broadcastChanges();
                                                }
                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                    ItemStack _setstack = new ItemStack(Blocks.CHERRY_LEAVES).copy();
                                                    _setstack.setCount(1);
                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                    _player.containerMenu.broadcastChanges();
                                                }
                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                    ItemStack _setstack = new ItemStack(Blocks.POPPY).copy();
                                                    _setstack.setCount(1);
                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                    _player.containerMenu.broadcastChanges();
                                                }
                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.END_DUST.get()) {
                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.CHERRY_LEAVES.asItem()) {
                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Blocks.POPPY.asItem()) {
                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SNEK_EPIC.get()).copy();
                                                                _setstack.setCount(1);
                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                _player.containerMenu.broadcastChanges();
                                                            }
                                                            return;
                                                        }
                                                    }
                                                }
                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                    _setstack.setCount(1);
                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                    _player.containerMenu.broadcastChanges();
                                                }
                                            } else {
                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_EXPY.get()) {
                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                        ItemStack _setstack = new ItemStack(Items.GLOWSTONE_DUST).copy();
                                                        _setstack.setCount(1);
                                                        ((Slot) _slots.get(5)).set(_setstack);
                                                        _player.containerMenu.broadcastChanges();
                                                    }
                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                        ItemStack _setstack = new ItemStack(Items.QUARTZ).copy();
                                                        _setstack.setCount(1);
                                                        ((Slot) _slots.get(6)).set(_setstack);
                                                        _player.containerMenu.broadcastChanges();
                                                    }
                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.GLOWSTONE_DUST) {
                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.QUARTZ) {
                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY_RARE.get()).copy();
                                                                _setstack.setCount(1);
                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                _player.containerMenu.broadcastChanges();
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                        _setstack.setCount(1);
                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                        _player.containerMenu.broadcastChanges();
                                                    }
                                                } else {
                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_EXPY_RARE.get()) {
                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                            ItemStack _setstack = new ItemStack(Items.REDSTONE).copy();
                                                            _setstack.setCount(1);
                                                            ((Slot) _slots.get(5)).set(_setstack);
                                                            _player.containerMenu.broadcastChanges();
                                                        }
                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                            ItemStack _setstack = new ItemStack(Blocks.GLOWSTONE).copy();
                                                            _setstack.setCount(1);
                                                            ((Slot) _slots.get(6)).set(_setstack);
                                                            _player.containerMenu.broadcastChanges();
                                                        }
                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                            ItemStack _setstack = new ItemStack(Items.PHANTOM_MEMBRANE).copy();
                                                            _setstack.setCount(1);
                                                            ((Slot) _slots.get(7)).set(_setstack);
                                                            _player.containerMenu.broadcastChanges();
                                                        }
                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.REDSTONE) {
                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLOWSTONE.asItem()) {
                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.PHANTOM_MEMBRANE) {
                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_EXPY_EPIC.get()).copy();
                                                                        _setstack.setCount(1);
                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                        _player.containerMenu.broadcastChanges();
                                                                    }
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                            _setstack.setCount(1);
                                                            ((Slot) _slots.get(1)).set(_setstack);
                                                            _player.containerMenu.broadcastChanges();
                                                        }
                                                    } else {
                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_SCOWL.get()) {
                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                ItemStack _setstack = new ItemStack(Items.RABBIT_HIDE).copy();
                                                                _setstack.setCount(1);
                                                                ((Slot) _slots.get(5)).set(_setstack);
                                                                _player.containerMenu.broadcastChanges();
                                                            }
                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                ItemStack _setstack = new ItemStack(Items.GLOW_BERRIES).copy();
                                                                _setstack.setCount(1);
                                                                ((Slot) _slots.get(6)).set(_setstack);
                                                                _player.containerMenu.broadcastChanges();
                                                            }
                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.RABBIT_HIDE) {
                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.GLOW_BERRIES) {
                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL_RARE.get()).copy();
                                                                        _setstack.setCount(1);
                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                        _player.containerMenu.broadcastChanges();
                                                                    }
                                                                    return;
                                                                }
                                                            }
                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                _setstack.setCount(1);
                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                _player.containerMenu.broadcastChanges();
                                                            }
                                                        } else {
                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_SCOWL_RARE.get()) {
                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                    ItemStack _setstack = new ItemStack(Items.INK_SAC).copy();
                                                                    _setstack.setCount(1);
                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                    _player.containerMenu.broadcastChanges();
                                                                }
                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                    ItemStack _setstack = new ItemStack(Items.PRISMARINE_CRYSTALS).copy();
                                                                    _setstack.setCount(1);
                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                    _player.containerMenu.broadcastChanges();
                                                                }
                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                    ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI).copy();
                                                                    _setstack.setCount(1);
                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                    _player.containerMenu.broadcastChanges();
                                                                }
                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.INK_SAC) {
                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.PRISMARINE_CRYSTALS) {
                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.LAPIS_LAZULI) {
                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_SCOWL_EPIC.get()).copy();
                                                                                _setstack.setCount(1);
                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                _player.containerMenu.broadcastChanges();
                                                                            }
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                    _setstack.setCount(1);
                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                    _player.containerMenu.broadcastChanges();
                                                                }
                                                            } else {
                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL.get()) {
                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                        ItemStack _setstack = new ItemStack(Blocks.CYAN_WOOL).copy();
                                                                        _setstack.setCount(1);
                                                                        ((Slot) _slots.get(5)).set(_setstack);
                                                                        _player.containerMenu.broadcastChanges();
                                                                    }
                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                        ItemStack _setstack = new ItemStack(Items.STRING).copy();
                                                                        _setstack.setCount(1);
                                                                        ((Slot) _slots.get(6)).set(_setstack);
                                                                        _player.containerMenu.broadcastChanges();
                                                                    }
                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.CYAN_WOOL.asItem()) {
                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.STRING) {
                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL_RARE.get()).copy();
                                                                                _setstack.setCount(1);
                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                _player.containerMenu.broadcastChanges();
                                                                            }
                                                                            return;
                                                                        }
                                                                    }
                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                        _setstack.setCount(1);
                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                        _player.containerMenu.broadcastChanges();
                                                                    }
                                                                } else {
                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL_RARE.get()) {
                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                            ItemStack _setstack = new ItemStack(Items.BREAD).copy();
                                                                            _setstack.setCount(1);
                                                                            ((Slot) _slots.get(5)).set(_setstack);
                                                                            _player.containerMenu.broadcastChanges();
                                                                        }
                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.RAW_BUNBUG_MEAT.get()).copy();
                                                                            _setstack.setCount(1);
                                                                            ((Slot) _slots.get(6)).set(_setstack);
                                                                            _player.containerMenu.broadcastChanges();
                                                                        }
                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.BUNBUG_CRUST.get()).copy();
                                                                            _setstack.setCount(1);
                                                                            ((Slot) _slots.get(7)).set(_setstack);
                                                                            _player.containerMenu.broadcastChanges();
                                                                        }
                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.BREAD) {
                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.RAW_BUNBUG_MEAT.get()) {
                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.BUNBUG_CRUST.get()) {
                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_ROLLBALL_EPIC.get()).copy();
                                                                                        _setstack.setCount(1);
                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                        _player.containerMenu.broadcastChanges();
                                                                                    }
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                            _setstack.setCount(1);
                                                                            ((Slot) _slots.get(1)).set(_setstack);
                                                                            _player.containerMenu.broadcastChanges();
                                                                        }
                                                                    } else {
                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB.get()) {
                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                ItemStack _setstack = new ItemStack(Items.GUNPOWDER).copy();
                                                                                _setstack.setCount(1);
                                                                                ((Slot) _slots.get(5)).set(_setstack);
                                                                                _player.containerMenu.broadcastChanges();
                                                                            }
                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                ItemStack _setstack = new ItemStack(Items.FEATHER).copy();
                                                                                _setstack.setCount(1);
                                                                                ((Slot) _slots.get(6)).set(_setstack);
                                                                                _player.containerMenu.broadcastChanges();
                                                                            }
                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.GUNPOWDER) {
                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.FEATHER) {
                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB_RARE.get()).copy();
                                                                                        _setstack.setCount(1);
                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                        _player.containerMenu.broadcastChanges();
                                                                                    }
                                                                                    return;
                                                                                }
                                                                            }
                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                _setstack.setCount(1);
                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                _player.containerMenu.broadcastChanges();
                                                                            }
                                                                        } else {
                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB_RARE.get()) {
                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                    ItemStack _setstack = new ItemStack(Blocks.CRYING_OBSIDIAN).copy();
                                                                                    _setstack.setCount(1);
                                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                                    _player.containerMenu.broadcastChanges();
                                                                                }
                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                    ItemStack _setstack = new ItemStack(Items.GLOW_INK_SAC).copy();
                                                                                    _setstack.setCount(1);
                                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                                    _player.containerMenu.broadcastChanges();
                                                                                }
                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                    ItemStack _setstack = new ItemStack(Items.AMETHYST_SHARD).copy();
                                                                                    _setstack.setCount(1);
                                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                                    _player.containerMenu.broadcastChanges();
                                                                                }
                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.CRYING_OBSIDIAN.asItem()) {
                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.GLOW_INK_SAC) {
                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.AMETHYST_SHARD) {
                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OPALCRAB_EPIC.get()).copy();
                                                                                                _setstack.setCount(1);
                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                _player.containerMenu.broadcastChanges();
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                    _setstack.setCount(1);
                                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                                    _player.containerMenu.broadcastChanges();
                                                                                }
                                                                            } else {
                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_MOTHKID.get()) {
                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                        ItemStack _setstack = new ItemStack(Items.SPIDER_EYE).copy();
                                                                                        _setstack.setCount(1);
                                                                                        ((Slot) _slots.get(5)).set(_setstack);
                                                                                        _player.containerMenu.broadcastChanges();
                                                                                    }
                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                        ItemStack _setstack = new ItemStack(Items.BONE_MEAL).copy();
                                                                                        _setstack.setCount(1);
                                                                                        ((Slot) _slots.get(6)).set(_setstack);
                                                                                        _player.containerMenu.broadcastChanges();
                                                                                    }
                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.SPIDER_EYE) {
                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL) {
                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID_RARE.get()).copy();
                                                                                                _setstack.setCount(1);
                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                _player.containerMenu.broadcastChanges();
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                        _setstack.setCount(1);
                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                        _player.containerMenu.broadcastChanges();
                                                                                    }
                                                                                } else {
                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_MOTHKID_RARE.get()) {
                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                            ItemStack _setstack = new ItemStack(Items.HONEYCOMB).copy();
                                                                                            _setstack.setCount(1);
                                                                                            ((Slot) _slots.get(5)).set(_setstack);
                                                                                            _player.containerMenu.broadcastChanges();
                                                                                        }
                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                            ItemStack _setstack = new ItemStack(Items.BLAZE_POWDER).copy();
                                                                                            _setstack.setCount(1);
                                                                                            ((Slot) _slots.get(6)).set(_setstack);
                                                                                            _player.containerMenu.broadcastChanges();
                                                                                        }
                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                            ItemStack _setstack = new ItemStack(Blocks.PINK_PETALS).copy();
                                                                                            _setstack.setCount(1);
                                                                                            ((Slot) _slots.get(7)).set(_setstack);
                                                                                            _player.containerMenu.broadcastChanges();
                                                                                        }
                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB) {
                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.BLAZE_POWDER) {
                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Blocks.PINK_PETALS.asItem()) {
                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MOTHKID_EPIC.get()).copy();
                                                                                                        _setstack.setCount(1);
                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                            _setstack.setCount(1);
                                                                                            ((Slot) _slots.get(1)).set(_setstack);
                                                                                            _player.containerMenu.broadcastChanges();
                                                                                        }
                                                                                    } else {
                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH.get()) {
                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                ItemStack _setstack = new ItemStack(Items.SLIME_BALL).copy();
                                                                                                _setstack.setCount(1);
                                                                                                ((Slot) _slots.get(5)).set(_setstack);
                                                                                                _player.containerMenu.broadcastChanges();
                                                                                            }
                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI).copy();
                                                                                                _setstack.setCount(1);
                                                                                                ((Slot) _slots.get(6)).set(_setstack);
                                                                                                _player.containerMenu.broadcastChanges();
                                                                                            }
                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.SLIME_BALL) {
                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.LAPIS_LAZULI) {
                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH_RARE.get()).copy();
                                                                                                        _setstack.setCount(1);
                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                _setstack.setCount(1);
                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                _player.containerMenu.broadcastChanges();
                                                                                            }
                                                                                        } else {
                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH_RARE.get()) {
                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                    ItemStack _setstack = new ItemStack(Blocks.OBSIDIAN).copy();
                                                                                                    _setstack.setCount(1);
                                                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                }
                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                    ItemStack _setstack = new ItemStack(Items.AMETHYST_SHARD).copy();
                                                                                                    _setstack.setCount(1);
                                                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                }
                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                    ItemStack _setstack = new ItemStack(Items.DRAGON_BREATH).copy();
                                                                                                    _setstack.setCount(1);
                                                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                }
                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()) {
                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.AMETHYST_SHARD) {
                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.DRAGON_BREATH) {
                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_GILLMUNCH_EPIC.get()).copy();
                                                                                                                _setstack.setCount(1);
                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                            }
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                    _setstack.setCount(1);
                                                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                }
                                                                                            } else {
                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_STALK.get()) {
                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                        ItemStack _setstack = new ItemStack(Items.CHICKEN).copy();
                                                                                                        _setstack.setCount(1);
                                                                                                        ((Slot) _slots.get(5)).set(_setstack);
                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                    }
                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                        ItemStack _setstack = new ItemStack(Blocks.PACKED_ICE).copy();
                                                                                                        _setstack.setCount(1);
                                                                                                        ((Slot) _slots.get(6)).set(_setstack);
                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                    }
                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.CHICKEN) {
                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.PACKED_ICE.asItem()) {
                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK_RARE.get()).copy();
                                                                                                                _setstack.setCount(1);
                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                            }
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                        _setstack.setCount(1);
                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                    }
                                                                                                } else {
                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_STALK_RARE.get()) {
                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                            ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI).copy();
                                                                                                            _setstack.setCount(1);
                                                                                                            ((Slot) _slots.get(5)).set(_setstack);
                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                        }
                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                            ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                                                                                            _setstack.setCount(1);
                                                                                                            ((Slot) _slots.get(6)).set(_setstack);
                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                        }
                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                            ItemStack _setstack = new ItemStack(Blocks.NETHER_WART).copy();
                                                                                                            _setstack.setCount(1);
                                                                                                            ((Slot) _slots.get(7)).set(_setstack);
                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                        }
                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.LAPIS_LAZULI) {
                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND) {
                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Blocks.NETHER_WART.asItem()) {
                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_STALK_EPIC.get()).copy();
                                                                                                                        _setstack.setCount(1);
                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                    }
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                            _setstack.setCount(1);
                                                                                                            ((Slot) _slots.get(1)).set(_setstack);
                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                        }
                                                                                                    } else {
                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_DOMINIC.get()) {
                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                ItemStack _setstack = new ItemStack(Items.ROTTEN_FLESH).copy();
                                                                                                                _setstack.setCount(1);
                                                                                                                ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                            }
                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI).copy();
                                                                                                                _setstack.setCount(1);
                                                                                                                ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                            }
                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.ROTTEN_FLESH) {
                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.LAPIS_LAZULI) {
                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC_RARE.get()).copy();
                                                                                                                        _setstack.setCount(1);
                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                    }
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                _setstack.setCount(1);
                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                            }
                                                                                                        } else {
                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_DOMINIC_RARE.get()) {
                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                    ItemStack _setstack = new ItemStack(MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN.get()).copy();
                                                                                                                    _setstack.setCount(1);
                                                                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                }
                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                    ItemStack _setstack = new ItemStack(Items.FERMENTED_SPIDER_EYE).copy();
                                                                                                                    _setstack.setCount(1);
                                                                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                }
                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                    ItemStack _setstack = new ItemStack(Items.IRON_INGOT).copy();
                                                                                                                    _setstack.setCount(1);
                                                                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                }
                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN.get().asItem()) {
                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.FERMENTED_SPIDER_EYE) {
                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_DOMINIC_EPIC.get()).copy();
                                                                                                                                _setstack.setCount(1);
                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                    _setstack.setCount(1);
                                                                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                }
                                                                                                            } else {
                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_OLMER.get()) {
                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                        ItemStack _setstack = new ItemStack(Blocks.SCULK).copy();
                                                                                                                        _setstack.setCount(1);
                                                                                                                        ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                    }
                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                        ItemStack _setstack = new ItemStack(Items.ECHO_SHARD).copy();
                                                                                                                        _setstack.setCount(1);
                                                                                                                        ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                    }
                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.SCULK.asItem()) {
                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.ECHO_SHARD) {
                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER_RARE.get()).copy();
                                                                                                                                _setstack.setCount(1);
                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                        _setstack.setCount(1);
                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_OLMER_RARE.get()) {
                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                            ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                                                                                                            _setstack.setCount(1);
                                                                                                                            ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                        }
                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                            ItemStack _setstack = new ItemStack(Items.GOLDEN_CARROT).copy();
                                                                                                                            _setstack.setCount(1);
                                                                                                                            ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                        }
                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                            ItemStack _setstack = new ItemStack(Items.GHAST_TEAR).copy();
                                                                                                                            _setstack.setCount(1);
                                                                                                                            ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                        }
                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND) {
                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_CARROT) {
                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.GHAST_TEAR) {
                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_OLMER_EPIC.get()).copy();
                                                                                                                                        _setstack.setCount(1);
                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                            _setstack.setCount(1);
                                                                                                                            ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_FLARG.get()) {
                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                ItemStack _setstack = new ItemStack(Blocks.BONE_BLOCK).copy();
                                                                                                                                _setstack.setCount(1);
                                                                                                                                ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                            }
                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                ItemStack _setstack = new ItemStack(Blocks.SOUL_SAND).copy();
                                                                                                                                _setstack.setCount(1);
                                                                                                                                ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                            }
                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.BONE_BLOCK.asItem()) {
                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.SOUL_SAND.asItem()) {
                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG_RARE.get()).copy();
                                                                                                                                        _setstack.setCount(1);
                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                _setstack.setCount(1);
                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_FLARG_RARE.get()) {
                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.BLACK_CANDLE).copy();
                                                                                                                                    _setstack.setCount(1);
                                                                                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                }
                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.NETHER_WART).copy();
                                                                                                                                    _setstack.setCount(1);
                                                                                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                }
                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.SHRIEKBAT_WING.get()).copy();
                                                                                                                                    _setstack.setCount(1);
                                                                                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                }
                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.BLACK_CANDLE.asItem()) {
                                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.NETHER_WART.asItem()) {
                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.SHRIEKBAT_WING.get()) {
                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FLARG_EPIC.get()).copy();
                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                    _setstack.setCount(1);
                                                                                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED.get()) {
                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                        ItemStack _setstack = new ItemStack(Blocks.PUMPKIN).copy();
                                                                                                                                        _setstack.setCount(1);
                                                                                                                                        ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                    }
                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                        ItemStack _setstack = new ItemStack(Items.PUMPKIN_PIE).copy();
                                                                                                                                        _setstack.setCount(1);
                                                                                                                                        ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                    }
                                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.PUMPKIN.asItem()) {
                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.PUMPKIN_PIE) {
                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED_RARE.get()).copy();
                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                        _setstack.setCount(1);
                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED_RARE.get()) {
                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                            ItemStack _setstack = new ItemStack(Items.SPIDER_EYE).copy();
                                                                                                                                            _setstack.setCount(1);
                                                                                                                                            ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                        }
                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.LOST_NERVE.get()).copy();
                                                                                                                                            _setstack.setCount(1);
                                                                                                                                            ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                        }
                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                            ItemStack _setstack = new ItemStack(Items.SLIME_BALL).copy();
                                                                                                                                            _setstack.setCount(1);
                                                                                                                                            ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                        }
                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.SPIDER_EYE) {
                                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.LOST_NERVE.get()) {
                                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.SLIME_BALL) {
                                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_PIRANHEED_EPIC.get()).copy();
                                                                                                                                                        _setstack.setCount(1);
                                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                            _setstack.setCount(1);
                                                                                                                                            ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE.get()) {
                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                ItemStack _setstack = new ItemStack(Items.BLUE_DYE).copy();
                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                            }
                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                ItemStack _setstack = new ItemStack(Items.GLOWSTONE_DUST).copy();
                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                            }
                                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.BLUE_DYE) {
                                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.GLOWSTONE_DUST) {
                                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE_RARE.get()).copy();
                                                                                                                                                        _setstack.setCount(1);
                                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE_RARE.get()) {
                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.JUNGLE_SAPLING).copy();
                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                }
                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.MANGROVE_PROPAGULE).copy();
                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                }
                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.DEAD_BUSH).copy();
                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                }
                                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.JUNGLE_SAPLING.asItem()) {
                                                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.MANGROVE_PROPAGULE.asItem()) {
                                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Blocks.DEAD_BUSH.asItem()) {
                                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_MANGOTRICE_EPIC.get()).copy();
                                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                                            }
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_FRESNOID.get()) {
                                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                        ItemStack _setstack = new ItemStack(Blocks.MELON).copy();
                                                                                                                                                        _setstack.setCount(1);
                                                                                                                                                        ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                                    }
                                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                        ItemStack _setstack = new ItemStack(Items.SWEET_BERRIES).copy();
                                                                                                                                                        _setstack.setCount(1);
                                                                                                                                                        ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                                    }
                                                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.MELON.asItem()) {
                                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.SWEET_BERRIES) {
                                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID_RARE.get()).copy();
                                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                                            }
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                        _setstack.setCount(1);
                                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_FRESNOID_RARE.get()) {
                                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                            ItemStack _setstack = new ItemStack(Items.AMETHYST_SHARD).copy();
                                                                                                                                                            _setstack.setCount(1);
                                                                                                                                                            ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                                        }
                                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                            ItemStack _setstack = new ItemStack(Blocks.SKELETON_SKULL).copy();
                                                                                                                                                            _setstack.setCount(1);
                                                                                                                                                            ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                                        }
                                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                            ItemStack _setstack = new ItemStack(Items.BLACK_DYE).copy();
                                                                                                                                                            _setstack.setCount(1);
                                                                                                                                                            ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                                        }
                                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.AMETHYST_SHARD) {
                                                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.SKELETON_SKULL.asItem()) {
                                                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.BLACK_DYE) {
                                                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_FRESNOID_EPIC.get()).copy();
                                                                                                                                                                        _setstack.setCount(1);
                                                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                                                    }
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                            _setstack.setCount(1);
                                                                                                                                                            ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                            _player.containerMenu.broadcastChanges();
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_COBBLE.get()) {
                                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                ItemStack _setstack = new ItemStack(Blocks.DEEPSLATE).copy();
                                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                                ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                                            }
                                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                                ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                                            }
                                                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.DEEPSLATE.asItem()) {
                                                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND) {
                                                                                                                                                                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_COBBLE_RARE.get()).copy();
                                                                                                                                                                        _setstack.setCount(1);
                                                                                                                                                                        ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                        _player.containerMenu.broadcastChanges();
                                                                                                                                                                    }
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CRITTERLING_SACK_COBBLE_RARE.get()) {
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Items.CAKE).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Items.SWEET_BERRIES).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Items.SUGAR).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                                if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Items.CAKE) {
                                                                                                                                                                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.SWEET_BERRIES) {
                                                                                                                                                                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
                                                                                                                                                                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                                ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK_COBBLE_EPIC.get()).copy();
                                                                                                                                                                                _setstack.setCount(1);
                                                                                                                                                                                ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                                _player.containerMenu.broadcastChanges();
                                                                                                                                                                            }
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(5)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(6)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(7)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                                                                                                                                                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                                                                                                                                                                    _setstack.setCount(1);
                                                                                                                                                                    ((Slot) _slots.get(1)).set(_setstack);
                                                                                                                                                                    _player.containerMenu.broadcastChanges();
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                    _setstack.setCount(1);
                    ((Slot) _slots.get(5)).set(_setstack);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                    _setstack.setCount(1);
                    ((Slot) _slots.get(6)).set(_setstack);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                    _setstack.setCount(1);
                    ((Slot) _slots.get(7)).set(_setstack);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                    _setstack.setCount(1);
                    ((Slot) _slots.get(1)).set(_setstack);
                    _player.containerMenu.broadcastChanges();
                }
            }
        });
    }
}
