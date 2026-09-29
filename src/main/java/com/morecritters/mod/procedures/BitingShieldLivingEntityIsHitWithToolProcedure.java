package com.morecritters.mod.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BitingShieldLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity != null && sourceentity != null) {
            entity.hurt(
                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                (float)Mth.nextDouble(RandomSource.create(), 2.0, 4.0)
            );
            if (sourceentity instanceof Player _player) {
                _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
            }
        }
    }
}
