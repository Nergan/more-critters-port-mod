package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
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

public class CobbleDropProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
        if (direction != null && entity != null) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                == MoreCrittersModItems.CRITTERLING_SACK_COBBLE.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (direction == Direction.UP) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.COBBLE
                            .get()
                            .spawn(_level, BlockPos.containing(x + 0.5, y + 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                } else if (direction == Direction.DOWN) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.COBBLE
                            .get()
                            .spawn(_level, BlockPos.containing(x + 0.5, y - 1.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                } else if (direction == Direction.NORTH) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.COBBLE
                            .get()
                            .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z - 1.0), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                } else if (direction == Direction.SOUTH) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.COBBLE
                            .get()
                            .spawn(_level, BlockPos.containing(x + 0.5, y - 0.0, z + 1.0), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                } else if (direction == Direction.WEST) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.COBBLE
                            .get()
                            .spawn(_level, BlockPos.containing(x - 1.0, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                } else if (direction == Direction.EAST && world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.COBBLE
                        .get()
                        .spawn(_level, BlockPos.containing(x + 1.5, y - 0.0, z + 0.5), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (entity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }
            } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                == MoreCrittersModItems.CRITTERLING_SACK_COBBLE_RARE.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (direction == Direction.UP) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~1 ~0.5 {Datavariant:1}"
                            );
                    }
                } else if (direction == Direction.DOWN) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~-1 ~0.5 {Datavariant:1}"
                            );
                    }
                } else if (direction == Direction.NORTH) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~ ~-0.5 {Datavariant:1}"
                            );
                    }
                } else if (direction == Direction.SOUTH) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~ ~1.5 {Datavariant:1}"
                            );
                    }
                } else if (direction == Direction.WEST) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~-0.5 ~ ~0.5 {Datavariant:1}"
                            );
                    }
                } else if (direction == Direction.EAST && world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:cobble ~1.5 ~ ~0.5 {Datavariant:1}"
                        );
                }

                if (entity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }
            } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                == MoreCrittersModItems.CRITTERLING_SACK_COBBLE_EPIC.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (direction == Direction.UP) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~1 ~0.5 {Datavariant:2}"
                            );
                    }
                } else if (direction == Direction.DOWN) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~-1 ~0.5 {Datavariant:2}"
                            );
                    }
                } else if (direction == Direction.NORTH) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~ ~-0.5 {Datavariant:2}"
                            );
                    }
                } else if (direction == Direction.SOUTH) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~0.5 ~ ~1.5 {Datavariant:2}"
                            );
                    }
                } else if (direction == Direction.WEST) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:cobble ~-0.5 ~ ~0.5 {Datavariant:2}"
                            );
                    }
                } else if (direction == Direction.EAST && world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:cobble ~1.5 ~ ~0.5 {Datavariant:2}"
                        );
                }

                if (entity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }
            }
        }
    }
}
