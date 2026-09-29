package com.morecritters.mod.item;

import com.morecritters.mod.procedures.AncientSkeletonExhibitRightClickedProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class AncientSkeletonExhibitItemItem extends Item {
    public AncientSkeletonExhibitItemItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        AncientSkeletonExhibitRightClickedProcedure.execute(
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
