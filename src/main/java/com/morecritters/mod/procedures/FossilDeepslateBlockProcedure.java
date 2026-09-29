package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModEnchantments;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;

public class FossilDeepslateBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (MoreCrittersModEnchantments.getLevel(
                        Enchantments.SILK_TOUCH, entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY
                    )
                    != 0
                && world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModBlocks.DEEPSLATE_FOSSIL_BLOCK.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }
    }
}
