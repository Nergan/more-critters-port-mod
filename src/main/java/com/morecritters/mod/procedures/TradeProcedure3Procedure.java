package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class TradeProcedure3Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, final Entity entity) {
        if (entity != null) {
            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                        ? ((Slot)_slt.get(2)).getItem()
                        : ItemStack.EMPTY)
                    .getItem()
                == Items.EMERALD) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                    _setstack.setCount(
                        (new Object() {
                                    public int getAmount(int sltid) {
                                        if (entity instanceof Player _playerx
                                            && _playerx.containerMenu instanceof Supplier _current
                                            && _current.get() instanceof Map _slots) {
                                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                                            if (stack != null) {
                                                return stack.getCount();
                                            }
                                        }

                                        return 0;
                                    }
                                })
                                .getAmount(0)
                            * (new Object() {
                                    public int getAmount(int sltid) {
                                        if (entity instanceof Player _player
                                            && _player.containerMenu instanceof Supplier _current
                                            && _current.get() instanceof Map _slots) {
                                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                                            if (stack != null) {
                                                return stack.getCount();
                                            }
                                        }

                                        return 0;
                                    }
                                })
                                .getAmount(2)
                    );
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            } else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                        ? ((Slot)_slt.get(2)).getItem()
                        : ItemStack.EMPTY)
                    .getItem()
                == Items.DIAMOND) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                    _setstack.setCount(
                        (new Object() {
                                    public int getAmount(int sltid) {
                                        if (entity instanceof Player _player
                                            && _player.containerMenu instanceof Supplier _current
                                            && _current.get() instanceof Map _slots) {
                                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                                            if (stack != null) {
                                                return stack.getCount();
                                            }
                                        }

                                        return 0;
                                    }
                                })
                                .getAmount(0)
                            * (new Object() {
                                    public int getAmount(int sltid) {
                                        if (entity instanceof Player _player
                                            && _player.containerMenu instanceof Supplier _current
                                            && _current.get() instanceof Map _slots) {
                                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                                            if (stack != null) {
                                                return stack.getCount();
                                            }
                                        }

                                        return 0;
                                    }
                                })
                                .getAmount(2)
                    );
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            } else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                        ? ((Slot)_slt.get(2)).getItem()
                        : ItemStack.EMPTY)
                    .getItem()
                == Items.IRON_NUGGET) {
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(Items.IRON_NUGGET).copy();
                    _setstack.setCount(
                        (new Object() {
                                    public int getAmount(int sltid) {
                                        if (entity instanceof Player _player
                                            && _player.containerMenu instanceof Supplier _current
                                            && _current.get() instanceof Map _slots) {
                                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                                            if (stack != null) {
                                                return stack.getCount();
                                            }
                                        }

                                        return 0;
                                    }
                                })
                                .getAmount(0)
                            * (new Object() {
                                    public int getAmount(int sltid) {
                                        if (entity instanceof Player _player
                                            && _player.containerMenu instanceof Supplier _current
                                            && _current.get() instanceof Map _slots) {
                                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                                            if (stack != null) {
                                                return stack.getCount();
                                            }
                                        }

                                        return 0;
                                    }
                                })
                                .getAmount(2)
                    );
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            } else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(2)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                    == Items.GOLD_INGOT
                && entity instanceof Player _player) {
                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                _setstack.setCount((new Object() {
                    public int getAmount(int sltid) {
                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                            if (stack != null) {
                                return stack.getCount();
                            }
                        }

                        return 0;
                    }
                }).getAmount(0) * (new Object() {
                    public int getAmount(int sltid) {
                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                            if (stack != null) {
                                return stack.getCount();
                            }
                        }

                        return 0;
                    }
                }).getAmount(2));
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(0)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                    != Blocks.AIR.asItem()
                && (
                    (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(2)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == Items.EMERALD
                        || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(2)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == Items.DIAMOND
                        || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(2)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == Items.IRON_NUGGET
                        || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(2)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == Items.GOLD_INGOT
                )) {
                if (entity instanceof ServerPlayer _player) {
                    AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:trade_with_collector"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }

                if (!entity.getPersistentData()
                        .getString("traded1")
                        .equals(
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        )
                    && !entity.getPersistentData()
                        .getString("traded2")
                        .equals(
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        )
                    && !entity.getPersistentData()
                        .getString("traded3")
                        .equals(
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        )
                    && !entity.getPersistentData()
                        .getString("traded4")
                        .equals(
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        )
                    && !entity.getPersistentData()
                        .getString("traded5")
                        .equals(
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        )) {
                    entity.getPersistentData().putDouble("traded", entity.getPersistentData().getDouble("traded") + 1.0);
                }

                if (entity.getPersistentData().getDouble("traded") == 0.0) {
                    entity.getPersistentData()
                        .putString(
                            "traded1",
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        );
                } else if (entity.getPersistentData().getDouble("traded") == 1.0) {
                    entity.getPersistentData()
                        .putString(
                            "traded2",
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        );
                } else if (entity.getPersistentData().getDouble("traded") == 2.0) {
                    entity.getPersistentData()
                        .putString(
                            "traded3",
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        );
                } else if (entity.getPersistentData().getDouble("traded") == 3.0) {
                    entity.getPersistentData()
                        .putString(
                            "traded4",
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        );
                } else if (entity.getPersistentData().getDouble("traded") == 4.0) {
                    entity.getPersistentData()
                        .putString(
                            "traded5",
                            BuiltInRegistries.ITEM
                                .getKey(
                                    (entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                )
                                .toString()
                        );
                }

                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot)_slots.get(0))
                        .remove(
                            (new Object() {
                                    public int getAmount(int sltid) {
                                        if (entity instanceof Player _player
                                            && _player.containerMenu instanceof Supplier _current
                                            && _current.get() instanceof Map _slots) {
                                            ItemStack stack = ((Slot)_slots.get(sltid)).getItem();
                                            if (stack != null) {
                                                return stack.getCount();
                                            }
                                        }

                                        return 0;
                                    }
                                })
                                .getAmount(0)
                        );
                    _player.containerMenu.broadcastChanges();
                }

                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0); index0++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon experience_orb ~ ~ ~ {Value:1}"
                            );
                    }
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.wandering_collector.trade")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.wandering_collector.trade")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (entity.getPersistentData().getDouble("traded") >= 5.0 && entity instanceof ServerPlayer _player) {
                    AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:gain_access_to_carrybug"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }
        }
    }
}
