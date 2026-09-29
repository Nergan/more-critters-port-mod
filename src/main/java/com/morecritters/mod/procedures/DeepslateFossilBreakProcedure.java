package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModEnchantments;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class DeepslateFossilBreakProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate1 = 0.0;
            double rate2 = 0.0;
            if (MoreCrittersModEnchantments.getLevel(
                    Enchantments.SILK_TOUCH, entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY
                )
                != 0) {
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(
                        _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModBlocks.DEEPSLATE_FOSSIL_BLOCK.get())
                    );
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }
            } else if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                rate1 = Mth.nextInt(RandomSource.create(), 1, 3);
                rate2 = Mth.nextInt(RandomSource.create(), 1, 17);

                for (int index0 = 0; index0 < 2; index0++) {
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MoreCrittersModBlocks.DEEPSLATE_FOSSIL_BLOCK.get().defaultBlockState()));
                }

                if (rate1 == 1.0) {
                    if (rate2 == 1.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_1.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 2.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_2.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 3.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_3.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 4.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_4.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 5.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_5.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 6.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_6.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 7.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_7.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 8.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_8.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 9.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_9.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 10.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTER_FOSSIL_10.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 11.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTERLING_FOSSIL_1.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 12.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTERLING_FOSSIL_2.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 13.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.CRITTERLING_FOSSIL_3.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 14.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_1.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 15.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_2.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 16.0) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(
                                _level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_3.get())
                            );
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    } else if (rate2 == 17.0 && world instanceof ServerLevel _level) {
                        ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.PLANT_FOSSIL_4.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }
                }
            }
        }
    }
}
