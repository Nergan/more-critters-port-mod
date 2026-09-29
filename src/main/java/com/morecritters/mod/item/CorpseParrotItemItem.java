package com.morecritters.mod.item;

import com.morecritters.mod.procedures.ParrotTamedRightClickSpawnProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class CorpseParrotItemItem extends Item {
    public CorpseParrotItemItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        ParrotTamedRightClickSpawnProcedure.execute(
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
