package com.morecritters.mod.item;

import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class BirchSnowCone2Item extends Item {
    public BirchSnowCone2Item() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON).food(new Builder().nutrition(6).saturationModifier(0.3F).build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = new ItemStack(MoreCrittersModItems.BIRCH_SNOW_CONE_3.get());
        super.finishUsingItem(itemstack, world, entity);
        if (itemstack.isEmpty()) {
            return retval;
        }

        if (entity instanceof Player player && !player.getAbilities().instabuild && !player.getInventory().add(retval)) {
            player.drop(retval, false);
        }

        return itemstack;
    }
}
