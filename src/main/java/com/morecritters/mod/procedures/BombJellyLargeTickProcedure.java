package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.BombJellyLargeEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BombJellyLargeTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("animation", entity.getPersistentData().getDouble("animation") - 1.0);
            if (entity.getPersistentData().getDouble("animation") <= 0.0) {
                entity.getPersistentData().putDouble("animation", 7.0);
                if (ServerConfig.CONFIG.animateBombJelly.get()) {
                    MoreCritters.queueServerWork(
                        2,
                        () -> {
                            if ((entity instanceof BombJellyLargeEntity animatable ? animatable.getTexture() : "null").equals("bomb_jelly_large1")) {
                                if (entity instanceof BombJellyLargeEntity animatable) {
                                    animatable.setTexture("bomb_jelly_large2");
                                }
                            } else if ((entity instanceof BombJellyLargeEntity animatable ? animatable.getTexture() : "null").equals("bomb_jelly_large2")) {
                                if (entity instanceof BombJellyLargeEntity animatable) {
                                    animatable.setTexture("bomb_jelly_large3");
                                }
                            } else if ((entity instanceof BombJellyLargeEntity animatable ? animatable.getTexture() : "null").equals("bomb_jelly_large3")) {
                                if (entity instanceof BombJellyLargeEntity animatable) {
                                    animatable.setTexture("bomb_jelly_large4");
                                }
                            } else if ((entity instanceof BombJellyLargeEntity animatable ? animatable.getTexture() : "null").equals("bomb_jelly_large4")) {
                                if (entity instanceof BombJellyLargeEntity animatable) {
                                    animatable.setTexture("bomb_jelly_large5");
                                }
                            } else if ((entity instanceof BombJellyLargeEntity animatable ? animatable.getTexture() : "null").equals("bomb_jelly_large5")
                                && entity instanceof BombJellyLargeEntity animatable) {
                                animatable.setTexture("bomb_jelly_large1");
                            }
                        }
                    );
                }
            }

            if (!entity.isInWaterOrBubble() && !entity.onGround() && entity instanceof BombJellyLargeEntity) {
                ((BombJellyLargeEntity)entity).setAnimation("fall");
            }

            if (((BombJellyLargeEntity)entity).animationprocedure.equals("fall")) {
                if (entity.onGround()) {
                    if (entity instanceof BombJellyLargeEntity) {
                        ((BombJellyLargeEntity)entity).setAnimation("land2");
                    }
                } else if (entity.isInWaterOrBubble() && entity instanceof BombJellyLargeEntity) {
                    ((BombJellyLargeEntity)entity).setAnimation("idle");
                }
            }

            if (entity.isInWaterOrBubble() && entity.isAlive()) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:aquatic")))
                        && !(entityiterator instanceof WaterAnimal)
                        && !(new Object() {
                                public boolean checkGamemode(Entity _ent) {
                                    if (_ent instanceof ServerPlayer _serverPlayer) {
                                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                                    } else {
                                        return _ent.level().isClientSide() && _ent instanceof Player _player
                                            ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                    == GameType.CREATIVE
                                            : false;
                                    }
                                }
                            })
                            .checkGamemode(entityiterator)
                        && !(new Object() {
                                public boolean checkGamemode(Entity _ent) {
                                    if (_ent instanceof ServerPlayer _serverPlayer) {
                                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                    } else {
                                        return _ent.level().isClientSide() && _ent instanceof Player _player
                                            ? Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode()
                                                    == GameType.SPECTATOR
                                            : false;
                                    }
                                }
                            })
                            .checkGamemode(entityiterator)
                        && !((BombJellyLargeEntity)entity).animationprocedure.equals("explode")) {
                        if (entity instanceof BombJellyLargeEntity) {
                            ((BombJellyLargeEntity)entity).setAnimation("explode");
                        }

                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bomb_jelly.explode")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bomb_jelly.explode")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        MoreCritters.queueServerWork(
                            15,
                            () -> {
                                if (entity.isAlive()) {
                                    if (world instanceof ServerLevel _levelxxx) {
                                        _levelxxx.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(x, y, z),
                                                        Vec2.ZERO,
                                                        _levelxxx,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _levelxxx.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle minecraft:bubble ~ ~ ~ 1 1 1 0 100 force"
                                            );
                                    }

                                    if (world instanceof Level _levelxx && !_levelxx.isClientSide()) {
                                        _levelxx.explode(
                                            null, x, y, z, (float)ServerConfig.CONFIG.largeBombJellyPower.get().doubleValue(), ExplosionInteraction.NONE
                                        );
                                    }

                                    Entity patt7868$temp = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15.0, 15.0, 15.0), e -> true)
                                        .stream()
                                        .sorted((new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }).compareDistOf(x, y, z))
                                        .findFirst()
                                        .orElse(null);
                                    if (patt7868$temp instanceof ServerPlayer _player) {
                                        AdvancementHolder _adv = _player.server
                                            .getAdvancements()
                                            .get(ResourceLocation.parse("more_critters:explode_bomb_jelly"));
                                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                        if (!_ap.isDone()) {
                                            for (String criteria : _ap.getRemainingCriteria()) {
                                                _player.getAdvancements().award(_adv, criteria);
                                            }
                                        }
                                    }

                                    for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 2.0, 4.0); index0++) {
                                        if (world instanceof ServerLevel _levelx) {
                                            ItemEntity entityToSpawn = new ItemEntity(
                                                _levelx, x, y, z, new ItemStack(MoreCrittersModItems.EXPLOSIVE_JELLY.get())
                                            );
                                            entityToSpawn.setPickUpDelay(10);
                                            _levelx.addFreshEntity(entityToSpawn);
                                        }
                                    }

                                    if (!entity.level().isClientSide()) {
                                        entity.discard();
                                    }
                                }
                            }
                        );
                    }
                }
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
        }
    }
}
