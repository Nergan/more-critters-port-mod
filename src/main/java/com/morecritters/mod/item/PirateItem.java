package com.morecritters.mod.item;

import net.minecraft.resources.ResourceLocation;
import com.morecritters.mod.init.MoreCrittersModArmorMaterials;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import com.morecritters.mod.client.model.Modelpirate_boots;
import com.morecritters.mod.client.model.Modelpirate_coat;
import com.morecritters.mod.client.model.Modelpirate_pants;
import com.morecritters.mod.client.model.Modeltricorne;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public abstract class PirateItem extends ArmorItem {
    public PirateItem(Type type, Properties properties) {
        super(MoreCrittersModArmorMaterials.PIRATE, type, properties.durability(type.getDurability(15)));
    }

    public static class Boots extends PirateItem {
        public Boots() {
            super(Type.BOOTS, new Properties());
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
                                    "left_leg",
                                    (new Modelpirate_boots(Minecraft.getInstance().getEntityModels().bakeLayer(Modelpirate_boots.LAYER_LOCATION))).l_boots,
                                    "right_leg",
                                    (new Modelpirate_boots(Minecraft.getInstance().getEntityModels().bakeLayer(Modelpirate_boots.LAYER_LOCATION))).r_boots,
                                    "head",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "hat",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "body",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "right_arm",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_arm",
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
            return ResourceLocation.parse("more_critters:textures/entities/pirate_boots.png");
        }
    }

    public static class Chestplate extends PirateItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Properties());
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
                                    (new Modelpirate_coat(Minecraft.getInstance().getEntityModels().bakeLayer(Modelpirate_coat.LAYER_LOCATION))).body,
                                    "left_arm",
                                    (new Modelpirate_coat(Minecraft.getInstance().getEntityModels().bakeLayer(Modelpirate_coat.LAYER_LOCATION))).l_arm,
                                    "right_arm",
                                    (new Modelpirate_coat(Minecraft.getInstance().getEntityModels().bakeLayer(Modelpirate_coat.LAYER_LOCATION))).r_arm,
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
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return ResourceLocation.parse("more_critters:textures/entities/pirate_coat.png");
        }
    }

    public static class Helmet extends PirateItem {
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
                                    (new Modeltricorne(Minecraft.getInstance().getEntityModels().bakeLayer(Modeltricorne.LAYER_LOCATION))).tricorne,
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
            return ResourceLocation.parse("more_critters:textures/entities/tricorne.png");
        }
    }

    public static class Leggings extends PirateItem {
        public Leggings() {
            super(Type.LEGGINGS, new Properties());
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
                                    "left_leg",
                                    (new Modelpirate_pants(Minecraft.getInstance().getEntityModels().bakeLayer(Modelpirate_pants.LAYER_LOCATION))).l_leg,
                                    "right_leg",
                                    (new Modelpirate_pants(Minecraft.getInstance().getEntityModels().bakeLayer(Modelpirate_pants.LAYER_LOCATION))).r_leg,
                                    "head",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "hat",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "body",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "right_arm",
                                    new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                                    "left_arm",
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
            return ResourceLocation.parse("more_critters:textures/entities/pirate_pants.png");
        }
    }
}
