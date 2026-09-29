package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.RamchuFryEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class RamchuFryTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.getPersistentData().putDouble("grow", entity.getPersistentData().getDouble("grow") - 1.0);
            if (entity.getPersistentData().getDouble("grow") == 0.0) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.RAMCHU.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }
            }

            if (entity.isInWaterOrBubble()) {
                entity.getPersistentData().putDouble("air", 200.0);
                if (entity instanceof RamchuFryEntity) {
                    ((RamchuFryEntity)entity).setAnimation("empty");
                }
            } else {
                entity.getPersistentData().putDouble("air", entity.getPersistentData().getDouble("air") - 1.0);
                if (entity instanceof RamchuFryEntity) {
                    ((RamchuFryEntity)entity).setAnimation("land");
                }

                if (entity.onGround()) {
                    entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.2, 0.2), 0.3, Mth.nextDouble(RandomSource.create(), -0.2, 0.2)));
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.tropical_fish.flop")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.tropical_fish.flop")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("air") <= 1.0) {
                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)), 1.0F);
                entity.getPersistentData().putDouble("air", 20.0);
            }
        }
    }
}
