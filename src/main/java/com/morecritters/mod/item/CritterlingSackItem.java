package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CritterlingSackItem extends Item {
    public CritterlingSackItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
