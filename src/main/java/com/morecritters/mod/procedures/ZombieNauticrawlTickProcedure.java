package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.ZombieNauticrawlEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ZombieNauticrawlTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            entity.getPersistentData().putDouble("spin", entity.getPersistentData().getDouble("spin") - 1.0);
            entity.getPersistentData().putDouble("swim", entity.getPersistentData().getDouble("swim") - 1.0);
            entity.getPersistentData().putDouble("down", entity.getPersistentData().getDouble("down") - 1.0);
            if (entity.isInWaterOrBubble() && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)) {
                entity.push(0.0, -0.001, 0.0);
            }

            if (entity.getPersistentData().getDouble("down") <= -1.0) {
                entity.getPersistentData().putDouble("down", 100.0);
                if (entity.isInWaterOrBubble()
                    && world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR
                    && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)) {
                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.4, -0.3, entity.getLookAngle().z * 0.4));
                }
            }

            if (entity.getPersistentData().getDouble("attack") <= -1.0) {
                entity.getPersistentData().putDouble("attack", Mth.nextInt(RandomSource.create(), 100, 200));
                if (entity.getPersistentData().getDouble("spin") < 0.0
                    && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                    && entity.isInWaterOrBubble()) {
                    entity.getPersistentData().putDouble("spin", Mth.nextInt(RandomSource.create(), 30, 60));
                }
            }

            if (entity.getPersistentData().getDouble("spin") > 0.0) {
                if (entity instanceof ZombieNauticrawlEntity) {
                    ((ZombieNauticrawlEntity)entity).setAnimation("roll_start");
                }

                MoreCritters.queueServerWork(10, () -> {
                    if (entity instanceof ZombieNauticrawlEntity) {
                        ((ZombieNauticrawlEntity)entity).setAnimation("roll");
                    }
                });
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    entity.lookAt(
                        Anchor.EYES,
                        new Vec3(
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getX(),
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getY(),
                            (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null).getZ()
                        )
                    );
                }

                if (entity.isInWaterOrBubble()) {
                    entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.6, entity.getLookAngle().y * 0.6, entity.getLookAngle().z * 0.6));
                }
            } else if (((ZombieNauticrawlEntity)entity).animationprocedure.equals("roll")) {
                if (entity instanceof ZombieNauticrawlEntity) {
                    ((ZombieNauticrawlEntity)entity).setAnimation("roll_end");
                }

                entity.getPersistentData().putDouble("swim", 20.0);
            }

            if (entity.getPersistentData().getDouble("swim") <= -1.0) {
                if (entity.isInWaterOrBubble()
                    && !((ZombieNauticrawlEntity)entity).animationprocedure.equals("roll")
                    && !((ZombieNauticrawlEntity)entity).animationprocedure.equals("roll_start")
                    && entity instanceof LivingEntity _entity
                    && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.SWIMMER, 1, 0, false, false));
                }

                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    entity.getPersistentData().putDouble("swim", 20.0);
                } else {
                    entity.getPersistentData().putDouble("swim", Mth.nextInt(RandomSource.create(), 60, 100));
                }
            }

            if (((ZombieNauticrawlEntity)entity).animationprocedure.equals("roll") && world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:bubble ~ ~ ~ 0.8 0.8 0.8 0.1 5 force"
                    );
            }

            if (entity.isInWaterOrBubble()) {
                if (((ZombieNauticrawlEntity)entity).animationprocedure.equals("land") && entity instanceof ZombieNauticrawlEntity) {
                    ((ZombieNauticrawlEntity)entity).setAnimation("swim");
                }
            } else if (entity instanceof ZombieNauticrawlEntity) {
                ((ZombieNauticrawlEntity)entity).setAnimation("land");
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)
                <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) / 2.0F) {
                if (entity instanceof ZombieNauticrawlEntity _datEntL70 && _datEntL70.getEntityData().get(ZombieNauticrawlEntity.DATA_coral)) {
                    if (entity instanceof ZombieNauticrawlEntity animatable) {
                        animatable.setTexture("nauticrawl_zombie_coral_cracked");
                    }
                } else if (entity instanceof ZombieNauticrawlEntity animatable) {
                    animatable.setTexture("nauticrawl_zombie_cracked");
                }
            } else if (entity instanceof ZombieNauticrawlEntity _datEntL73 && _datEntL73.getEntityData().get(ZombieNauticrawlEntity.DATA_coral)) {
                if (entity instanceof ZombieNauticrawlEntity animatable) {
                    animatable.setTexture("nauticrawl_zombie_coral");
                }
            } else if (entity instanceof ZombieNauticrawlEntity animatable) {
                animatable.setTexture("nauticrawl_zombie");
            }

            if (entity.isInWaterOrBubble()) {
                entity.getPersistentData().putDouble("air", 200.0);
            } else {
                entity.getPersistentData().putDouble("air", entity.getPersistentData().getDouble("air") - 1.0);
            }

            if (entity.getPersistentData().getDouble("air") <= 1.0) {
                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)), 1.0F);
                entity.getPersistentData().putDouble("air", 20.0);
            }
        }
    }
}
