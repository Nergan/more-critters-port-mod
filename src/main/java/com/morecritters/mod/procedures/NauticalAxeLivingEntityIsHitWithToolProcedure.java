package com.morecritters.mod.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class NauticalAxeLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            if (entity.isInWaterRainOrBubble()) {
                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 15.0F);
            }
        }
    }
}
