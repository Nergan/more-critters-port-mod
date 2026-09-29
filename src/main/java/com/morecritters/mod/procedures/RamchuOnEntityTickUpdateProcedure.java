package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.RamchuEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
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
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class RamchuOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 0) {
                if (entity instanceof RamchuEntity animatable) {
                    animatable.setTexture("ramchu");
                }
            } else if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 1) {
                if (entity instanceof RamchuEntity animatable) {
                    animatable.setTexture("ramchu_noshell");
                }
            } else if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 2
                && entity instanceof RamchuEntity animatable) {
                animatable.setTexture("ramchu_noslime");
            }

            if (entity.isInWaterOrBubble()) {
                entity.getPersistentData().putDouble("air", 200.0);
            } else {
                entity.getPersistentData().putDouble("air", entity.getPersistentData().getDouble("air") - 1.0);
            }

            if (entity.getPersistentData().getDouble("air") <= -1.0) {
                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)), 1.0F);
                entity.getPersistentData().putDouble("air", 20.0);
            }

            if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                if (entity instanceof RamchuEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(RamchuEntity.DATA_ramming, true);
                }
            } else if (entity instanceof RamchuEntity _datEntSetL) {
                _datEntSetL.getEntityData().set(RamchuEntity.DATA_ramming, false);
            }

            if (entity instanceof RamchuEntity _datEntL18 && _datEntL18.getEntityData().get(RamchuEntity.DATA_ramming)) {
                if (entity.isInWaterOrBubble()) {
                    if (entity instanceof RamchuEntity) {
                        ((RamchuEntity)entity).setAnimation("ram");
                    }

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10, 2, false, false));
                    }

                    if (((RamchuEntity)entity).animationprocedure.equals("ram")
                        && (
                            world.getBlockState(BlockPos.containing(x + 0.5, y, z)).canOcclude()
                                || world.getBlockState(BlockPos.containing(x - 0.5, y, z)).canOcclude()
                                || world.getBlockState(BlockPos.containing(x, y, z + 0.5)).canOcclude()
                                || world.getBlockState(BlockPos.containing(x, y, z - 0.5)).canOcclude()
                        )) {
                        if (entity instanceof RamchuEntity) {
                            ((RamchuEntity)entity).setAnimation("empty");
                        }

                        if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 0) {
                            if (entity instanceof RamchuEntity _datEntSetI) {
                                _datEntSetI.getEntityData().set(RamchuEntity.DATA_state, 1);
                            }

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
                                        "/particle minecraft:block{block_state:\"minecraft:deepslate\"} ~ ~0.3 ~ 0.2 0.2 0.2 1 12 force"
                                    );
                            }

                            if (!world.isClientSide() && world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ramchu.bust")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _level.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ramchu.bust")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.STUNNED, 40, 0, false, false));
                            }

                            MoreCritters.queueServerWork(
                                1,
                                () -> MoreCritters.queueServerWork(
                                    1,
                                    () -> MoreCritters.queueServerWork(
                                        1, () -> MoreCritters.queueServerWork(1, () -> MoreCritters.queueServerWork(1, () -> {}))
                                    )
                                )
                            );
                        }
                    }
                } else if (entity instanceof RamchuEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(RamchuEntity.DATA_ramming, false);
                }
            } else if (entity instanceof RamchuEntity) {
                ((RamchuEntity)entity).setAnimation("empty");
            }

            entity.getPersistentData().putDouble("ram", entity.getPersistentData().getDouble("ram") - 1.0);
            entity.getPersistentData().putDouble("oil", entity.getPersistentData().getDouble("oil") - 1.0);
            if (entity.getPersistentData().getDouble("ram") < 0.0) {
                entity.getPersistentData().putDouble("ram", Mth.nextDouble(RandomSource.create(), 70.0, 200.0));
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof Player
                        && entity instanceof LivingEntity _liveEnt
                        && entityiterator != null
                        && _liveEnt.hasLineOfSight(entityiterator)
                        && entityiterator.isInWaterOrBubble()
                        && entity.isInWaterOrBubble()
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
                        && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)
                        && (entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 0
                        && entity instanceof Mob _entity
                        && entityiterator instanceof LivingEntity _ent) {
                        _entity.setTarget(_ent);
                    }
                }
            }

            if (entity.getPersistentData().getDouble("oil") == 0.0 && entity instanceof RamchuEntity _datEntSetI) {
                _datEntSetI.getEntityData().set(RamchuEntity.DATA_state, 1);
            }

            if (entity instanceof LivingEntity _livEnt67 && _livEnt67.isBaby()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.RAMCHU_FRY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot((float)Math.random());
                        entityToSpawn.setYBodyRot((float)Math.random());
                        entityToSpawn.setYHeadRot((float)Math.random());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            }
        }
    }
}
