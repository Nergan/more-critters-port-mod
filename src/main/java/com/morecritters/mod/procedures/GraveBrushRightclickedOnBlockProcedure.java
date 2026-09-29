package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GraveBrushRightclickedOnBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
        if (direction != null && entity != null) {
            double rarity = 0.0;
            double random = 0.0;
            double rarity2 = 0.0;
            double disc = 0.0;
            if (direction == Direction.UP
                && world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))
                && !(entity instanceof Player _plrCldCheck4 && _plrCldCheck4.getCooldowns().isOnCooldown(itemstack.getItem()))) {
                if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                    ItemStack _ist = itemstack;
                    if (world instanceof ServerLevel _serverLevel) {
                        _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                    }
                }

                if (entity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:grave_brush_use")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:grave_brush_use")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
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
                            "/particle minecraft:block{block_state:\"XXX\"} ~0.5 ~1 ~0.5 0.2 0 0.2 1 5 force"
                                .replace("XXX", BuiltInRegistries.BLOCK.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString())
                        );
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                    == Level.OVERWORLD) {
                    rarity = Mth.nextInt(RandomSource.create(), 1, 5);
                    if (rarity == 1.0) {
                        rarity2 = Mth.nextInt(RandomSource.create(), 1, 3);
                        if (rarity2 == 1.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = MoreCrittersModEntities.AMALGAM
                                    .get()
                                    .spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                }
                            }
                        } else {
                            random = Mth.nextInt(RandomSource.create(), 1, 4);
                            if (random == 1.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.ZOMBIE_VILLAGER
                                        .spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                    }
                                }
                            } else if (random == 2.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.ZOMBIE_HORSE.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                    }
                                }
                            } else if (random == 3.0) {
                                if (world instanceof ServerLevel _level) {
                                    Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                    }
                                }
                            } else if (random == 4.0 && world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.SKELETON_HORSE.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                }
                            }
                        }
                    } else {
                        random = Mth.nextInt(RandomSource.create(), 1, 4);
                        if (random == 1.0) {
                            disc = Mth.nextInt(RandomSource.create(), 1, 50);
                            if (disc == 1.0) {
                                if (world instanceof ServerLevel _level) {
                                    _level.getServer()
                                        .getCommands()
                                        .performPrefixedCommand(
                                            new CommandSourceStack(
                                                    CommandSource.NULL,
                                                    new Vec3(x, y, z),
                                                    Vec2.ZERO,
                                                    _level,
                                                    4,
                                                    "",
                                                    Component.literal(""),
                                                    _level.getServer(),
                                                    null
                                                )
                                                .withSuppressedOutput(),
                                            "/summon zombie ~0.5 ~-1 ~0.5 {HandItems:[{id:\"more_critters:music_disc_waddle\",count:1},{}],HandDropChances:[1f,0f]}"
                                        );
                                }

                                world.getEntitiesOfClass(Zombie.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                                    .stream()
                                    .sorted((new Object() {
                                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                        }
                                    }).compareDistOf(x, y, z))
                                    .findFirst()
                                    .orElse(null)
                                    .setDeltaMovement(new Vec3(0.0, 0.7, 0.0));
                            } else if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                }
                            }
                        } else if (random == 2.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                                }
                            }
                        } else if (random == 3.0) {
                            if (world instanceof ServerLevel _level) {
                                Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.5, 0.0);
                                }
                            }
                        } else if (random == 4.0 && world instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.5, 0.0);
                            }
                        }
                    }
                } else if ((
                        world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)
                    )
                    == Level.NETHER) {
                    random = Mth.nextInt(RandomSource.create(), 1, 3);
                    if (random == 1.0) {
                        if (world instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.ZOMBIFIED_PIGLIN.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                            }
                        }
                    } else if (random == 2.0) {
                        if (world instanceof ServerLevel _level) {
                            Entity entityToSpawn = EntityType.ZOGLIN.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                            }
                        }
                    } else if (random == 3.0 && world instanceof ServerLevel _level) {
                        Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(x, y - 1.0, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setDeltaMovement(0.0, 0.7, 0.0);
                        }
                    }

                    rarity = Mth.nextInt(RandomSource.create(), 1, 7);
                }
            }
        }
    }
}
