package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import java.util.Comparator;
import com.morecritters.mod.entity.BlubberfishEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BlubberfishOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double currenty = 0.0;
            double previousy = 0.0;
            if (!(entity instanceof BlubberfishEntity _datEntL0 && _datEntL0.getEntityData().get(BlubberfishEntity.DATA_explode))) {
                if (entity.isInWaterOrBubble()) {
                    if (entity instanceof BlubberfishEntity animatable) {
                        animatable.setTexture("blubberfish");
                    }

                    if (((BlubberfishEntity)entity).animationprocedure.equals("fall") && entity instanceof BlubberfishEntity) {
                        ((BlubberfishEntity)entity).setAnimation("landing");
                    }
                } else {
                    if (entity instanceof BlubberfishEntity animatable) {
                        animatable.setTexture("blubberfish_land");
                    }

                    if (entity.onGround()) {
                        if (((BlubberfishEntity)entity).animationprocedure.equals("fall")) {
                            if (entity instanceof BlubberfishEntity) {
                                ((BlubberfishEntity)entity).setAnimation("landing");
                            }
                        } else if (entity instanceof BlubberfishEntity) {
                            ((BlubberfishEntity)entity).setAnimation("land");
                        }
                    } else if (entity instanceof BlubberfishEntity) {
                        ((BlubberfishEntity)entity).setAnimation("fall");
                    }
                }
            } else if (entity instanceof BlubberfishEntity animatable) {
                animatable.setTexture("blubberfish_explode");
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

            if (entity instanceof LivingEntity _livEnt20 && _livEnt20.isBaby()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BLUBBERFISH_FRY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            }

            entity.getPersistentData().putDouble("boom", entity.getPersistentData().getDouble("boom") - 1.0);
            if (entity.getPersistentData().getDouble("boom") == 1.0) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                Entity var29 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if (var29 instanceof ServerPlayer _player) {
                    AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:explode_blubberfish"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("boom") == 2.0) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:sprinkle ~ ~0.5 ~ 0 0 0 0.1 30 force"
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
                            "/particle more_critters:sprinkle ~ ~1 ~ 0 0 0 0.1 30 force"
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
                            "/particle more_critters:remains ~ ~1 ~ 0 0 0 0.1 15 force"
                        );
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 10);
                if (rate == 1.0 && world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle more_critters:white_sprinkle ~ ~0.5 ~ 0 0 0 0.1 1 force"
                        );
                }
            }
        }
    }
}
