package com.morecritters.mod.init;

import com.morecritters.mod.MoreCritters;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;

/**
 * Enchantments are data-driven since 1.21: definitions live in {@code data/more_critters/enchantment}.
 * Code refers to them by key.
 */
public final class MoreCrittersModEnchantments {
    public static final ResourceKey<Enchantment> SHARP_TEETH = key("sharp_teeth");
    public static final ResourceKey<Enchantment> DEADLY_SIDE = key("deadly_side");
    public static final ResourceKey<Enchantment> LOVELY_SIDE = key("lovely_side");

    private MoreCrittersModEnchantments() {
    }

    private static ResourceKey<Enchantment> key(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, name));
    }

    /** Level of an enchantment on a stack, looked up by key so callers need no registry access. */
    public static int getLevel(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments enchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
            if (entry.getKey().is(enchantment)) {
                return entry.getIntValue();
            }
        }
        return 0;
    }
}
