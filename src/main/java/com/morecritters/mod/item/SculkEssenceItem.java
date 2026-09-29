package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class SculkEssenceItem extends Item {
    public SculkEssenceItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }
}
