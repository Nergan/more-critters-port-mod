package com.morecritters.mod.item;

import java.util.List;
import com.morecritters.mod.procedures.CritterlingSackCubefrogItemInInventoryTickProcedure;
import com.morecritters.mod.procedures.MangotriceDropProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CritterlingSackMangotriceEpicItem extends Item {
    public CritterlingSackMangotriceEpicItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.critterling_sack_mangotrice_epic.description_0"));
        list.add(Component.translatable("item.more_critters.critterling_sack_mangotrice_epic.description_1"));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        MangotriceDropProcedure.execute(
            context.getLevel(),
            context.getClickedPos().getX(),
            context.getClickedPos().getY(),
            context.getClickedPos().getZ(),
            context.getClickedFace(),
            context.getPlayer()
        );
        return InteractionResult.SUCCESS;
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        CritterlingSackCubefrogItemInInventoryTickProcedure.execute(entity);
    }
}
