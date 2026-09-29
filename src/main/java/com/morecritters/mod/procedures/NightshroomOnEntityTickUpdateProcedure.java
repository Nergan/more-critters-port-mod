package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.LightflyEntity;
import com.morecritters.mod.entity.NightshroomEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class NightshroomOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double healchance = 0.0;
            double rate = 0.0;
            double particle = 0.0;
            if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0, false, false));
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0, false, false));
                }
            }

            if (entity instanceof NightshroomEntity _datEntL3
                && _datEntL3.getEntityData().get(NightshroomEntity.DATA_sit)
                && entity instanceof NightshroomEntity) {
                ((NightshroomEntity)entity).setAnimation("sit");
            }

            if (!entity.getDisplayName().getString().equals("Natsirt") && !entity.getDisplayName().getString().equals("natsirt")) {
                if (entity instanceof NightshroomEntity animatable) {
                    animatable.setTexture("nightshroom");
                }
            } else if (entity instanceof NightshroomEntity animatable) {
                animatable.setTexture("nightshroom_texture_natsirt");
            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F)
                > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F)) {
                healchance = Mth.nextInt(RandomSource.create(), 1, 300);
                if (healchance == 1.0 && entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 2, false, true));
                }
            }

            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            if (entity.getPersistentData().getDouble("attack") == 1.0) {
                entity.getPersistentData().putDouble("attack", Mth.nextInt(RandomSource.create(), 100, 150));
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity
                    && !(entity instanceof NightshroomEntity _datEntL20 && _datEntL20.getEntityData().get(NightshroomEntity.DATA_sit))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 49, false, false));
                    }

                    if (entity instanceof NightshroomEntity) {
                        ((NightshroomEntity)entity).setAnimation("shake");
                    }

                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nightshroom.ruffle")),
                                SoundSource.VOICE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nightshroom.ruffle")),
                                SoundSource.VOICE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    MoreCritters.queueServerWork(
                        5,
                        () -> {
                            if (world instanceof ServerLevel _levelxxxxx) {
                                Entity entityToSpawn = MoreCrittersModEntities.LIGHTFLY
                                    .get()
                                    .spawn(
                                        _levelxxxxx,
                                        BlockPos.containing(
                                            x + Mth.nextInt(RandomSource.create(), -1, 1), y + 3.0, z + Mth.nextInt(RandomSource.create(), -1, 1)
                                        ),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.3, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _levelxxxx) {
                                Entity entityToSpawn = MoreCrittersModEntities.LIGHTFLY
                                    .get()
                                    .spawn(
                                        _levelxxxx,
                                        BlockPos.containing(
                                            x + Mth.nextInt(RandomSource.create(), -1, 1), y + 3.0, z + Mth.nextInt(RandomSource.create(), -1, 1)
                                        ),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.3, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _levelxxx) {
                                Entity entityToSpawn = MoreCrittersModEntities.LIGHTFLY
                                    .get()
                                    .spawn(
                                        _levelxxx,
                                        BlockPos.containing(
                                            x + Mth.nextInt(RandomSource.create(), -1, 1), y + 3.0, z + Mth.nextInt(RandomSource.create(), -1, 1)
                                        ),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.3, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _levelxx) {
                                Entity entityToSpawn = MoreCrittersModEntities.LIGHTFLY
                                    .get()
                                    .spawn(
                                        _levelxx,
                                        BlockPos.containing(
                                            x + Mth.nextInt(RandomSource.create(), -1, 1), y + 3.0, z + Mth.nextInt(RandomSource.create(), -1, 1)
                                        ),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.3, 0.0);
                                }
                            }

                            if (world instanceof ServerLevel _levelx) {
                                Entity entityToSpawn = MoreCrittersModEntities.LIGHTFLY
                                    .get()
                                    .spawn(
                                        _levelx,
                                        BlockPos.containing(
                                            x + Mth.nextInt(RandomSource.create(), -1, 1), y + 3.0, z + Mth.nextInt(RandomSource.create(), -1, 1)
                                        ),
                                        MobSpawnType.MOB_SUMMONED
                                    );
                                if (entityToSpawn != null) {
                                    entityToSpawn.setDeltaMovement(0.0, 0.3, 0.0);
                                }
                            }
                        }
                    );
                    MoreCritters.queueServerWork(
                        40,
                        () -> {
                            if (!world.isClientSide() && world instanceof Level _levelx) {
                                if (!_levelx.isClientSide()) {
                                    _levelx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.lightfly.target")),
                                        SoundSource.VOICE,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.lightfly.target")),
                                        SoundSource.VOICE,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }

                            Vec3 _center = new Vec3(x, y, z);

                            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40.0), e -> true)
                                .stream()
                                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                .toList()) {
                                if (entityiterator instanceof LightflyEntity) {
                                    if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                                        if (entityiterator instanceof LightflyEntity _datEntSetL) {
                                            _datEntSetL.getEntityData().set(LightflyEntity.DATA_targeting, true);
                                        }

                                        if (entityiterator instanceof Mob _entity
                                            && (entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity _ent) {
                                            _entity.setTarget(_ent);
                                        }
                                    } else {
                                        if (entityiterator instanceof LightflyEntity _datEntSetL) {
                                            _datEntSetL.getEntityData().set(LightflyEntity.DATA_targeting, true);
                                        }

                                        if (entityiterator instanceof Mob _entity) {
                                            Entity patt8475$temp = world.getEntitiesOfClass(
                                                    Monster.class, AABB.ofSize(new Vec3(x, y, z), 80.0, 80.0, 80.0), e -> true
                                                )
                                                .stream()
                                                .sorted((new Object() {
                                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                    }
                                                }).compareDistOf(x, y, z))
                                                .findFirst()
                                                .orElse(null);
                                            if (patt8475$temp instanceof LivingEntity _ent) {
                                                _entity.setTarget(_ent);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    );
                }
            }

            particle = Mth.nextInt(RandomSource.create(), 1, 50);
            if (!(world instanceof Level _lvl55 && _lvl55.isDay()) && particle == 1.0 && world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:wax_off ~ ~3 ~ 1 1 1 1 3 force"
                    );
            }
        }
    }
}
