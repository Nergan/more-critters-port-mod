package com.morecritters.mod.item;

import com.morecritters.mod.init.MoreCrittersModArmorMaterials;
import net.minecraft.world.item.Item;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import com.morecritters.mod.client.model.Modelarmor_layer_1;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public abstract class SturdyItem extends ArmorItem {
    public SturdyItem(Type type, Properties properties) {
        super(MoreCrittersModArmorMaterials.STURDY, type, properties.durability(type.getDurability(27)));
    }

    public static class Chestplate extends SturdyItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Properties().fireResistant());
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(
                new IClientItemExtensions() {
                    @OnlyIn(Dist.CLIENT)
                    @Override
                    public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                        HumanoidModel armorModel = new HumanoidModel(
                            new ModelPart(
                                Collections.emptyList(),
                                Map.of(
                                    "body",
                                    (new Modelarmor_layer_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelarmor_layer_1.LAYER_LOCATION))).body,
                                    "left_arm",
                                    (new Modelarmor_layer_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelarmor_layer_1.LAYER_LOCATION))).left_arm,
                                    "right_arm",
                                    (new Modelarmor_layer_1(Minecraft.getInstance().getEntityModels().bakeLayer(Modelarmor_layer_1.LAYER_LOCATION))).right_arm,
                                    "head",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "hat",
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
            list.add(Component.translatable("item.more_critters.sturdy_chestplate.description_0"));
        }

        @Override
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return ResourceLocation.parse("more_critters:textures/models/armor/sturdy_chestplate_layer_1.png");
        }
    }
}
