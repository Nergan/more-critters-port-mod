package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class EvoliteItem extends Item {
    public EvoliteItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.EPIC));
    }
}
