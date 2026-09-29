package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.BunbugEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class BunbugOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double breeding_chance = 0.0;
            boolean bred = false;
            if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                for (int index0 = 0; index0 < (int)ServerConfig.CONFIG.bunbugBirth.get().doubleValue(); index0++) {
                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = MoreCrittersModEntities.BABY_BUNBUG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                            entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                        }
                    }
                }
            }

            if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 0
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 0
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 0) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_0_0_0");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 0
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 0) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_1_0_0");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 2
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 0
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 0) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_2_0_0");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 0) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_1_1_0");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 2
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 0) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_2_1_0");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 1) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_1_1_1");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 2) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_1_1_2");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 3) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_1_1_3");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 2
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 1) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_2_1_1");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 2
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 2) {
                if (entity instanceof BunbugEntity animatable) {
                    animatable.setTexture("bunbug_2_1_2");
                }
            } else if ((entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 2
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                && (entity instanceof BunbugEntity _datEntI ? _datEntI.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 3
                && entity instanceof BunbugEntity animatable) {
                animatable.setTexture("bunbug_2_1_3");
            }

            entity.getPersistentData().putDouble("shed", entity.getPersistentData().getDouble("shed") - 1.0);
            if (entity.getPersistentData().getDouble("shed") <= 0.0) {
                entity.getPersistentData().putDouble("shed", Mth.nextDouble(RandomSource.create(), 45000.0, 64000.0));
                if (entity.onGround()) {
                    entity.setDeltaMovement(new Vec3(0.0, 0.2, 0.0));
                }

                MoreCritters.queueServerWork(
                    5,
                    () -> {
                        label404:
                        if ((
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing)
                                        : 0
                                )
                                == 0
                            && (entity instanceof BunbugEntity _datEntIxxxxxx ? _datEntIxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 0
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries)
                                        : 0
                                )
                                == 0) {
                            int index1 = 0;

                            while (true) {
                                if (index1 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST.get()));
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index1++;
                            }
                        } else if ((
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing)
                                        : 0
                                )
                                == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles)
                                        : 0
                                )
                                == 0
                            && (entity instanceof BunbugEntity _datEntIxxxxx ? _datEntIxxxxx.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 0) {
                            int index2 = 0;

                            while (true) {
                                if (index2 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_SUGAR.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index2++;
                            }
                        } else if ((
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing)
                                        : 0
                                )
                                == 2
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles)
                                        : 0
                                )
                                == 0
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries)
                                        : 0
                                )
                                == 0) {
                            int index3 = 0;

                            while (true) {
                                if (index3 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_CHOCOLATE.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index3++;
                            }
                        } else if ((entity instanceof BunbugEntity _datEntIxxxx ? _datEntIxxxx.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 1
                            && (entity instanceof BunbugEntity _datEntIxxxxxxxxxxxx ? _datEntIxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0)
                                == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries)
                                        : 0
                                )
                                == 0) {
                            int index4 = 0;

                            while (true) {
                                if (index4 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_SUGAR_SPRINKLED.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index4++;
                            }
                        } else if ((
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing)
                                        : 0
                                )
                                == 2
                            && (entity instanceof BunbugEntity _datEntIxxx ? _datEntIxxx.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                            && (entity instanceof BunbugEntity _datEntIxxxxxxxxxxx ? _datEntIxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries) : 0)
                                == 0) {
                            int index5 = 0;

                            while (true) {
                                if (index5 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index5++;
                            }
                        } else if ((
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing)
                                        : 0
                                )
                                == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles)
                                        : 0
                                )
                                == 1
                            && (entity instanceof BunbugEntity _datEntIxx ? _datEntIxx.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 1) {
                            int index6 = 0;

                            while (true) {
                                if (index6 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_SUGAR_SPRINKLED_SWEET_BERRIES.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index6++;
                            }
                        } else if ((entity instanceof BunbugEntity _datEntIxxxxxxxxxx ? _datEntIxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing) : 0)
                                == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles)
                                        : 0
                                )
                                == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries)
                                        : 0
                                )
                                == 2) {
                            int index7 = 0;

                            while (true) {
                                if (index7 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_SUGAR_SPRINKLED_GLOW_BERRIES.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index7++;
                            }
                        } else if ((entity instanceof BunbugEntity _datEntIx ? _datEntIx.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 1
                            && (entity instanceof BunbugEntity _datEntIxxxxxxxxx ? _datEntIxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles) : 0) == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries)
                                        : 0
                                )
                                == 3) {
                            int index8 = 0;

                            while (true) {
                                if (index8 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_SUGAR_SPRINKLED_BOUNCEBERRIES.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index8++;
                            }
                        } else if ((
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing)
                                        : 0
                                )
                                == 2
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles)
                                        : 0
                                )
                                == 1
                            && (entity instanceof BunbugEntity _datEntIxxxxxxxx ? _datEntIxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries) : 0) == 1) {
                            int index9 = 0;

                            while (true) {
                                if (index9 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED_SWEET_BERRIES.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index9++;
                            }
                        } else if ((
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing)
                                        : 0
                                )
                                == 2
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles)
                                        : 0
                                )
                                == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries)
                                        : 0
                                )
                                == 2) {
                            int index10 = 0;

                            while (true) {
                                if (index10 >= (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0)) {
                                    break label404;
                                }

                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED_GLOW_BERRIES.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }

                                index10++;
                            }
                        } else if ((entity instanceof BunbugEntity _datEntIxxxxxxx ? _datEntIxxxxxxx.getEntityData().get(BunbugEntity.DATA_icing) : 0) == 2
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_sprinkles)
                                        : 0
                                )
                                == 1
                            && (
                                    entity instanceof BunbugEntity _datEntIxxxxxxxxxxxxxxxxxxxxxxx
                                        ? _datEntIxxxxxxxxxxxxxxxxxxxxxxx.getEntityData().get(BunbugEntity.DATA_berries)
                                        : 0
                                )
                                == 3) {
                            for (int index11 = 0; index11 < (int)Mth.nextDouble(RandomSource.create(), 1.0, 3.0); index11++) {
                                if (world instanceof ServerLevel _level) {
                                    ItemEntity entityToSpawn = new ItemEntity(
                                        _level, x, y, z, new ItemStack(MoreCrittersModItems.BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED_BOUNCEBERRIES.get())
                                    );
                                    entityToSpawn.setPickUpDelay(10);
                                    _level.addFreshEntity(entityToSpawn);
                                }
                            }
                        }

                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.shed")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.shed")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    }
                );
            }
        }
    }
}
