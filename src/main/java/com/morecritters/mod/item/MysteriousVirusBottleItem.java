package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class MysteriousVirusBottleItem extends Item {
    public MysteriousVirusBottleItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }
}
