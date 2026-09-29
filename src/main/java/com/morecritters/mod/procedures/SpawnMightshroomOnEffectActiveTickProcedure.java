package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SpawnMightshroomOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((
                        entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MoreCrittersModMobEffects.SPAWN_MIGHTSHROOM)
                            ? _livEnt.getEffect(MoreCrittersModMobEffects.SPAWN_MIGHTSHROOM).getDuration()
                            : 0
                    )
                    == 20
                && entity instanceof AncientSkeletonEntity) {
                ((AncientSkeletonEntity)entity).setAnimation("fossil_alive");
            }

            if (entity instanceof AncientSkeletonEntity) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:black_stripe ~ ~1 ~ 1 1 1 0 6 force"
                        );
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:yellow_stripe ~ ~1 ~ 1 1 1 0 6 force"
                        );
                }
            }
        }
    }
}
