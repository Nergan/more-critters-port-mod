package com.morecritters.mod.item;

import com.morecritters.mod.procedures.GraveBrushRightclickedOnBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class GraveBrushItem extends Item {
    public GraveBrushItem() {
        super(new Properties().durability(10).rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        GraveBrushRightclickedOnBlockProcedure.execute(
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
