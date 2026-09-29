package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.BalloonRatEntity;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class BalloonRatFeedProcedure {
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
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CUPCAKE_STAGNATION.get()
                && entity instanceof BalloonRatEntity
                && entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:cupcake_stagnation\"} ~ ~0.5 ~ 0.1 0.1 0.1 0.1 5 force"
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.STAGNATION, 3600, 0, false, true));
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.HALLUCINAZIUM);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.ASPHYXIATION);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.BRITTLENESS);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.MUSCLE_ACHE);
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
                    (sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CUPCAKE_MUSCLE_ACHE.get()
                && entity instanceof BalloonRatEntity
                && entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:cupcake_muscle_ache\"} ~ ~0.5 ~ 0.1 0.1 0.1 0.1 5 force"
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.MUSCLE_ACHE, 3600, 0, false, true));
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.HALLUCINAZIUM);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.ASPHYXIATION);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.BRITTLENESS);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.STAGNATION);
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
                    (sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CUPCAKE_BRITTLENESS.get()
                && entity instanceof BalloonRatEntity
                && entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:cupcake_brittleness\"} ~ ~0.5 ~ 0.1 0.1 0.1 0.1 5 force"
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.BRITTLENESS, 3600, 0, false, true));
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.HALLUCINAZIUM);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.ASPHYXIATION);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.MUSCLE_ACHE);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.STAGNATION);
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
                    (sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CUPCAKE_HALLUCINAZIUM.get()
                && entity instanceof BalloonRatEntity
                && entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:cupcake_hallucinazium\"} ~ ~0.5 ~ 0.1 0.1 0.1 0.1 5 force"
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.HALLUCINAZIUM, 3600, 0, false, true));
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.BRITTLENESS);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.ASPHYXIATION);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.MUSCLE_ACHE);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.STAGNATION);
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
                    (sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CUPCAKE_ASPHYXIATION.get()
                && entity instanceof BalloonRatEntity
                && entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof BalloonRatEntity _datEntI ? _datEntI.getEntityData().get(BalloonRatEntity.DATA_variant) : 0) == 2) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:cupcake_asphyxiation\"} ~ ~0.5 ~ 0.1 0.1 0.1 0.1 5 force"
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.ASPHYXIATION, 3600, 0, false, true));
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.BRITTLENESS);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.HALLUCINAZIUM);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.MUSCLE_ACHE);
                }

                if (entity instanceof LivingEntity _entity) {
                    _entity.removeEffect(MoreCrittersModMobEffects.STAGNATION);
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
                    (sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.CUPCAKE.get()
                && entity instanceof BalloonRatEntity
                && entity instanceof TamableAnimal _tamIsTamedBy
                && sourceentity instanceof LivingEntity _livEnt
                && _tamIsTamedBy.isOwnedBy(_livEnt)
                && (entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F)
                    != (entity instanceof LivingEntity _livEntx ? _livEntx.getMaxHealth() : -1.0F)) {
                if (entity instanceof LivingEntity _entity) {
                    _entity.setHealth((entity instanceof LivingEntity _livEntx ? _livEntx.getHealth() : -1.0F) + 3.0F);
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y, z + 0.5),
                                    Vec2.ZERO,
                                    _level,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _level.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:cupcake\"} ~ ~0.5 ~ 0.1 0.1 0.1 0.1 5 force"
                        );
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
                    (sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY)
                        .setCount((sourceentity instanceof LivingEntity _livEntx ? _livEntx.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                }
            }
        }
    }
}
