package com.morecritters.mod.item;

import com.morecritters.mod.procedures.BunbugEggsRightClickProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class BunbugEggsItem extends Item {
    public BunbugEggsItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        BunbugEggsRightClickProcedure.execute(
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
