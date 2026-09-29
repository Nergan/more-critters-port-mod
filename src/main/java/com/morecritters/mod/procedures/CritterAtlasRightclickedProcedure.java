package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import io.netty.buffer.Unpooled;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.world.inventory.CritterAtlasRootPageMenu;
import com.morecritters.mod.world.inventory.CritterAtlasViewMenu;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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

public class CritterAtlasRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.isShiftKeyDown()) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_ATLAS.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == MoreCrittersModItems.CRITTER_ATLAS.get()
                    && entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.OFF_HAND, true);
                }

                if (entity instanceof ServerPlayer _ent) {
                    final BlockPos _bpos = BlockPos.containing(x, y, z);
                    _ent.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.literal("CritterAtlasView");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            return new CritterAtlasViewMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                        }
                    }, _bpos);
                }
            } else {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.PLAYERS, 1.0F, 1.0F, false
                        );
                    }
                }

                if (entity instanceof ServerPlayer _ent) {
                    final BlockPos _bpos = BlockPos.containing(x, y, z);
                    _ent.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            return Component.literal("CritterAtlasRootPage");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            return new CritterAtlasRootPageMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                        }
                    }, _bpos);
                }

                if (entity instanceof ServerPlayer _player) {
                    AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:open_critter_atlas"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }

                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                    == MoreCrittersModItems.CRITTER_ATLAS.get()) {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == MoreCrittersModItems.CRITTER_ATLAS.get()
                    && entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.OFF_HAND, true);
                }
            }
        }
    }
}
