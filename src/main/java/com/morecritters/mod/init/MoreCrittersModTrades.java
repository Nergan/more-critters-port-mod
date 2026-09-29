package com.morecritters.mod.init;

import java.util.List;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.GAME)
public class MoreCrittersModTrades {
    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.BUTCHER) {
            ((List)event.getTrades().get(1))
                .add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(MoreCrittersModItems.BUNBUG_EGGS.get(), 2), 10, 5, 0.05F));
        }

        if (event.getType() == VillagerProfession.FISHERMAN) {
            ((List)event.getTrades().get(1))
                .add(new BasicItemListing(new ItemStack(MoreCrittersModItems.PEARL.get()), new ItemStack(Items.EMERALD, 10), 5, 10, 0.05F));
        }
    }
}
