package com.morecritters.mod.item;

import com.morecritters.mod.procedures.ShimmerwormItemPlayerFinishesUsingItemProcedure;
import com.morecritters.mod.procedures.ShimmerwormItemRightclickedOnBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ShimmerwormItemItem extends Item {
    public ShimmerwormItemItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON).food(new Builder().nutrition(4).saturationModifier(0.1F).build()));
    }

    @Override
    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 20;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        ShimmerwormItemPlayerFinishesUsingItemProcedure.execute(entity);
        return retval;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        ShimmerwormItemRightclickedOnBlockProcedure.execute(
            context.getLevel(),
            context.getClickedPos().getX(),
            context.getClickedPos().getY(),
            context.getClickedPos().getZ(),
            context.getClickedFace(),
            context.getItemInHand()
        );
        return InteractionResult.SUCCESS;
    }
}
