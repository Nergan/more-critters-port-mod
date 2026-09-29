package com.morecritters.mod.init;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.morecritters.mod.MoreCritters;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MoreCrittersModLootModifier {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(
        NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MoreCritters.MODID
    );
    public static final Supplier<MapCodec<MoreCrittersModLootTableModifier>> LOOT_MODIFIER = LOOT_MODIFIERS.register(
        "more_critters_loot_modifier", MoreCrittersModLootTableModifier.CODEC
    );

    public static class MoreCrittersModLootTableModifier extends LootModifier {
        public static final Supplier<MapCodec<MoreCrittersModLootTableModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.mapCodec(
                instance -> codecStart(instance)
                    .and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter(m -> m.lootTable))
                    .apply(instance, MoreCrittersModLootTableModifier::new)
            )
        );
        private final ResourceLocation lootTable;

        public MoreCrittersModLootTableModifier(LootItemCondition[] conditions, ResourceLocation lootTable) {
            super(conditions);
            this.lootTable = lootTable;
        }

        @Override
        protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            context.getResolver()
                .get(Registries.LOOT_TABLE, ResourceKey.create(Registries.LOOT_TABLE, this.lootTable))
                .ifPresent(extraTable -> extraTable.value().getRandomItemsRaw(context, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add)));
            return generatedLoot;
        }

        @Override
        public MapCodec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }
}
