package com.morecritters.mod.item;

import com.morecritters.mod.procedures.SturdyIroballSpawnProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class SpikedIroballItem extends Item {
    public SpikedIroballItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        SturdyIroballSpawnProcedure.execute(
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
