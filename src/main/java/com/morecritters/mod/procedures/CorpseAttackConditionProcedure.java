package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class CorpseAttackConditionProcedure {
    public static boolean execute(Entity immediatesourceentity) {
        if (immediatesourceentity == null) {
            return false;
        }

        double rate = 0.0;
        return (immediatesourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
                != MoreCrittersModItems.PIRATE_HELMET.get()
            && (immediatesourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()
                != MoreCrittersModItems.PIRATE_CHESTPLATE.get()
            && (immediatesourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()
                != MoreCrittersModItems.PIRATE_LEGGINGS.get()
            && (immediatesourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()
                != MoreCrittersModItems.PIRATE_BOOTS.get();
    }
}
