package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BunbugEggsRightClickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
        if (direction != null && entity != null) {
            if (entity instanceof LivingEntity _entity) {
                _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            itemstack.shrink(1);
            if (world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.turtle.egg_break")),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.turtle.egg_break")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                    );
                }
            }

            if (direction == Direction.UP) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BABY_BUNBUG
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y + 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                for (int index0 = 0; index0 < 25; index0++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x + 0.5, y + 1.0, z + 0.5),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:bunbug_eggs\"} ~ ~ ~ 0.1 0.1 0.1 0.05 1 force"
                            );
                    }
                }
            } else if (direction == Direction.DOWN) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BABY_BUNBUG
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                for (int index1 = 0; index1 < 25; index1++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x + 0.5, y - 1.0, z + 0.5),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:bunbug_eggs\"} ~ ~ ~ 0.1 0.1 0.1 0.05 1 force"
                            );
                    }
                }
            } else if (direction == Direction.NORTH) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BABY_BUNBUG
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z - 1.0), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                for (int index2 = 0; index2 < 25; index2++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x + 0.5, y - 0.0, z - 1.0),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:bunbug_eggs\"} ~ ~ ~ 0.1 0.1 0.1 0.05 1 force"
                            );
                    }
                }
            } else if (direction == Direction.SOUTH) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BABY_BUNBUG
                        .get()
                        .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z + 1.0), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                for (int index3 = 0; index3 < 25; index3++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x + 0.5, y - 0.0, z + 1.0),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:bunbug_eggs\"} ~ ~ ~ 0.1 0.1 0.1 0.05 1 force"
                            );
                    }
                }
            } else if (direction == Direction.WEST) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BABY_BUNBUG
                        .get()
                        .spawn(_level, BlockPos.containing(x - 1.0, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                for (int index4 = 0; index4 < 25; index4++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x - 1.0, y - 0.0, z + 0.5),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:bunbug_eggs\"} ~ ~ ~ 0.1 0.1 0.1 0.05 1 force"
                            );
                    }
                }
            } else if (direction == Direction.EAST) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.BABY_BUNBUG
                        .get()
                        .spawn(_level, BlockPos.containing(x + 1.5, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setXRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                for (int index5 = 0; index5 < 25; index5++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(x + 1.5, y - 0.0, z + 0.5),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:bunbug_eggs\"} ~ ~ ~ 0.1 0.1 0.1 0.05 1 force"
                            );
                    }
                }
            }
        }
    }
}
