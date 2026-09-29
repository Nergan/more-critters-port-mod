package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class HelmetBlurDisplayOverlayIngameProcedure {
    public static boolean execute(Entity entity) {
        return entity == null
            ? false
            : (
                    (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                            == MoreCrittersModItems.IROPOD_HELMET_HELMET.get()
                        || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                            == MoreCrittersModItems.NAUTICAL_HELMET_HELMET.get()
                )
                && entity.isShiftKeyDown();
    }
}
