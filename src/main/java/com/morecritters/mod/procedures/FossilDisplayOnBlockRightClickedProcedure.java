package com.morecritters.mod.procedures;

import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class FossilDisplayOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                .is(ItemTags.create(ResourceLocation.parse("minecraft:fossils")))) {
                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_1.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_1.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var49) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_2.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_2.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var48) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_3.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_3.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var47) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_4.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_4.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var46) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_5.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_5.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var45) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_6.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_6.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var44) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_7.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_7.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var43) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_8.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_8.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var42) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_9.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_9.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var41) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_FOSSIL_10.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_10.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var40) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTERLING_FOSSIL_1.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_11.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var39) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTERLING_FOSSIL_2.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_12.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var38) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTERLING_FOSSIL_3.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_13.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var37) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.PLANT_FOSSIL_1.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_14.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var36) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.PLANT_FOSSIL_2.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_15.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var35) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.PLANT_FOSSIL_3.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_16.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var34) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.PLANT_FOSSIL_4.get()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockState _bs = MoreCrittersModBlocks.FOSSIL_DISPLAY_17.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception var33) {
                            }
                        }
                    }

                    world.setBlock(_bp, _bs, 3);
                    if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                    }
                }
            }
        }
    }
}
