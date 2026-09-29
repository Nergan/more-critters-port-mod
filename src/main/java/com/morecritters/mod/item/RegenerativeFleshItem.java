package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class RegenerativeFleshItem extends Item {
    public RegenerativeFleshItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
