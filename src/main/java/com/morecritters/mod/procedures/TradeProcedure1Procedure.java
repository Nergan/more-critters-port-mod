package com.morecritters.mod.procedures;

import java.util.Map;
import java.util.function.Supplier;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class TradeProcedure1Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            MoreCritters.queueServerWork(
                1,
                () -> {
                    if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(0)).getItem()
                            : ItemStack.EMPTY)
                        .is(ItemTags.create(ResourceLocation.parse("minecraft:tradeable")))) {
                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BUNBUG_EGGS.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.RAW_BUNBUG_MEAT.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.COOKED_BUNBUG_MEAT.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SACKOF_FREEZING.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.FREEZING_STRING.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.FREEZING_COBWEB.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.WEB_SACK.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SHRIEKBAT_WING.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SHRIEK_BOMB.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SHRIEKBAT_SOUP.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BLOSSOMBUSH_SEED.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.BLOSSOMBUSH.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.CLOSED_BLOSSOMBUSH.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.BOUNCELIZARD_EGG.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BOUNCEBERRY.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.IRON_NUGGET).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.BOUNCEBERRY_BUSH_EMPTY.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BOTTLEO_ELECTRICITY.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.TAZEGUN.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.ELECTRIC_BLOSSOMBUSH.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.CLOSED_ELECTRIC_BLOSSOMBUSH.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.STURDY_SHELLS.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.STURDY_CHESTPLATE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BITING_SHIELD.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SHIMMERWORM_ITEM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.SHIMMERING_CHRYSALIS.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.END_DUST.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.VITA_SHROOM.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.MORI_SHROOM.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.PURGATORIAL_MIXTURE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.DEATH_STEW.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.LIFE_STEW.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.ANCIENT_BONE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.FUNGAL_FLESH.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.REGENERATIVE_FLESH.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.FUNGAL_STAFF.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                    && _plrSlotItem.containerMenu instanceof Supplier _splr
                                    && _splr.get() instanceof Map _slt
                                ? ((Slot)_slt.get(0)).getItem()
                                : ItemStack.EMPTY)
                            .is(ItemTags.create(ResourceLocation.parse("minecraft:fossils")))) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BUNBUG_CAVIAR.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BOUNCEBERRY_JAM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.COOKED_BOUNCELIZARD_EGG.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.BOUNCEBERRY_SANDWICH.get()
                            && entity instanceof Player _player
                            && _player.containerMenu instanceof Supplier _current
                            && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                            _setstack.setCount(5);
                            ((Slot)_slots.get(2)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }

                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.EXPLOSIVE_JELLY.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SMALL_BOMB_JELLY_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.MEDIUM_BOMB_JELLY_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.LARGE_BOMB_JELLY_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.AVOIDER_TAIL.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.AVOIDER_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BOOSTER_PUMP.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.JELLY_TORPEDO_ITEM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.MOLDED_SHELL.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.IROPOD_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BLACK_IROPOD_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.IROPOD_HELMET_HELMET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.RAW_BLUBBERFISH.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.COOKED_BLUBBERFISH.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BLUBBERFISH_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SHELL_PIECES.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.NAUTICAL_HELMET_HELMET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.NAUTICRAWL_SHELL.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(9);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BLUBBERFISH_FRY_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.AVOIDER_FRY_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.NAUTICAL_AXE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.STINARP_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.TOXIN_BLADDER_STAGNATION.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.TOXIN_BLADDER_MUSCLE_ACHE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.TOXIN_BLADDER_BRITTLENESS.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.TOXIN_BLADDER_HALLUCINAZIUM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.TOXIN_BLADDER_ASPHYXIATION.get()
                            && entity instanceof Player _player
                            && _player.containerMenu instanceof Supplier _current
                            && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                            _setstack.setCount(2);
                            ((Slot)_slots.get(2)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }

                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.TOOTH_MELTER.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(10);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.EERIE_BARK.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.EERIE_DART.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BLACK_RESIN_CLUMP.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.BLACK_RESIN_BRICK.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SPINAL_FLUID_BOTTLE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.MYSTERIOUS_VIRUS_BOTTLE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(15);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.LOST_NERVE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.COOKED_NERVE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.NERVAL_SALAD.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.POPPED_NERVAL_MIXTURE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.NERVOID_BRAIN.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.DECOMPOSING_NERVOID_BRAIN.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.TATTERED_JOLLY_ROGER.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.FISH_BONE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.TATTERED_CLOTH.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.CANNON_BALL.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.PEARL.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.INFUSED_CANNON_BALL_COLD.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.INFUSED_CANNON_BALL_FIRE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.INFUSED_CANNON_BALL_SLIME.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                != MoreCrittersModItems.PIRATE_HELMET.get()
                            && (entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                != MoreCrittersModItems.PIRATE_CHESTPLATE.get()
                            && (entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                != MoreCrittersModItems.PIRATE_LEGGINGS.get()
                            && (entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                != MoreCrittersModItems.PIRATE_BOOTS.get()) {
                            if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == ((Block)MoreCrittersModBlocks.RUM_BOTTLE.get()).asItem()) {
                                if (entity instanceof Player _player
                                    && _player.containerMenu instanceof Supplier _current
                                    && _current.get() instanceof Map _slots) {
                                    ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                    _setstack.setCount(2);
                                    ((Slot)_slots.get(2)).set(_setstack);
                                    _player.containerMenu.broadcastChanges();
                                }
                            } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.CUTLASS.get()) {
                                if (entity instanceof Player _player
                                    && _player.containerMenu instanceof Supplier _current
                                    && _current.get() instanceof Map _slots) {
                                    ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                    _setstack.setCount(5);
                                    ((Slot)_slots.get(2)).set(_setstack);
                                    _player.containerMenu.broadcastChanges();
                                }
                            } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.SHARK_TOOTH.get()) {
                                if (entity instanceof Player _player
                                    && _player.containerMenu instanceof Supplier _current
                                    && _current.get() instanceof Map _slots) {
                                    ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                    _setstack.setCount(2);
                                    ((Slot)_slots.get(2)).set(_setstack);
                                    _player.containerMenu.broadcastChanges();
                                }
                            } else if ((entity instanceof Player _plrSlotItem
                                                && _plrSlotItem.containerMenu instanceof Supplier _splr
                                                && _splr.get() instanceof Map _slt
                                            ? ((Slot)_slt.get(0)).getItem()
                                            : ItemStack.EMPTY)
                                        .getItem()
                                    == MoreCrittersModItems.TOOTH_SYRINGE.get()
                                && entity instanceof Player _player
                                && _player.containerMenu instanceof Supplier _current
                                && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if (entity instanceof Player _player
                            && _player.containerMenu instanceof Supplier _current
                            && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                            _setstack.setCount(3);
                            ((Slot)_slots.get(2)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }

                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.CAPTAINS_HEART.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.CORPSE_PARROT_ITEM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.HARDTACK.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.INFESTED_HARDTACK.get()
                            && entity instanceof Player _player
                            && _player.containerMenu instanceof Supplier _current
                            && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                            _setstack.setCount(2);
                            ((Slot)_slots.get(2)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }

                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.CUSTODIAN_CORE.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SCULK_ESSENCE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SLASHKLUB.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.DRIPPER_REMAINS.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.DRIPSTONE_WALL_MASK.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.RAMCHU_BUCKET_NO_OIL_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.RAMCHU_BUCKET_NO_SHELL_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.RAMCHU_BUCKET_BUCKET.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.RAMCHU_FRY_BUCKET_BUCKET.get()
                            && entity instanceof Player _player
                            && _player.containerMenu instanceof Supplier _current
                            && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                            _setstack.setCount(1);
                            ((Slot)_slots.get(2)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }

                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.GRAVE_BRUSH.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.MOSS_CLUMP.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.RAMCHU_OIL_BOTTLE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.OOZE_ROD.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.GLOWING_OOZE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.GRAVEDIGGER_APPENDAGE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.KELPIRE_ROLL_PIECE.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.KELPIRE_ROLLS.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(5);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.CRITTER_KEBAB.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.NAUTICRAWL_RAMEN.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.NAUTICRAWL_TENTACLE.get()
                            && entity instanceof Player _player
                            && _player.containerMenu instanceof Supplier _current
                            && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                            _setstack.setCount(3);
                            ((Slot)_slots.get(2)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }

                        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.INFUSED_CANNON_BALL_ELECTRIC.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.INFUSED_CANNON_BALL_COMBUSTING.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.ECTOMETAL.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.CHATTERING_TEETH_ITEM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
                                _setstack.setCount(3);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.BLUBBER.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == ((Block)MoreCrittersModBlocks.GOOBULB.get()).asItem()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.IROBALL_ITEM.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(1);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                        && _plrSlotItem.containerMenu instanceof Supplier _splr
                                        && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(0)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            == MoreCrittersModItems.SPIKED_IROBALL.get()) {
                            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                                ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                                _setstack.setCount(2);
                                ((Slot)_slots.get(2)).set(_setstack);
                                _player.containerMenu.broadcastChanges();
                            }
                        } else if ((entity instanceof Player _plrSlotItem
                                            && _plrSlotItem.containerMenu instanceof Supplier _splr
                                            && _splr.get() instanceof Map _slt
                                        ? ((Slot)_slt.get(0)).getItem()
                                        : ItemStack.EMPTY)
                                    .getItem()
                                == MoreCrittersModItems.BIRCH_SNOW_CONE.get()
                            && entity instanceof Player _player
                            && _player.containerMenu instanceof Supplier _current
                            && _current.get() instanceof Map _slots) {
                            ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
                            _setstack.setCount(2);
                            ((Slot)_slots.get(2)).set(_setstack);
                            _player.containerMenu.broadcastChanges();
                        }
                    } else if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                        _setstack.setCount(1);
                        ((Slot)_slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            );
        }
    }
}
