package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CaptainsHeartItem extends Item {
    public CaptainsHeartItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }
}
