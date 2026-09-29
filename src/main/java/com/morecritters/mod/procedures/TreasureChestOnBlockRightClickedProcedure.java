package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import io.netty.buffer.Unpooled;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.world.inventory.TreasureChestGuiMenu;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TreasureChestOnBlockRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.TREASURE_KEY.get()) {
                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockState _bs = MoreCrittersModBlocks.TREASURE_CHEST_OPENING.get().defaultBlockState();
                BlockState _bso = world.getBlockState(_bp);
                for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                    if (_property != null && _bs.getValue(_property) != null) {
                        try {
                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                        } catch (Exception var17) {
                        }
                    }
                }

                BlockEntity _be = world.getBlockEntity(_bp);
                CompoundTag _bnbt = null;
                if (_be != null) {
                    _bnbt = _be.saveWithFullMetadata(world.registryAccess());
                    _be.setRemoved();
                }

                world.setBlock(_bp, _bs, 3);
                if (_bnbt != null) {
                    BlockEntity var32 = world.getBlockEntity(_bp);
                    if (var32 != null) {
                        try {
                            var32.loadWithComponents(_bnbt, world.registryAccess());
                        } catch (Exception var16) {
                        }
                    }
                }

                if (!world.isClientSide() && world instanceof Level _levelx) {
                    if (!_levelx.isClientSide()) {
                        _levelx.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.unlock")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _levelx.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.unlock")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (!world.isClientSide()) {
                    _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    _bso = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("opening", 20.0);
                    }

                    if (world instanceof Level _levelx) {
                        _levelx.sendBlockUpdated(_bp, _bso, _bso, 3);
                    }
                }

                if (world instanceof ServerLevel _levelx) {
                    _levelx.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    new Vec3(x + 0.5, y + 0.5, z + 0.5),
                                    Vec2.ZERO,
                                    _levelx,
                                    4,
                                    "",
                                    Component.literal(""),
                                    _levelx.getServer(),
                                    null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:dust{color:[1.0,0.0,0.0],scale:1.0} ~ ~ ~ 0.5 0.2 0.5 1 5 force"
                        );
                }

                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
            } else if (entity instanceof Player _plr && _plr.getAbilities().instabuild) {
                if (entity instanceof ServerPlayer _ent) {
                    final BlockPos _bpos = BlockPos.containing(x, y, z);
                    _ent.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.literal("TreasureChestGui");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            return new TreasureChestGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                        }
                    }, _bpos);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.open")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.open")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            } else {
                if (entity instanceof Player _player && !_player.level().isClientSide()) {
                    _player.displayClientMessage(Component.literal("This Chest is locked"), true);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.refuse")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.refuse")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }
        }
    }
}
