package com.morecritters.mod.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class BunbugCrustIcedChocolateSprinkledBounceberriesItem extends Item {
    public BunbugCrustIcedChocolateSprinkledBounceberriesItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON).food(new Builder().nutrition(6).saturationModifier(0.3F).build()));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.bunbug_crust_iced_chocolate_sprinkled_bounceberries.description_0"));
        list.add(Component.translatable("item.more_critters.bunbug_crust_iced_chocolate_sprinkled_bounceberries.description_1"));
        list.add(Component.translatable("item.more_critters.bunbug_crust_iced_chocolate_sprinkled_bounceberries.description_2"));
        list.add(Component.translatable("item.more_critters.bunbug_crust_iced_chocolate_sprinkled_bounceberries.description_3"));
    }
}
