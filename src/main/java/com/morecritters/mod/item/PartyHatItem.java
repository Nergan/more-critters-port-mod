package com.morecritters.mod.item;

import net.minecraft.resources.ResourceLocation;
import com.morecritters.mod.init.MoreCrittersModArmorMaterials;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import com.morecritters.mod.client.model.Modelparty_hat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public abstract class PartyHatItem extends ArmorItem {
    public PartyHatItem(Type type, Properties properties) {
        super(MoreCrittersModArmorMaterials.PARTY_HAT, type, properties.durability(type.getDurability(15)));
    }

    public static class Helmet extends PartyHatItem {
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
                                    (new Modelparty_hat(Minecraft.getInstance().getEntityModels().bakeLayer(Modelparty_hat.LAYER_LOCATION))).bone,
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
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return ResourceLocation.parse("more_critters:textures/entities/party_hat.png");
        }
    }
}
