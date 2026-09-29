package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class PearlItem extends Item {
    public PearlItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
    }
}
