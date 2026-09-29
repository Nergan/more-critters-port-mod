package com.morecritters.mod.item;

import java.util.List;
import com.morecritters.mod.procedures.CorpseLookoutDollRightClickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CorpseLookoutSpawnDollItem extends Item {
    public CorpseLookoutSpawnDollItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.corpse_lookout_spawn_doll.description_0"));
        list.add(Component.translatable("item.more_critters.corpse_lookout_spawn_doll.description_1"));
        list.add(Component.translatable("item.more_critters.corpse_lookout_spawn_doll.description_2"));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        CorpseLookoutDollRightClickProcedure.execute(
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
