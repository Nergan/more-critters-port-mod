package com.morecritters.mod.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;
import com.morecritters.mod.entity.CannonBallProjectileEntity;
import com.morecritters.mod.entity.ColdCannonBallProjectileEntity;
import com.morecritters.mod.entity.CombustingCannonBallProjectileEntity;
import com.morecritters.mod.entity.ElectricCannonBallProjectileEntity;
import com.morecritters.mod.entity.FireCannonBallProjectileEntity;
import com.morecritters.mod.entity.SlimeCannonBallProjectileEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class CannonRedstoneOnProcedure {
    public static void execute(final LevelAccessor world, double x, double y, double z) {
        if (!(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
            }
        }).getValue(world, BlockPos.containing(x, y, z), "shoot")) {
            if ((new Object() {
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
            }).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MoreCrittersModItems.CANNON_BALL.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    int _slotid = 0;
                    int _amount = 1;
                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(0).copy();
                            _stk.shrink(1);
                            ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }
                    }
                }

                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("shoot", true);
                    }

                    if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }

                if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.NORTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                            public Projectile getArrow(Level level, float damage, int knockback) {
                                CannonBallProjectileEntity entityToSpawn = new CannonBallProjectileEntity(MoreCrittersModEntities.CANNON_BALL_PROJECTILE.get(), level);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                return entityToSpawn;
                            }
                        }).getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, -1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index0 = 0; index0 < 15; index0++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.SOUTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                            public Projectile getArrow(Level level, float damage, int knockback) {
                                CannonBallProjectileEntity entityToSpawn = new CannonBallProjectileEntity(MoreCrittersModEntities.CANNON_BALL_PROJECTILE.get(), level);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                return entityToSpawn;
                            }
                        }).getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, 1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index1 = 0; index1 < 15; index1++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.WEST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                            public Projectile getArrow(Level level, float damage, int knockback) {
                                CannonBallProjectileEntity entityToSpawn = new CannonBallProjectileEntity(MoreCrittersModEntities.CANNON_BALL_PROJECTILE.get(), level);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                return entityToSpawn;
                            }
                        }).getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(-1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index2 = 0; index2 < 15; index2++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.EAST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                            public Projectile getArrow(Level level, float damage, int knockback) {
                                CannonBallProjectileEntity entityToSpawn = new CannonBallProjectileEntity(MoreCrittersModEntities.CANNON_BALL_PROJECTILE.get(), level);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                return entityToSpawn;
                            }
                        }).getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index3 = 0; index3 < 15; index3++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                }
            }

            if ((new Object() {
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
            }).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MoreCrittersModItems.INFUSED_CANNON_BALL_COLD.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    int _slotid = 0;
                    int _amount = 1;
                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(0).copy();
                            _stk.shrink(1);
                            ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }
                    }
                }

                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("shoot", true);
                    }

                    if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }

                if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.NORTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ColdCannonBallProjectileEntity entityToSpawn = new ColdCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COLD_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, -1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index4 = 0; index4 < 15; index4++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.SOUTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ColdCannonBallProjectileEntity entityToSpawn = new ColdCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COLD_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, 1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index5 = 0; index5 < 15; index5++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.WEST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ColdCannonBallProjectileEntity entityToSpawn = new ColdCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COLD_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(-1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index6 = 0; index6 < 15; index6++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.EAST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ColdCannonBallProjectileEntity entityToSpawn = new ColdCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COLD_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index7 = 0; index7 < 15; index7++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                }
            }

            if ((new Object() {
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
            }).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MoreCrittersModItems.INFUSED_CANNON_BALL_FIRE.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    int _slotid = 0;
                    int _amount = 1;
                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(0).copy();
                            _stk.shrink(1);
                            ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }
                    }
                }

                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("shoot", true);
                    }

                    if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }

                if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.NORTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    FireCannonBallProjectileEntity entityToSpawn = new FireCannonBallProjectileEntity(
                                        MoreCrittersModEntities.FIRE_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, -1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index8 = 0; index8 < 15; index8++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.SOUTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    FireCannonBallProjectileEntity entityToSpawn = new FireCannonBallProjectileEntity(
                                        MoreCrittersModEntities.FIRE_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, 1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index9 = 0; index9 < 15; index9++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.WEST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    FireCannonBallProjectileEntity entityToSpawn = new FireCannonBallProjectileEntity(
                                        MoreCrittersModEntities.FIRE_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(-1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index10 = 0; index10 < 15; index10++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.EAST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    FireCannonBallProjectileEntity entityToSpawn = new FireCannonBallProjectileEntity(
                                        MoreCrittersModEntities.FIRE_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index11 = 0; index11 < 15; index11++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                }
            }

            if ((new Object() {
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
            }).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MoreCrittersModItems.INFUSED_CANNON_BALL_SLIME.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    int _slotid = 0;
                    int _amount = 1;
                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(0).copy();
                            _stk.shrink(1);
                            ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }
                    }
                }

                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("shoot", true);
                    }

                    if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }

                if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.NORTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    SlimeCannonBallProjectileEntity entityToSpawn = new SlimeCannonBallProjectileEntity(
                                        MoreCrittersModEntities.SLIME_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, -1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index12 = 0; index12 < 15; index12++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.SOUTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    SlimeCannonBallProjectileEntity entityToSpawn = new SlimeCannonBallProjectileEntity(
                                        MoreCrittersModEntities.SLIME_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, 1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index13 = 0; index13 < 15; index13++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.WEST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    SlimeCannonBallProjectileEntity entityToSpawn = new SlimeCannonBallProjectileEntity(
                                        MoreCrittersModEntities.SLIME_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(-1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index14 = 0; index14 < 15; index14++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.EAST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    SlimeCannonBallProjectileEntity entityToSpawn = new SlimeCannonBallProjectileEntity(
                                        MoreCrittersModEntities.SLIME_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index15 = 0; index15 < 15; index15++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                }
            }

            if ((new Object() {
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
            }).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MoreCrittersModItems.INFUSED_CANNON_BALL_ELECTRIC.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    int _slotid = 0;
                    int _amount = 1;
                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(0).copy();
                            _stk.shrink(1);
                            ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }
                    }
                }

                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("shoot", true);
                    }

                    if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }

                if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.NORTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ElectricCannonBallProjectileEntity entityToSpawn = new ElectricCannonBallProjectileEntity(
                                        MoreCrittersModEntities.ELECTRIC_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, -1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index16 = 0; index16 < 15; index16++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.SOUTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ElectricCannonBallProjectileEntity entityToSpawn = new ElectricCannonBallProjectileEntity(
                                        MoreCrittersModEntities.ELECTRIC_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, 1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index17 = 0; index17 < 15; index17++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.WEST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ElectricCannonBallProjectileEntity entityToSpawn = new ElectricCannonBallProjectileEntity(
                                        MoreCrittersModEntities.ELECTRIC_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(-1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index18 = 0; index18 < 15; index18++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.EAST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    ElectricCannonBallProjectileEntity entityToSpawn = new ElectricCannonBallProjectileEntity(
                                        MoreCrittersModEntities.ELECTRIC_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index19 = 0; index19 < 15; index19++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                }
            }

            if ((new Object() {
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
            }).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == MoreCrittersModItems.INFUSED_CANNON_BALL_COMBUSTING.get()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.cannon.fire")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                if (_ent != null) {
                    int _slotid = 0;
                    int _amount = 1;
                    if (_ent.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, _ent.getBlockPos(), null) instanceof IItemHandler capability) {
                        if (capability instanceof IItemHandlerModifiable) {
                            ItemStack _stk = capability.getStackInSlot(0).copy();
                            _stk.shrink(1);
                            ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }
                    }
                }

                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("shoot", true);
                    }

                    if (world instanceof Level _level) {
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                    }
                }

                if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.NORTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    CombustingCannonBallProjectileEntity entityToSpawn = new CombustingCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COMBUSTING_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, -1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index20 = 0; index20 < 15; index20++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z - 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.SOUTH) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    CombustingCannonBallProjectileEntity entityToSpawn = new CombustingCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COMBUSTING_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5);
                        _entityToSpawn.shoot(0.0, 0.0, 1.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index21 = 0; index21 < 15; index21++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 0.0 + 0.5, y + 0.5, z + 1.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.WEST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    CombustingCannonBallProjectileEntity entityToSpawn = new CombustingCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COMBUSTING_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(-1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index22 = 0; index22 < 15; index22++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x - 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                } else if ((new Object() {
                            public Direction getDirection(BlockPos pos) {
                                BlockState _bs = world.getBlockState(pos);
                                Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                if (property != null && _bs.getValue(property) instanceof Direction _dir) {
                                    return _dir;
                                } else if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                                    return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                                } else {
                                    return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)
                                        ? Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE)
                                        : Direction.NORTH;
                                }
                            }
                        })
                        .getDirection(BlockPos.containing(x, y, z))
                    == Direction.EAST) {
                    if (world instanceof ServerLevel projectileLevel) {
                        Projectile _entityToSpawn = (new Object() {
                                public Projectile getArrow(Level level, float damage, int knockback) {
                                    CombustingCannonBallProjectileEntity entityToSpawn = new CombustingCannonBallProjectileEntity(
                                        MoreCrittersModEntities.COMBUSTING_CANNON_BALL_PROJECTILE.get(), level
                                    );
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                }
                            })
                            .getArrow(projectileLevel, 5.0F, 2);
                        _entityToSpawn.setPos(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5);
                        _entityToSpawn.shoot(1.0, 0.0, 0.0, 2.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }

                    for (int index23 = 0; index23 < 15; index23++) {
                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x + 1.0 + 0.5, y + 0.5, z + 0.0 + 0.5),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:large_smoke ~ ~ ~ 0.2 0.2 0.2 0.01 1 force"
                                );
                        }
                    }
                }
            }

            Entity var137 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).stream().sorted((new Object() {
                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (var137 instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:shoot_cannon"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
        }
    }
}
