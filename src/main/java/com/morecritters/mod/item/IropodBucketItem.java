package com.morecritters.mod.item;

import net.minecraft.world.item.Item;
import java.util.List;
import com.morecritters.mod.init.MoreCrittersModFluids;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class IropodBucketItem extends BucketItem {
    public IropodBucketItem() {
        super(MoreCrittersModFluids.IROPOD_BUCKET.get(), new Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.iropod_bucket_bucket.description_0"));
    }
}
