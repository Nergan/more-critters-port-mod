package com.morecritters.mod.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import java.util.List;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.procedures.FungalStaffLivingEntityIsHitWithToolProcedure;
import com.morecritters.mod.procedures.FungalStaffRightclickedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class FungalStaffItem extends SwordItem {
    private static final Tier TOOL_TIER = new Tier() {
        @Override
        public int getUses() {
            return 500;
        }

        @Override
        public float getSpeed() {
            return 1.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return -1.0F;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 3;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack(MoreCrittersModItems.ANCIENT_BONE.get()));
        }
    };

    public FungalStaffItem() {
        super(TOOL_TIER, new Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 3, -3.0F)));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        FungalStaffLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity, itemstack);
        return retval;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        FungalStaffRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
        return ar;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.fungal_staff.description_0"));
        list.add(Component.translatable("item.more_critters.fungal_staff.description_1"));
        list.add(Component.translatable("item.more_critters.fungal_staff.description_2"));
        list.add(Component.translatable("item.more_critters.fungal_staff.description_3"));
        list.add(Component.translatable("item.more_critters.fungal_staff.description_4"));
        list.add(Component.translatable("item.more_critters.fungal_staff.description_5"));
    }
}
