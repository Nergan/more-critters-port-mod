package com.morecritters.mod.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;

public class TreasureChestOpeningOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
                _blockEntity.getPersistentData().putDouble("opening", (new Object() {
                    public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
                    }
                }).getValue(world, BlockPos.containing(x, y, z), "opening") - 1.0);
            }

            if (world instanceof Level _level) {
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
        }

        if ((new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0;
            }
        }).getValue(world, BlockPos.containing(x, y, z), "opening") == 0.0) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 0)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 1)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 2)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 3)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 4)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 5)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 6)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 7)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(
                    _level,
                    x + 0.5,
                    y + 0.7,
                    z + 0.5,
                    (new Object() {
                            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                                AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
                                BlockEntity _ent = world.getBlockEntity(pos);
                                if (_ent != null) {
                                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
_retval.set(capability.getStackInSlot(slotid).copy());
}
                                }

                                return _retval.get();
                            }
                        })
                        .getItemStack(world, BlockPos.containing(x, y, z), 8)
                );
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }

            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockState _bs = MoreCrittersModBlocks.TREASURE_CHEST_OPEN.get().defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                if (_property != null && _bs.getValue(_property) != null) {
                    try {
                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                    } catch (Exception var14) {
                    }
                }
            }

            world.setBlock(_bp, _bs, 3);
            if (!world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.unlid")),
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.unlid")),
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F,
                        false
                    );
                }
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL,
                                new Vec3(x + 0.5, y + 0.5, z + 0.5),
                                Vec2.ZERO,
                                _level,
                                4,
                                "",
                                Component.literal(""),
                                _level.getServer(),
                                null
                            )
                            .withSuppressedOutput(),
                        "/particle minecraft:cloud ~ ~ ~ 0.5 0 0.5 0.02 10 force"
                    );
            }

            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(MoreCrittersModBlocks.TREASURE_CHEST.get().defaultBlockState()));
            if (!world.isClientSide()) {
                _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                _bso = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    _blockEntity.getPersistentData().putDouble("break", 40.0);
                }

                if (world instanceof Level _level) {
                    _level.sendBlockUpdated(_bp, _bso, _bso, 3);
                }
            }
        }
    }
}
