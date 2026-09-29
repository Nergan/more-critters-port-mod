package com.morecritters.mod.item;

import com.morecritters.mod.procedures.ChatteringTeethItemRCProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class ChatteringTeethItemItem extends Item {
    public ChatteringTeethItemItem() {
        // 1.21 rejects recipe results above the max stack size; the crafting recipe yields 2.
        super(new Properties().stacksTo(2).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        ChatteringTeethItemRCProcedure.execute(
            context.getLevel(),
            context.getClickedPos().getX(),
            context.getClickedPos().getY(),
            context.getClickedPos().getZ(),
            context.getClickedFace(),
            context.getPlayer(),
            context.getItemInHand()
        );
        return InteractionResult.SUCCESS;
    }
}
