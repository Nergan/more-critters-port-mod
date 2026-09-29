package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class SpinalFluidBottleItem extends Item {
    public SpinalFluidBottleItem() {
        super(new Properties().stacksTo(16).rarity(Rarity.COMMON));
    }
}
