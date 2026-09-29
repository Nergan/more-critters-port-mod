package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SpawnMightshroomEffectExpiresProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof AncientSkeletonEntity) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof Player && entityiterator instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:spawn_migthshroom"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria()) {
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }

                if ((entity instanceof AncientSkeletonEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonEntity.DATA_shroomed) : 0) == 1) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.FRIGHTSHROOM
                            .get()
                            .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                } else if ((entity instanceof AncientSkeletonEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonEntity.DATA_shroomed) : 0) == 2) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.NIGHTSHROOM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                } else if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.MIGHTSHROOM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"minecraft:rotten_flesh\"} ~ ~ ~ 0.5 2 0.5 0 30 force"
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
                            "/particle minecraft:block{block_state:\"minecraft:mycelium\"} ~ ~ ~ 0.5 2 0.5 0 30 force"
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
                            "/particle more_critters:mightshroom_feather ~ ~2 ~ 0.7 1 0.7 3 6 force"
                        );
                }

                MoreCritters.queueServerWork(
                    2,
                    () -> {
                        if (world instanceof ServerLevel _levelx) {
                            _levelx.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _levelx, 4, "", Component.literal(""), _levelx.getServer(), null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:mightshroom_feather ~ ~2 ~ 0.7 1 0.7 3 6 force"
                                );
                        }

                        MoreCritters.queueServerWork(
                            2,
                            () -> {
                                if (world instanceof ServerLevel _levelxx) {
                                    _levelxx.getServer()
                                        .getCommands()
                                        .performPrefixedCommand(
                                            new CommandSourceStack(
                                                    CommandSource.NULL,
                                                    new Vec3(x, y, z),
                                                    Vec2.ZERO,
                                                    _levelxx,
                                                    4,
                                                    "",
                                                    Component.literal(""),
                                                    _levelxx.getServer(),
                                                    null
                                                )
                                                .withSuppressedOutput(),
                                            "/particle more_critters:mightshroom_feather ~ ~2 ~ 0.7 1 0.7 3 6 force"
                                        );
                                }
                            }
                        );
                    }
                );
            }
        }
    }
}
