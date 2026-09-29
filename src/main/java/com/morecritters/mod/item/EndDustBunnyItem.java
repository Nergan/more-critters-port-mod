package com.morecritters.mod.item;

import com.morecritters.mod.procedures.EndDustBunnyPlayerFinishesUsingItemProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class EndDustBunnyItem extends Item {
    public EndDustBunnyItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.EPIC).food(new Builder().nutrition(2).saturationModifier(0.3F).alwaysEdible().build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        EndDustBunnyPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
        return retval;
    }
}
