package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ChatteringTeethItemRCProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
        if (direction != null && entity != null) {
            itemstack.shrink(1);
            if (direction == Direction.UP) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CHATTERING_TEETH
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y + 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.DOWN) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CHATTERING_TEETH
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.NORTH) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CHATTERING_TEETH
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z - 1.0), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.SOUTH) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CHATTERING_TEETH
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z + 1.0), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.WEST) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CHATTERING_TEETH
                        .get()
                        .spawn(_level, BlockPos.containing(x - 1.0, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            } else if (direction == Direction.EAST && world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CHATTERING_TEETH
                    .get()
                    .spawn(_level, BlockPos.containing(x + 1.5, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot(entity.getYRot());
                    entityToSpawn.setYBodyRot(entity.getYRot());
                    entityToSpawn.setYHeadRot(entity.getYRot());
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }

            if (!world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.chattering_teeth.start")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.chattering_teeth.start")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                    );
                }
            }
        }
    }
}
