package com.morecritters.mod.item;

import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CookedBlubberfishItem extends Item {
    public CookedBlubberfishItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON).food(new Builder().nutrition(8).saturationModifier(0.5F).build()));
    }
}
