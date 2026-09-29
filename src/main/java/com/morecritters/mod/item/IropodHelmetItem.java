package com.morecritters.mod.item;

import net.minecraft.resources.ResourceLocation;
import com.morecritters.mod.init.MoreCrittersModArmorMaterials;
import net.minecraft.world.item.Item;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import com.morecritters.mod.client.model.Modeliropod_helmet;
import com.morecritters.mod.procedures.IropodHelmetHelmetTickEventProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public abstract class IropodHelmetItem extends ArmorItem {
    public IropodHelmetItem(Type type, Properties properties) {
        super(MoreCrittersModArmorMaterials.IROPOD_HELMET, type, properties.durability(type.getDurability(15)));
    }

    public static class Helmet extends IropodHelmetItem {
        public Helmet() {
            super(Type.HELMET, new Properties());
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(
                new IClientItemExtensions() {
                    @Override
                    public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                        HumanoidModel armorModel = new HumanoidModel(
                            new ModelPart(
                                Collections.emptyList(),
                                Map.of(
                                    "head",
                                    (new Modeliropod_helmet(Minecraft.getInstance().getEntityModels().bakeLayer(Modeliropod_helmet.LAYER_LOCATION))).head,
                                    "hat",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "body",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "right_arm",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_arm",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "right_leg",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_leg",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap())
                                )
                            )
                        );
                        armorModel.crouching = living.isShiftKeyDown();
                        armorModel.riding = defaultModel.riding;
                        armorModel.young = living.isBaby();
                        return armorModel;
                    }
                }
            );
        }

        @Override
        public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, context, list, flag);
            list.add(Component.translatable("item.more_critters.iropod_helmet_helmet.description_0"));
        }

        @Override
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return ResourceLocation.parse("more_critters:textures/models/armor/iropod_helmet_layer_1.png");
        }

        @Override
        public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
            super.inventoryTick(itemstack, world, entity, slot, selected);
            if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
                IropodHelmetHelmetTickEventProcedure.execute(entity);
            }
        }
    }
}
