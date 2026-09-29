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

public class BlackIropodBucketItem extends BucketItem {
    public BlackIropodBucketItem() {
        super(MoreCrittersModFluids.BLACK_IROPOD_BUCKET.get(), new Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.black_iropod_bucket_bucket.description_0"));
    }
}
