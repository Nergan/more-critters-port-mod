package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class TreasureKeyItem extends Item {
    public TreasureKeyItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
