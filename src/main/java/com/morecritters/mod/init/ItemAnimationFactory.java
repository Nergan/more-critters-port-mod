package com.morecritters.mod.init;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.core.component.DataComponents;
import com.morecritters.mod.item.TaserItem;
import com.morecritters.mod.item.TazegunItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
    @SubscribeEvent
    public static void animatedItems(PlayerTickEvent.Pre event) {
        String animation = "";
        ItemStack mainhandItem = event.getEntity().getMainHandItem().copy();
        ItemStack offhandItem = event.getEntity().getOffhandItem().copy();
        if ((mainhandItem.getItem() instanceof GeoItem || offhandItem.getItem() instanceof GeoItem)) {
            if (mainhandItem.getItem() instanceof TaserItem animatable) {
                animation = mainhandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    CustomData.update(DataComponents.CUSTOM_DATA, event.getEntity().getMainHandItem(), tag -> tag.putString("geckoAnim", ""));
                    if (event.getEntity().level().isClientSide()) {
                        ((TaserItem)event.getEntity().getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }

            if (offhandItem.getItem() instanceof TaserItem animatable) {
                animation = offhandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    CustomData.update(DataComponents.CUSTOM_DATA, event.getEntity().getOffhandItem(), tag -> tag.putString("geckoAnim", ""));
                    if (event.getEntity().level().isClientSide()) {
                        ((TaserItem)event.getEntity().getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }

            if (mainhandItem.getItem() instanceof TazegunItem animatable) {
                animation = mainhandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    CustomData.update(DataComponents.CUSTOM_DATA, event.getEntity().getMainHandItem(), tag -> tag.putString("geckoAnim", ""));
                    if (event.getEntity().level().isClientSide()) {
                        ((TazegunItem)event.getEntity().getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }

            if (offhandItem.getItem() instanceof TazegunItem animatable) {
                animation = offhandItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    CustomData.update(DataComponents.CUSTOM_DATA, event.getEntity().getOffhandItem(), tag -> tag.putString("geckoAnim", ""));
                    if (event.getEntity().level().isClientSide()) {
                        ((TazegunItem)event.getEntity().getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
        }
    }
}
