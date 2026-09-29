package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.NauticrawlEntity;
import com.morecritters.mod.entity.ZombieNauticrawlEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class SwimmerEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity) {
                _entity.removeEffect(MoreCrittersModMobEffects.SWIMMER);
            }

            if ((entity instanceof NauticrawlEntity || entity instanceof ZombieNauticrawlEntity)
                && world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getBlock() != Blocks.AIR) {
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    if (entity instanceof NauticrawlEntity) {
                        ((NauticrawlEntity)entity).setAnimation("swim_start_mad");
                    }

                    if (entity instanceof ZombieNauticrawlEntity) {
                        ((ZombieNauticrawlEntity)entity).setAnimation("swim_start_mad");
                    }

                    MoreCritters.queueServerWork(7, () -> {
                        entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 1.0, entity.getLookAngle().y * 1.0, entity.getLookAngle().z * 1.0));
                        if (entity instanceof NauticrawlEntity) {
                            ((NauticrawlEntity)entity).setAnimation("swim_mad");
                        }

                        if (entity instanceof ZombieNauticrawlEntity) {
                            ((ZombieNauticrawlEntity)entity).setAnimation("swim_mad");
                        }
                    });
                } else {
                    if (entity instanceof NauticrawlEntity) {
                        ((NauticrawlEntity)entity).setAnimation("swim_start");
                    }

                    if (entity instanceof ZombieNauticrawlEntity) {
                        ((ZombieNauticrawlEntity)entity).setAnimation("swim_start");
                    }

                    entity.setDeltaMovement(new Vec3(0.0, -0.3, 0.0));
                    MoreCritters.queueServerWork(7, () -> {
                        if (entity instanceof NauticrawlEntity) {
                            ((NauticrawlEntity)entity).setAnimation("swim");
                        }

                        if (entity instanceof ZombieNauticrawlEntity) {
                            ((ZombieNauticrawlEntity)entity).setAnimation("swim");
                        }

                        entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.6, 0.5, entity.getLookAngle().z * 0.6));
                    });
                }
            }
        }
    }
}
