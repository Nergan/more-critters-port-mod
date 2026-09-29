package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.MightshroomEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SpawnNightshroomExpireProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof MightshroomEntity) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.NIGHTSHROOM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
                            "/particle minecraft:block{block_state:\"more_critters:mori_shroom_block\"} ~ ~ ~ 0.6 3 0.6 0 30 force"
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
                            "/particle more_critters:mightshroom_feather ~ ~ ~ 1 3 1 7 30 force"
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
                                    "/particle more_critters:mightshroom_feather ~ ~ ~ 1 3 1 7 30 force"
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
                                            "/particle more_critters:mightshroom_feather ~ ~ ~ 1 3 1 7 30 force"
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
