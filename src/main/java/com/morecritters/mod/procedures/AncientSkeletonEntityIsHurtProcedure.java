package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AncientSkeletonEntityIsHurtProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (!((AncientSkeletonEntity)entity).animationprocedure.equals("fossil_shake")
                && !((AncientSkeletonEntity)entity).animationprocedure.equals("fossil_alive")) {
                if (!((AncientSkeletonEntity)entity).animationprocedure.equals("fossil_hurt") && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (entity instanceof AncientSkeletonEntity) {
                    ((AncientSkeletonEntity)entity).setAnimation("fossil_hurt");
                }
            }
        }
    }
}
