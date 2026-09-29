package com.morecritters.mod.item;

import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CupcakeItem extends Item {
    public CupcakeItem() {
        super(new Properties().stacksTo(16).rarity(Rarity.COMMON).food(new Builder().nutrition(6).saturationModifier(0.6F).build()));
    }
}
