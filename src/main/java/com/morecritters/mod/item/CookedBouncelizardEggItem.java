package com.morecritters.mod.item;

import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CookedBouncelizardEggItem extends Item {
    public CookedBouncelizardEggItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON).food(new Builder().nutrition(4).saturationModifier(0.8F).build()));
    }
}
