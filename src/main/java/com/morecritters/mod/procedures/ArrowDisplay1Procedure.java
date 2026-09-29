package com.morecritters.mod.procedures;

import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class ArrowDisplay1Procedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(0)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                    != Blocks.AIR.asItem()
                && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(2)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                    != Blocks.AIR.asItem()
                && (
                    (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(5)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            != Blocks.AIR.asItem()
                        || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                                    ? ((Slot)_slt.get(6)).getItem()
                                    : ItemStack.EMPTY)
                                .getItem()
                            != Blocks.AIR.asItem()
                )
                && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(3)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                    == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(5)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(4)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                    == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(6)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(8)).getItem()
                            : ItemStack.EMPTY)
                        .getItem()
                    == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                            ? ((Slot)_slt.get(7)).getItem()
                            : ItemStack.EMPTY)
                        .getItem();
    }
}
