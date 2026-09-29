package com.morecritters.mod.init;

import com.morecritters.mod.MoreCritters;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Armor materials are registry entries since 1.20.5; durability moved to the item properties. */
public final class MoreCrittersModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> REGISTRY = DeferredRegister.create(Registries.ARMOR_MATERIAL, MoreCritters.MODID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> IROPOD_HELMET = register(
        "iropod_helmet", new int[]{2, 5, 6, 3}, 9, empty(), () -> Ingredient.of(new ItemStack(MoreCrittersModItems.MOLDED_SHELL.get())), 0.5F, 0.0F
    );
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> NAUTICAL_HELMET = register(
        "nautical_helmet", new int[]{2, 5, 6, 3}, 9, empty(), () -> Ingredient.of(new ItemStack(MoreCrittersModItems.SHELL_PIECES.get())), 0.5F, 0.0F
    );
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PARTY_HAT = register(
        "party_hat", new int[]{2, 5, 6, 2}, 9, empty(), () -> Ingredient.EMPTY, 0.0F, 0.0F
    );
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PIRATE = register(
        "pirate", new int[]{2, 2, 2, 2}, 9, empty(), () -> Ingredient.of(new ItemStack(MoreCrittersModItems.TATTERED_CLOTH.get())), 0.5F, 0.0F
    );
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> STURDY = register(
        "sturdy", new int[]{2, 5, 9, 2}, 9, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(new ItemStack(MoreCrittersModItems.STURDY_SHELLS.get())), 2.5F, 0.1F
    );

    private MoreCrittersModArmorMaterials() {
    }

    private static Holder<SoundEvent> empty() {
        return BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY);
    }

    /** {@code defense} is ordered like 1.20.1's {@code EquipmentSlot#getIndex()}: boots, leggings, chestplate, helmet. */
    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
        String name, int[] defense, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> repair, float toughness, float knockbackResistance
    ) {
        return REGISTRY.register(name, () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, defense[0]);
            map.put(ArmorItem.Type.LEGGINGS, defense[1]);
            map.put(ArmorItem.Type.CHESTPLATE, defense[2]);
            map.put(ArmorItem.Type.HELMET, defense[3]);
        }), enchantability, equipSound, repair, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, name))), toughness, knockbackResistance));
    }
}
