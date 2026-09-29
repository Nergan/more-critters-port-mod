package com.morecritters.mod.item;

import com.morecritters.mod.init.MoreCrittersModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class RamchuFryBucketItem extends BucketItem {
    public RamchuFryBucketItem() {
        super(MoreCrittersModFluids.RAMCHU_FRY_BUCKET.get(), new Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
    }
}
