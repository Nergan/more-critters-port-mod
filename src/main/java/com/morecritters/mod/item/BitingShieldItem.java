package com.morecritters.mod.item;

import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;

public class BitingShieldItem extends ShieldItem {
    public BitingShieldItem() {
        super(new Properties().durability(764).fireResistant());
    }

    @Override
    public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
        return Ingredient.of(new ItemStack(MoreCrittersModItems.STURDY_SHELLS.get())).test(repairitem);
    }
}
