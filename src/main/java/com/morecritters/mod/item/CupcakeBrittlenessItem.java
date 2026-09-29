package com.morecritters.mod.item;

import java.util.List;
import com.morecritters.mod.procedures.EdpBrittlenessProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class CupcakeBrittlenessItem extends Item {
    public CupcakeBrittlenessItem() {
        super(new Properties().stacksTo(16).rarity(Rarity.COMMON).food(new Builder().nutrition(4).saturationModifier(0.3F).build()));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.cupcake_brittleness.description_0"));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        EdpBrittlenessProcedure.execute(entity);
        return retval;
    }
}
