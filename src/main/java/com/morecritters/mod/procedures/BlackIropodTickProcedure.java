package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.BlackIropodEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class BlackIropodTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.isInWaterOrBubble()) {
                if (!entity.getPersistentData().getBoolean("attack") && ((BlackIropodEntity)entity).animationprocedure.equals("lock")) {
                    if (entity instanceof BlackIropodEntity) {
                        ((BlackIropodEntity)entity).setAnimation("unlock");
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.unlock")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.unlock")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }

                entity.setAirSupply(20);
                if (!entity.onGround()) {
                    entity.setDeltaMovement(new Vec3(0.0, -0.3, 0.0));
                }
            } else {
                if (entity instanceof BlackIropodEntity) {
                    ((BlackIropodEntity)entity).setAnimation("lock");
                }

                if (!((BlackIropodEntity)entity).animationprocedure.equals("lock") && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.lock")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.lock")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }

            entity.getPersistentData().putDouble("hidetimer", entity.getPersistentData().getDouble("hidetimer") - 1.0);
            entity.getPersistentData().putDouble("shed", entity.getPersistentData().getDouble("shed") - 1.0);
            if (entity.getPersistentData().getDouble("hidetimer") <= 0.0
                && entity.isInWaterOrBubble()
                && ((BlackIropodEntity)entity).animationprocedure.equals("lock")) {
                if (entity instanceof BlackIropodEntity) {
                    ((BlackIropodEntity)entity).setAnimation("unlock");
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.unlock")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.unlock")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }

            if (entity.getPersistentData().getDouble("shed") == 1.0) {
                entity.setDeltaMovement(new Vec3(0.0, 0.2, 0.0));
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.shed")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.iropod.shed")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.MOLDED_SHELL.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            }

            if (entity.getPersistentData().getDouble("shed") <= 0.0) {
                entity.getPersistentData().putDouble("shed", 12000.0);
            }
        }
    }
}
