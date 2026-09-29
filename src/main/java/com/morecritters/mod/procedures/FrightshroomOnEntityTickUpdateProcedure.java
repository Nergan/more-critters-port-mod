package com.morecritters.mod.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.FrightshroomEntity;
import com.morecritters.mod.entity.RotPieceEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class FrightshroomOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            boolean foundcrater = false;
            double rate = 0.0;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            double changer = 0.0;
            double crater_sx = 0.0;
            double crater_sy = 0.0;
            double crater_sz = 0.0;
            entity.getPersistentData().putDouble("attack", entity.getPersistentData().getDouble("attack") - 1.0);
            if (entity.getPersistentData().getDouble("attack") == 1.0) {
                entity.getPersistentData().putDouble("attack", Mth.nextInt(RandomSource.create(), 100, 150));
                if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity) {
                    rate = Mth.nextInt(RandomSource.create(), 1, 2);
                    if (rate == 1.0) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 30, false, false));
                        }

                        if (entity instanceof FrightshroomEntity) {
                            ((FrightshroomEntity)entity).setAnimation("blows");
                        }

                        MoreCritters.queueServerWork(
                            20,
                            () -> {
                                if (!world.isClientSide() && world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.frightshroom.burst")),
                                            SoundSource.HOSTILE,
                                            2.0F,
                                            1.0F
                                        );
                                    } else {
                                        _level.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.frightshroom.burst")),
                                            SoundSource.HOSTILE,
                                            2.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 2.0, 5.0); index0++) {
                                    if (world instanceof ServerLevel projectileLevel) {
                                        Projectile _entityToSpawn = (new Object() {
                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                RotPieceEntity entityToSpawn = new RotPieceEntity(MoreCrittersModEntities.ROT_PIECE.get(), level);
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage(damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                return entityToSpawn;
                                            }
                                        }).getArrow(projectileLevel, entity, 5.0F, 0);
                                        _entityToSpawn.setPos(x, y + 3.0, z);
                                        _entityToSpawn.shoot(
                                            Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                            Mth.nextDouble(RandomSource.create(), 4.0, 45.0),
                                            Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                            1.0F,
                                            0.0F
                                        );
                                        projectileLevel.addFreshEntity(_entityToSpawn);
                                    }

                                    MoreCritters.queueServerWork(
                                        5,
                                        () -> {
                                            for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 5.0); index1++) {
                                                if (world instanceof ServerLevel projectileLevelx) {
                                                    Projectile _entityToSpawnx = (new Object() {
                                                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                            RotPieceEntity entityToSpawn = new RotPieceEntity(MoreCrittersModEntities.ROT_PIECE.get(), level);
                                                            entityToSpawn.setOwner(shooter);
                                                            entityToSpawn.setBaseDamage(damage);
                                                            entityToSpawn.setKnockback(knockback);
                                                            entityToSpawn.setSilent(true);
                                                            return entityToSpawn;
                                                        }
                                                    }).getArrow(projectileLevelx, entity, 5.0F, 0);
                                                    _entityToSpawnx.setPos(x, y + 3.0, z);
                                                    _entityToSpawnx.shoot(
                                                        Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                        Mth.nextDouble(RandomSource.create(), 4.0, 45.0),
                                                        Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                        1.0F,
                                                        0.0F
                                                    );
                                                    projectileLevelx.addFreshEntity(_entityToSpawnx);
                                                }
                                            }

                                            MoreCritters.queueServerWork(
                                                5,
                                                () -> {
                                                    if (!world.isClientSide() && world instanceof Level _level) {
                                                        if (!_level.isClientSide()) {
                                                            _level.playSound(
                                                                (Player)null,
                                                                BlockPos.containing(x, y, z),
                                                                BuiltInRegistries.SOUND_EVENT
                                                                    .get(ResourceLocation.parse("more_critters:entity.frightshroom.burst")),
                                                                SoundSource.HOSTILE,
                                                                2.0F,
                                                                1.0F
                                                            );
                                                        } else {
                                                            _level.playLocalSound(
                                                                x,
                                                                y,
                                                                z,
                                                                BuiltInRegistries.SOUND_EVENT
                                                                    .get(ResourceLocation.parse("more_critters:entity.frightshroom.burst")),
                                                                SoundSource.HOSTILE,
                                                                2.0F,
                                                                1.0F,
                                                                false
                                                            );
                                                        }
                                                    }

                                                    for (int index2 = 0; index2 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 5.0); index2++) {
                                                        if (world instanceof ServerLevel projectileLevelxx) {
                                                            Projectile _entityToSpawnxx = (new Object() {
                                                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                    RotPieceEntity entityToSpawn = new RotPieceEntity(
                                                                        MoreCrittersModEntities.ROT_PIECE.get(), level
                                                                    );
                                                                    entityToSpawn.setOwner(shooter);
                                                                    entityToSpawn.setBaseDamage(damage);
                                                                    entityToSpawn.setKnockback(knockback);
                                                                    entityToSpawn.setSilent(true);
                                                                    return entityToSpawn;
                                                                }
                                                            }).getArrow(projectileLevelxx, entity, 5.0F, 0);
                                                            _entityToSpawnxx.setPos(x, y + 3.0, z);
                                                            _entityToSpawnxx.shoot(
                                                                Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                Mth.nextDouble(RandomSource.create(), 4.0, 45.0),
                                                                Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                1.0F,
                                                                0.0F
                                                            );
                                                            projectileLevelxx.addFreshEntity(_entityToSpawnxx);
                                                        }
                                                    }

                                                    MoreCritters.queueServerWork(
                                                        5,
                                                        () -> {
                                                            for (int index3 = 0; index3 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 5.0); index3++) {
                                                                if (world instanceof ServerLevel projectileLevelxxx) {
                                                                    Projectile _entityToSpawnxxx = (new Object() {
                                                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                                                                RotPieceEntity entityToSpawn = new RotPieceEntity(
                                                                                    MoreCrittersModEntities.ROT_PIECE.get(), level
                                                                                );
                                                                                entityToSpawn.setOwner(shooter);
                                                                                entityToSpawn.setBaseDamage(damage);
                                                                                entityToSpawn.setKnockback(knockback);
                                                                                entityToSpawn.setSilent(true);
                                                                                return entityToSpawn;
                                                                            }
                                                                        })
                                                                        .getArrow(projectileLevelxxx, entity, 5.0F, 0);
                                                                    _entityToSpawnxxx.setPos(x, y + 3.0, z);
                                                                    _entityToSpawnxxx.shoot(
                                                                        Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                        Mth.nextDouble(RandomSource.create(), 4.0, 45.0),
                                                                        Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                        1.0F,
                                                                        0.0F
                                                                    );
                                                                    projectileLevelxxx.addFreshEntity(_entityToSpawnxxx);
                                                                }
                                                            }

                                                            MoreCritters.queueServerWork(
                                                                5,
                                                                () -> {
                                                                    if (!world.isClientSide() && world instanceof Level _level) {
                                                                        if (!_level.isClientSide()) {
                                                                            _level.playSound(
                                                                                (Player)null,
                                                                                BlockPos.containing(x, y, z),
                                                                                BuiltInRegistries.SOUND_EVENT
                                                                                    .get(ResourceLocation.parse("more_critters:entity.frightshroom.burst")),
                                                                                SoundSource.HOSTILE,
                                                                                2.0F,
                                                                                1.0F
                                                                            );
                                                                        } else {
                                                                            _level.playLocalSound(
                                                                                x,
                                                                                y,
                                                                                z,
                                                                                BuiltInRegistries.SOUND_EVENT
                                                                                    .get(ResourceLocation.parse("more_critters:entity.frightshroom.burst")),
                                                                                SoundSource.HOSTILE,
                                                                                2.0F,
                                                                                1.0F,
                                                                                false
                                                                            );
                                                                        }
                                                                    }

                                                                    for (int index4 = 0;
                                                                        index4 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 5.0);
                                                                        index4++
                                                                    ) {
                                                                        if (world instanceof ServerLevel projectileLevelxxxx) {
                                                                            Projectile _entityToSpawnxxxx = (new Object() {
                                                                                    public Projectile getArrow(
                                                                                        Level level, Entity shooter, float damage, int knockback
                                                                                    ) {
                                                                                        RotPieceEntity entityToSpawn = new RotPieceEntity(
                                                                                            MoreCrittersModEntities.ROT_PIECE.get(), level
                                                                                        );
                                                                                        entityToSpawn.setOwner(shooter);
                                                                                        entityToSpawn.setBaseDamage(damage);
                                                                                        entityToSpawn.setKnockback(knockback);
                                                                                        entityToSpawn.setSilent(true);
                                                                                        return entityToSpawn;
                                                                                    }
                                                                                })
                                                                                .getArrow(projectileLevelxxxx, entity, 5.0F, 0);
                                                                            _entityToSpawnxxxx.setPos(x, y + 3.0, z);
                                                                            _entityToSpawnxxxx.shoot(
                                                                                Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                                Mth.nextDouble(RandomSource.create(), 4.0, 45.0),
                                                                                Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                                1.0F,
                                                                                0.0F
                                                                            );
                                                                            projectileLevelxxxx.addFreshEntity(_entityToSpawnxxxx);
                                                                        }
                                                                    }

                                                                    MoreCritters.queueServerWork(
                                                                        5,
                                                                        () -> {
                                                                            for (int index5 = 0;
                                                                                index5 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 5.0);
                                                                                index5++
                                                                            ) {
                                                                                if (world instanceof ServerLevel projectileLevelxxxxx) {
                                                                                    Projectile _entityToSpawnxxxxx = (new Object() {
                                                                                            public Projectile getArrow(
                                                                                                Level level, Entity shooter, float damage, int knockback
                                                                                            ) {
                                                                                                RotPieceEntity entityToSpawn = new RotPieceEntity(
                                                                                                    MoreCrittersModEntities.ROT_PIECE.get(), level
                                                                                                );
                                                                                                entityToSpawn.setOwner(shooter);
                                                                                                entityToSpawn.setBaseDamage(damage);
                                                                                                entityToSpawn.setKnockback(knockback);
                                                                                                entityToSpawn.setSilent(true);
                                                                                                return entityToSpawn;
                                                                                            }
                                                                                        })
                                                                                        .getArrow(projectileLevelxxxxx, entity, 5.0F, 0);
                                                                                    _entityToSpawnxxxxx.setPos(x, y + 3.0, z);
                                                                                    _entityToSpawnxxxxx.shoot(
                                                                                        Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                                        Mth.nextDouble(RandomSource.create(), 4.0, 45.0),
                                                                                        Mth.nextDouble(RandomSource.create(), -90.0, 90.0),
                                                                                        1.0F,
                                                                                        0.0F
                                                                                    );
                                                                                    projectileLevelxxxxx.addFreshEntity(_entityToSpawnxxxxx);
                                                                                }
                                                                            }
                                                                        }
                                                                    );
                                                                }
                                                            );
                                                        }
                                                    );
                                                }
                                            );
                                        }
                                    );
                                }
                            }
                        );
                    } else if (rate == 2.0) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.stomp")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mightshroom.stomp")),
                                    SoundSource.HOSTILE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                        }

                        if (entity instanceof FrightshroomEntity) {
                            ((FrightshroomEntity)entity).setAnimation("stomp");
                        }

                        MoreCritters.queueServerWork(
                            22,
                            () -> {
                                if ((entity instanceof Mob _mobEntxxxxxxx ? _mobEntxxxxxxx.getTarget() : null) instanceof LivingEntity) {
                                    if (world instanceof ServerLevel _level) {
                                        Entity entityToSpawn = MoreCrittersModEntities.ROT_SPLASH
                                            .get()
                                            .spawn(
                                                _level,
                                                BlockPos.containing(
                                                    (entity instanceof Mob _mobEntxxxxxx ? _mobEntxxxxxx.getTarget() : null).getX()
                                                        + Mth.nextDouble(RandomSource.create(), -8.0, 8.0),
                                                    y,
                                                    (entity instanceof Mob _mobEntxxxxx ? _mobEntxxxxx.getTarget() : null).getZ()
                                                        + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                                ),
                                                MobSpawnType.MOB_SUMMONED
                                            );
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (world instanceof ServerLevel _level) {
                                        Entity entityToSpawn = MoreCrittersModEntities.ROT_SPLASH
                                            .get()
                                            .spawn(
                                                _level,
                                                BlockPos.containing(
                                                    (entity instanceof Mob _mobEntxxxx ? _mobEntxxxx.getTarget() : null).getX()
                                                        + Mth.nextDouble(RandomSource.create(), -8.0, 8.0),
                                                    y,
                                                    (entity instanceof Mob _mobEntxxx ? _mobEntxxx.getTarget() : null).getZ()
                                                        + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                                ),
                                                MobSpawnType.MOB_SUMMONED
                                            );
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }

                                    if (world instanceof ServerLevel _level) {
                                        Entity entityToSpawn = MoreCrittersModEntities.ROT_SPLASH
                                            .get()
                                            .spawn(
                                                _level,
                                                BlockPos.containing(
                                                    (entity instanceof Mob _mobEntxx ? _mobEntxx.getTarget() : null).getX()
                                                        + Mth.nextDouble(RandomSource.create(), -8.0, 8.0),
                                                    y,
                                                    (entity instanceof Mob _mobEntx ? _mobEntx.getTarget() : null).getZ()
                                                        + Mth.nextDouble(RandomSource.create(), -8.0, 8.0)
                                                ),
                                                MobSpawnType.MOB_SUMMONED
                                            );
                                        if (entityToSpawn != null) {
                                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                                        }
                                    }
                                }
                            }
                        );
                    }
                }
            }
        }
    }
}
