package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import com.morecritters.mod.entity.NervoidEntity;
import com.morecritters.mod.entity.ShimmerwingEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class RightClickMobProcedure {
    @SubscribeEvent
    public static void onRightClickEntity(EntityInteract event) {
        if (event.getHand() == event.getEntity().getUsedItemHand()) {
            execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            double shimmer = 0.0;
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                == MoreCrittersModItems.FUNGAL_FLESH.get()) {
                if (entity instanceof Zombie) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:fungal_flesh\"} ~ ~1.5 ~ 0.2 0.2 0.2 0.05 7"
                            );
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.fungal_zombie.transform")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.fungal_zombie.transform")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.FUNGAL_ZOMBIE
                            .get()
                            .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }
                }

                if (entity instanceof Cow) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(entity.getX(), entity.getY(), entity.getZ()),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:item{item:\"more_critters:fungal_flesh\"} ~ ~1 ~ 0.2 0.2 0.2 0.05 7"
                            );
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = EntityType.MOOSHROOM.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.PURGATORIAL_MIXTURE.get()
                && entity instanceof AncientSkeletonEntity
                && !((AncientSkeletonEntity)entity).animationprocedure.equals("fossil_shake")
                && !((AncientSkeletonEntity)entity).animationprocedure.equals("fossil_alive")) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.rise")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.rise")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild) && sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.SPAWN_MIGHTSHROOM, 110, 0, false, false));
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.DEATH_STEW.get()
                && entity instanceof AncientSkeletonEntity
                && (entity instanceof AncientSkeletonEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonEntity.DATA_shroomed) : 0) == 0) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.pour_soup")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.pour_soup")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (entity instanceof AncientSkeletonEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(AncientSkeletonEntity.DATA_shroomed, 1);
                }

                if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild) && sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(Items.BOWL).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.LIFE_STEW.get()
                && entity instanceof AncientSkeletonEntity
                && (entity instanceof AncientSkeletonEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonEntity.DATA_shroomed) : 0) == 0) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.pour_soup")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.pour_soup")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (entity instanceof AncientSkeletonEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(AncientSkeletonEntity.DATA_shroomed, 2);
                }

                if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild) && sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(Items.BOWL).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.EXPLOSIVE_JELLY.get()
                && !entity.getPersistentData().getBoolean("combusting")) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.explosive_jelly.rub")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.explosive_jelly.rub")),
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
                                    CommandSource.NULL,
                                    new Vec3(x, y + entity.getBbHeight(), z),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:explosive_jelly\"} ~ ~ ~ 0.2 0.2 0.2 0 3 force"
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.COMBUSTION, 200, 0, false, true));
                }

                entity.getPersistentData().putBoolean("combusting", true);
                if ((new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.ADVENTURE
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)
                    || (new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.SURVIVAL
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)) {
                    (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }

            if (entity instanceof AncientSkeletonEntity
                && !((AncientSkeletonEntity)entity).animationprocedure.equals("fossil_shake")
                && !((AncientSkeletonEntity)entity).animationprocedure.equals("fossil_alive")
                && entity instanceof AncientSkeletonEntity _datEntL75
                && _datEntL75.getEntityData().get(AncientSkeletonEntity.DATA_set)
                && sourceentity.isShiftKeyDown()
                && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.ANCIENT_SKELETON_ITEM.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }
            }

            if (entity instanceof AncientSkeletonExhibitEntity) {
                if (sourceentity.isShiftKeyDown()) {
                    if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                        if (sourceentity instanceof LivingEntity _entity) {
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                        }

                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }

                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(MoreCrittersModItems.ANCIENT_SKELETON_EXHIBIT_ITEM.get()).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }
                    }
                } else {
                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if ((entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0)
                        == 0) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 1);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 1) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 2);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 2) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 3);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 3) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 4);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 4) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 5);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 5) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 6);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 6) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 7);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 7) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 8);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 8) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 9);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if ((
                            entity instanceof AncientSkeletonExhibitEntity _datEntI ? _datEntI.getEntityData().get(AncientSkeletonExhibitEntity.DATA_pose) : 0
                        )
                        == 9) {
                        if (entity instanceof AncientSkeletonExhibitEntity _datEntSetI) {
                            _datEntSetI.getEntityData().set(AncientSkeletonExhibitEntity.DATA_pose, 0);
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ancient_skeleton.hurt")),
                                    SoundSource.BLOCKS,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    }
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BRUSH
                && entity instanceof ShimmerwingEntity) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:shimmerwing_shed")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:shimmerwing_shed")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y, z + 0.5, new ItemStack(MoreCrittersModItems.END_DUST.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }

                if ((new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.ADVENTURE
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)
                    || (new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.SURVIVAL
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)) {
                    ItemStack _ist = sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
                    if (world instanceof ServerLevel _serverLevel) {
                        _ist.hurtAndBreak(8, _serverLevel, null, _item -> {});
                    }
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.CHORUS_FRUIT
                && entity instanceof ShimmerwingEntity
                && !(entity.getPersistentData().getDouble("teleport") > 1.0)) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shimmerwing.gift")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shimmerwing.gift")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (entity instanceof ShimmerwingEntity) {
                    ((ShimmerwingEntity)entity).setAnimation("eat");
                }

                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.ENDS_BLESSING, 2400, 0, false, true));
                }

                if ((new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.ADVENTURE
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)
                    || (new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.SURVIVAL
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)) {
                    (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }

                entity.getPersistentData().putDouble("teleport", 40.0);
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE
                && entity instanceof NervoidEntity
                && (entity instanceof NervoidEntity animatable ? animatable.getTexture() : "null").equals("nervoid_wet")) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bottle.fill")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bottle.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                        );
                    }
                }

                if (entity instanceof NervoidEntity animatable) {
                    animatable.setTexture("nervoid");
                }

                if (sourceentity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.SPINAL_FLUID_BOTTLE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }

                if ((new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.ADVENTURE
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)
                    || (new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                } else {
                                    return _ent.level().isClientSide() && _ent instanceof Player _player
                                        ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                == GameType.SURVIVAL
                                        : false;
                                }
                            }
                        })
                        .checkGamemode(sourceentity)) {
                    (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.MYSTERIOUS_VIRUS_BOTTLE.get()
                && entity instanceof EnderMan) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.drink")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.drink")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if ((
                        (new Object() {
                                    public boolean checkGamemode(Entity _ent) {
                                        if (_ent instanceof ServerPlayer _serverPlayer) {
                                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                                        } else {
                                            return _ent.level().isClientSide() && _ent instanceof Player _player
                                                ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                        == GameType.ADVENTURE
                                                : false;
                                        }
                                    }
                                })
                                .checkGamemode(sourceentity)
                            || (new Object() {
                                    public boolean checkGamemode(Entity _ent) {
                                        if (_ent instanceof ServerPlayer _serverPlayer) {
                                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                        } else {
                                            return _ent.level().isClientSide() && _ent instanceof Player _player
                                                ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                        == GameType.SURVIVAL
                                                : false;
                                        }
                                    }
                                })
                                .checkGamemode(sourceentity)
                    )
                    && sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.ENDFECTED, 2147483647, 0, false, true));
                }
            }
        }
    }
}
