package com.morecritters.mod.item;

import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class BirchSnowCone3Item extends Item {
    public BirchSnowCone3Item() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON).food(new Builder().nutrition(2).saturationModifier(0.3F).build()));
    }
}
