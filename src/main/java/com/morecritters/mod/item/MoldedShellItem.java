package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class MoldedShellItem extends Item {
    public MoldedShellItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
