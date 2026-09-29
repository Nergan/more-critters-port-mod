package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class PurgatorialMixtureItem extends Item {
    public PurgatorialMixtureItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
