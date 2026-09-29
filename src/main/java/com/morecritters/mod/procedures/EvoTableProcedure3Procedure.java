package com.morecritters.mod.procedures;

import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class EvoTableProcedure3Procedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                    ? ((Slot)_slt.get(0)).getItem()
                    : ItemStack.EMPTY)
                .is(ItemTags.create(ResourceLocation.parse("minecraft:sack_common")));
    }
}
