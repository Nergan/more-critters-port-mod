package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TreepletEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.TREEPLING_TOP.get().spawn(_level, BlockPos.containing(x, y + 2.0, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot(entity.getYRot());
                    entityToSpawn.setYBodyRot(entity.getYRot());
                    entityToSpawn.setYHeadRot(entity.getYRot());
                    entityToSpawn.setDeltaMovement(
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2)
                    );
                }
            }

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.TREEPLING_MIDDLE
                    .get()
                    .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot(entity.getYRot());
                    entityToSpawn.setYBodyRot(entity.getYRot());
                    entityToSpawn.setYHeadRot(entity.getYRot());
                    entityToSpawn.setDeltaMovement(
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2)
                    );
                }
            }

            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.TREEPLING_BOTTOM
                    .get()
                    .spawn(_level, BlockPos.containing(x, y + 0.0, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot(entity.getYRot());
                    entityToSpawn.setYBodyRot(entity.getYRot());
                    entityToSpawn.setYHeadRot(entity.getYRot());
                    entityToSpawn.setDeltaMovement(
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2),
                        Mth.nextDouble(RandomSource.create(), -0.2, 0.2)
                    );
                }
            }

            if (!entity.level().isClientSide()) {
                entity.discard();
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"minecraft:birch_log\"} ~ ~ ~ 0.2 0.2 0.2 0.1 5 force"
                    );
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"minecraft:birch_log\"} ~ ~1 ~ 0.2 0.2 0.2 0.1 5 force"
                    );
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"minecraft:birch_log\"} ~ ~2 ~ 0.2 0.2 0.2 0.1 5 force"
                    );
            }
        }
    }
}
